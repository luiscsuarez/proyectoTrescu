package co.api.trescubos.resources;


import co.api.trescubos.dto.CountryDTO;
import co.api.trescubos.entities.CountryEntity;
import co.api.trescubos.logic.CountryLogic;
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
@Path("/countries")
public class CountryResource {
    
    @EJB
    private CountryLogic countriesLogic;

    /**
     * Metodo que obtiene todos los datos 
     * @return Lista 
     */
    @GET
    public List<CountryDTO> getCountryList(){
        List <CountryEntity> countries = countriesLogic.obtenerCountries();
        return CountryDTO.toCountryList(countries);
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return CountryEntity
     */
    @GET
    @Path("{id: \\d+}")
    public CountryDTO getCountry(@PathParam("id") Long id){
        CountryEntity country = countriesLogic.obtenerCountry(id);
        if (country == null){
            throw new RuntimeException("No existe");
        } 
        return new CountryDTO(country);
    }
    
    @POST
    public CountryDTO createCountry(CountryDTO countryDTO){
        return new CountryDTO(countriesLogic.crearCountry(countryDTO.toEntity()));
    }
    
    
    /**
     * Actualizar 
     * @param id
     * @param countryDTO
     * @return actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public CountryDTO updateCountry(@PathParam("id") Long id, CountryDTO countryDTO){
        CountryEntity countryEntity = countriesLogic.obtenerCountry(id);
        if(countryEntity == null){
            throw new RuntimeException("No existe.");
        }
        return new CountryDTO(countriesLogic.actualizarCountry(id, countryDTO.toEntity()));
    }
    
    @DELETE
    @Path("{countryId: \\d+}")
    public void deleteCountry(@PathParam("countryId") Long id){
        CountryEntity countryEntity = countriesLogic.obtenerCountry(id);
        if(countryEntity == null){
            throw new RuntimeException("No existe.");
        }
        countriesLogic.eliminarCountry(id);
    }
}
