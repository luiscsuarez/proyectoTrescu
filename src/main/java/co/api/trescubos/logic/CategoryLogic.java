package co.api.trescubos.logic;

import co.api.trescubos.entities.CategoryEntity;
import co.api.trescubos.persistence.CategoryPersistence;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB 
 * @author Luis Suarez
 */
@Stateless
public class CategoryLogic {
    
    /**
     * Inyeccion del persistence
     */
    @Inject
    private CategoryPersistence persistence;
    
    /**
     * Obtener todos los objetos
     * @return 
     */
    public List<CategoryEntity> obtenerCategories(){
        List<CategoryEntity> categories = persistence.findAll();
        return categories;
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return categoryEntity
     */
    public CategoryEntity obtenerCategory(Long id){
        CategoryEntity category = persistence.find(id);
        if(category == null){
            throw new IllegalArgumentException("No existe en la base de datos");
        }
        return category;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear
     * @param categoryCrear
     * @return 
     */
    public CategoryEntity crearCategory(CategoryEntity categoryCrear){
        categoryCrear.setDateCreated(Date.from(Instant.now()));
        categoryCrear.setDateUpdated(Date.from(Instant.now()));
        persistence.create(categoryCrear);
        return categoryCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     * @param id
     * @param CategoryAcualizar
     * @return category actualizado
     */
    public CategoryEntity actualizarCategory (Long id, CategoryEntity CategoryAcualizar){
        CategoryAcualizar.setDateUpdated(Date.from(Instant.now()));
        CategoryEntity categoryUpdate = persistence.update(CategoryAcualizar);
        return categoryUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto
     * @param id 
     */
    public void eliminarCategory(Long id){
        persistence.remove(id);
    }
}
