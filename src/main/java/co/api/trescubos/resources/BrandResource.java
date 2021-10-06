package co.api.trescubos.resources;


import co.api.trescubos.dto.BrandDTO;
import co.api.trescubos.entities.BrandEntity;
import co.api.trescubos.logic.BrandLogic;
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
@Path("/brands")
public class BrandResource {
    
    @EJB
    private BrandLogic brandsLogic;

    /**
     * Metodo que obtiene todos los datos 
     * @return Lista 
     */
    @GET
    public List<BrandDTO> getBrandList(){
        List <BrandEntity> brands = brandsLogic.obtenerBrands();
        return BrandDTO.toBrandList(brands);
    }
    
      /**
     * Metodo que obtiene todos los datos 
     * @param category
     * @return Lista 
     */
    @GET
    @Path("is/{category}")
    public List<BrandDTO> getEspecificBrandList(@PathParam("category") Long category){
        List <BrandEntity> brands = brandsLogic.obtenerEspecificBrands(category);
        return BrandDTO.toBrandList(brands);
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return BrandEntity
     */
    @GET
    @Path("{id: \\d+}")
    public BrandDTO getBrand(@PathParam("id") Long id){
        BrandEntity brand = brandsLogic.obtenerBrand(id);
        if (brand == null){
            throw new RuntimeException("No existe");
        } 
        return new BrandDTO(brand);
    }
    
    @POST
    public BrandDTO createBrand(BrandDTO brandDTO){
        return new BrandDTO(brandsLogic.crearBrand(brandDTO.toEntity()));
    }
    
    
    /**
     * Actualizar 
     * @param id
     * @param brandDTO
     * @return actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public BrandDTO updateBrand(@PathParam("id") Long id, BrandDTO brandDTO){
        BrandEntity brandEntity = brandsLogic.obtenerBrand(id);
        if(brandEntity == null){
            throw new RuntimeException("No existe.");
        }
        return new BrandDTO(brandsLogic.actualizarBrand(id, brandDTO.toEntity()));
    }
    
    @DELETE
    @Path("{brandId: \\d+}")
    public void deleteBrand(@PathParam("brandId") Long id){
        BrandEntity brandEntity = brandsLogic.obtenerBrand(id);
        if(brandEntity == null){
            throw new RuntimeException("No existe.");
        }
        brandsLogic.eliminarBrand(id);
    }
}
