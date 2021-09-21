package co.api.trescubos.resources;


import co.api.trescubos.dto.CategoryDTO;
import co.api.trescubos.entities.CategoryEntity;
import co.api.trescubos.logic.CategoryLogic;
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
@Path("/categories")
public class CategoryResource {
    
    @EJB
    private CategoryLogic categoriesLogic;

    /**
     * Metodo que obtiene todos los datos 
     * @return Lista 
     */
    @GET
    public List<CategoryDTO> getCategoryList(){
        List <CategoryEntity> categories = categoriesLogic.obtenerCategories();
        return CategoryDTO.toCategoryList(categories);
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return CategoryEntity
     */
    @GET
    @Path("{id: \\d+}")
    public CategoryDTO getCategory(@PathParam("id") Long id){
        CategoryEntity category = categoriesLogic.obtenerCategory(id);
        if (category == null){
            throw new RuntimeException("No existe");
        } 
        return new CategoryDTO(category);
    }
    
    @POST
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        return new CategoryDTO(categoriesLogic.crearCategory(categoryDTO.toEntity()));
    }
    
    
    /**
     * Actualizar 
     * @param id
     * @param categoryDTO
     * @return actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public CategoryDTO updateCategory(@PathParam("id") Long id, CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = categoriesLogic.obtenerCategory(id);
        if(categoryEntity == null){
            throw new RuntimeException("No existe.");
        }
        return new CategoryDTO(categoriesLogic.actualizarCategory(id, categoryDTO.toEntity()));
    }
    
    @DELETE
    @Path("{categoryId: \\d+}")
    public void deleteCategory(@PathParam("categoryId") Long id){
        CategoryEntity categoryEntity = categoriesLogic.obtenerCategory(id);
        if(categoryEntity == null){
            throw new RuntimeException("No existe.");
        }
        categoriesLogic.eliminarCategory(id);
    }
}
