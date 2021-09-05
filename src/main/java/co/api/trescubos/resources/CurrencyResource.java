package co.api.trescubos.resources;


import co.api.trescubos.dto.CurrencyDTO;
import co.api.trescubos.entities.CurrencyEntity;
import co.api.trescubos.logic.CurrencyLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Recurso API
 * @author Luis Suarez
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/currencies")
public class CurrencyResource {
    
    @EJB
    private CurrencyLogic currenciesLogic;

    /**
     * Metodo que obtiene todos los datos 
     * @return Lista 
     */
    @GET
    public List<CurrencyDTO> getCurrencyList(){
        List <CurrencyEntity> currencies = currenciesLogic.obtenerCurrencies();
        return CurrencyDTO.toCurrencyList(currencies);
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return CurrencyEntity
     */
    @GET
    @Path("{id: \\d+}")
    public CurrencyDTO getCurrency(@PathParam("id") Long id){
        CurrencyEntity currency = currenciesLogic.obtenerCurrency(id);
        if (currency == null){
            throw new RuntimeException("No existe");
        } 
        return new CurrencyDTO(currency);
    }
    
    @POST
    public CurrencyDTO createCurrency(CurrencyDTO currencyDTO){
        return new CurrencyDTO(currenciesLogic.crearCurrency(currencyDTO.toEntity()));
    }
    
    
    /**
     * Actualizar 
     * @param id
     * @param currencyDTO
     * @return actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public CurrencyDTO updateCurrency(@PathParam("id") Long id, CurrencyDTO currencyDTO){
        CurrencyEntity currencyEntity = currenciesLogic.obtenerCurrency(id);
        if(currencyEntity == null){
            throw new RuntimeException("No existe.");
        }
        return new CurrencyDTO(currenciesLogic.actualizarCurrency(id, currencyDTO.toEntity()));
    }
    
    @DELETE
    @Path("{currencyId: \\d+}")
    public void deleteCurrency(@PathParam("currencyId") Long id){
        CurrencyEntity currencyEntity = currenciesLogic.obtenerCurrency(id);
        if(currencyEntity == null){
            throw new RuntimeException("No existe.");
        }
        currenciesLogic.eliminarCurrency(id);
    }
}
