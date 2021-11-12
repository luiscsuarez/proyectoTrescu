package co.api.trescubos.persistence;

import co.api.trescubos.entities.TransactionEntity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Clase manejadora de la transaccionalidad de la entidad
 *
 * @author Luis Suarez
 */
@Stateless
public class TransactionPersistence {

    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;

    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     *
     * @return lista resultante
     */
    public List<TransactionEntity> findAll() {
        Query queryTransaction = entityManager.createQuery("select p from transactions p");
        return queryTransaction.getResultList();
    }

    /**
     * Metodo que busca un objeto mediante su id
     *
     * @param id
     * @return objeto encontrado
     */
    public TransactionEntity find(Long id) {
        return entityManager.find(TransactionEntity.class, id);
    }

    /**
     * Metodo para crear un objeto de la entidad
     *
     * @param TransactionNew
     * @return Nuevo
     */
    public TransactionEntity create(TransactionEntity TransactionNew) {
        Query balance = entityManager.createQuery("select p.balance from enterprise_users p where p.id = :id ").setParameter("id", TransactionNew.getUserId().getId());
        TransactionNew.setPreviousBalance(Double.parseDouble(balance.getSingleResult().toString()));
        TransactionNew.setNewBalance(TransactionNew.getAmount() + Double.parseDouble(balance.getSingleResult().toString()));
        if (TransactionNew.getAmount() > 0) {
            TransactionNew.setType("CREDIT");
        } else {
            TransactionNew.setType("DEBIT");
        }
        Query balanceUpdate = entityManager.createQuery("update enterprise_users p set p.balance = :balance  where p.id = :id ")
                .setParameter("id", TransactionNew.getUserId().getId())
                .setParameter("balance", TransactionNew.getAmount() + Double.parseDouble(balance.getSingleResult().toString()));
        if (generateInTrescubos(TransactionNew) == HttpURLConnection.HTTP_OK) {
            entityManager.persist(TransactionNew);
            balanceUpdate.executeUpdate();
            return TransactionNew;
        }
        return null;
    }

    /**
     * Metodo para actualizar un dato de la entidad
     *
     * @param transactionUpdated
     * @return actualizado
     */
    public TransactionEntity update(TransactionEntity transactionUpdated) {
        return entityManager.merge(transactionUpdated);
    }

    /**
     * Metodo usado para eliminar
     *
     * @param id
     */
    public void remove(Long id) {
        TransactionEntity TransactionDelet = entityManager.find(TransactionEntity.class, id);
        entityManager.remove(TransactionDelet);
    }

    public int generateInTrescubos(TransactionEntity TransactionNew) {

        JSONObject obj = new JSONObject();

        //Aca se declara la url de conexion
        String backendV1 = "https://x8ki-letl-twmt.n7.xano.io/api:w5ENorOL/gift_requests";

        //Llave de conexion
        //String value =  App.MERCHANT_API_KEY;
        try {
            //Bloque de parametros del request
            URL url = new URL(backendV1);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            //urlConnection.setRequestProperty("Authorization",value);
            urlConnection.addRequestProperty("content-type", "application/json");

            //Bloque de datos que se agregan al request, (Pueden Variar)
            obj.put("created_at", TransactionNew.getDateCreated());
            obj.put("order_channel_id", "app web v2");
            obj.put("order_reference", TransactionNew.getToken());
            obj.put("order_signature", TransactionNew.getToken());
            obj.put("gift_currency_iso", TransactionNew.getCurrencyId().getCurrencyCode());
            if (TransactionNew.getReceiverId().getDateShipping()!= null){
                obj.put("gift_datetime_to_send", TransactionNew.getReceiverId().getDateShipping());
                obj.put("gift_program", true);
            }else{
                obj.put("gift_program", false);
            }
            obj.put("gift_face_value", TransactionNew.getAmount());
            obj.put("gift_merchant_id", TransactionNew.getBrandId());
            obj.put("gift_msg", TransactionNew.getReceiverId().getMessage());
            obj.put("user_country_code", TransactionNew.getUserId().getEnterpriseId().getCountryId().getCountryCode());
            obj.put("user_email", TransactionNew.getUserId().getEmail());
            obj.put("user_first_name", TransactionNew.getUserId().getFullName());
            obj.put("user_mobile_country_code", "57");
            obj.put("user_mobile_phone", TransactionNew.getUserId().getPhone());
            obj.put("receiver_email", TransactionNew.getReceiverId().getEmail());
            obj.put("receiver_first_name", TransactionNew.getReceiverId().getFullName());
            obj.put("receiver_mobile_country_code", "57");
            obj.put("receiver_mobile_phone", TransactionNew.getReceiverId().getPhone());

            //Se parcea objeto Json a Objeto String
            String input = obj.toString();

            //Se realiza la peticion
            OutputStream os = urlConnection.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            //Se evalua la respuesta si tiene un http response diferente a 200 ok y retorna el error
            if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println(urlConnection.getResponseMessage());
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
                JSONObject jsonObject = (JSONObject) JSONValue.parse(br.readLine());
                System.out.println(jsonObject.toJSONString());
                throw new RuntimeException("Failed : HTTP error code : " + urlConnection.getResponseCode());
            }

            //Lee la respuesta cuando es 200
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            //Se parsea la respuesta para imprimirla en un String via consola
            JSONObject jsonObject = (JSONObject) JSONValue.parse(br.readLine());
            System.out.println(jsonObject.toJSONString());

            //de esta manera se obtiene cualquier dato del json de respuesta para guardar y/o mostrar
            //App.AUTHORIZATION_CODE = (String) jsonObject.get("authorization_code");
            //System.out.println("Autorizacion: " + App.AUTHORIZATION_CODE);
            return urlConnection.getResponseCode();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
