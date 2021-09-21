package co.api.trescubos.resources;


import co.api.trescubos.dto.BrandCategoryDTO;
import co.api.trescubos.entities.BrandCategoryEntity;
import co.api.trescubos.logic.BrandCategoryLogic;
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
@Path("/brand/categories")
public class BrandCategoryResource {
    
    @EJB
    private BrandCategoryLogic brandCategoriesLogic;

    /**
     * Metodo que obtiene todos los datos 
     * @return Lista 
     */
    @GET
    public List<BrandCategoryDTO> getBrandCategoryList(){
        List <BrandCategoryEntity> brandCategories = brandCategoriesLogic.obtenerBrandCategories();
        return BrandCategoryDTO.toBrandCategoryList(brandCategories);
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return BrandCategoryEntity
     */
    @GET
    @Path("{id: \\d+}")
    public BrandCategoryDTO getBrandCategory(@PathParam("id") Long id){
        BrandCategoryEntity brandCategory = brandCategoriesLogic.obtenerBrandCategory(id);
        if (brandCategory == null){
            throw new RuntimeException("No existe");
        } 
        return new BrandCategoryDTO(brandCategory);
    }
    
    @POST
    public BrandCategoryDTO createBrandCategory(BrandCategoryDTO brandCategoryDTO){
        return new BrandCategoryDTO(brandCategoriesLogic.crearBrandCategory(brandCategoryDTO.toEntity()));
    }
    
    
    /**
     * Actualizar 
     * @param id
     * @param brandCategoryDTO
     * @return actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public BrandCategoryDTO updateBrandCategory(@PathParam("id") Long id, BrandCategoryDTO brandCategoryDTO){
        BrandCategoryEntity brandCategoryEntity = brandCategoriesLogic.obtenerBrandCategory(id);
        if(brandCategoryEntity == null){
            throw new RuntimeException("No existe.");
        }
        return new BrandCategoryDTO(brandCategoriesLogic.actualizarBrandCategory(id, brandCategoryDTO.toEntity()));
    }
    
    @DELETE
    @Path("{brandCategoryId: \\d+}")
    public void deleteBrandCategory(@PathParam("brandCategoryId") Long id){
        BrandCategoryEntity brandCategoryEntity = brandCategoriesLogic.obtenerBrandCategory(id);
        if(brandCategoryEntity == null){
            throw new RuntimeException("No existe.");
        }
        brandCategoriesLogic.eliminarBrandCategory(id);
    }
}
