package co.api.trescubos.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Cliente que consume api remoto de trescubos para creacion y emision de bono
 * especifico
 *
 * @author luissuarez
 */
public class Generate {

    /**
     *
     * @return
     */
    public int generateInTrescubos() {

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
            obj.put("created_at", "2021-11-11 19:16:04.898 -0500");
            obj.put("order_channel_id", "channel1");
            obj.put("order_reference", "ref1");
            obj.put("order_signature", "abcde");
            obj.put("gift_currency_iso", "COL");
            obj.put("gift_datetime_to_send", "2021-11-11 19:16:04.898 -0500");
            obj.put("gift_face_value", 100);
            obj.put("gift_merchant_id", "99");
            obj.put("gift_msg", "Este es un mensaje");
            obj.put("gift_program", true);
            obj.put("user_country_code", "COL");
            obj.put("user_email", "email@trescubos.com");
            obj.put("user_first_name", "Nombre Usuario");
            obj.put("user_mobile_country_code", "57");
            obj.put("user_mobile_phone", "3193180219");
            obj.put("receiver_email", "jzamudio@trescubos.com");
            obj.put("receiver_first_name", "Julian");
            obj.put("receiver_mobile_country_code", "57");
            obj.put("receiver_mobile_phone", "3163562860");

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
