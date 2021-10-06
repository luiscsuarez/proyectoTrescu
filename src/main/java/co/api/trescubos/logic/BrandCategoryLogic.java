package co.api.trescubos.logic;

import co.api.trescubos.entities.BrandCategoryEntity;
import co.api.trescubos.persistence.BrandCategoryPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB 
 * @author Luis Suarez
 */
@Stateless
public class BrandCategoryLogic {
    
    /**
     * Inyeccion del persistence
     */
    @Inject
    private BrandCategoryPersistence persistence;
    
    /**
     * Obtener todos los objetos
     * @return 
     */
    public List<BrandCategoryEntity> obtenerBrandCategories(){
        List<BrandCategoryEntity> brandCategories = persistence.findAll();
        return brandCategories;
    }
    
    
    /**
     * Obtener todos los objetos
     * @param category
     * @return 
     */
    public List<BrandCategoryEntity> obtenerEspecificBrandCategories(Long category){
        List<BrandCategoryEntity> brandCategories = persistence.findEspecific(category);
        return brandCategories;
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return brandCategoryEntity
     */
    public BrandCategoryEntity obtenerBrandCategory(Long id){
        BrandCategoryEntity brandCategory = persistence.find(id);
        if(brandCategory == null){
            throw new IllegalArgumentException("No existe en la base de datos");
        }
        return brandCategory;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear
     * @param brandCategoryCrear
     * @return 
     */
    public BrandCategoryEntity crearBrandCategory(BrandCategoryEntity brandCategoryCrear){
        persistence.create(brandCategoryCrear);
        return brandCategoryCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     * @param id
     * @param BrandCategoryAcualizar
     * @return brandCategory actualizado
     */
    public BrandCategoryEntity actualizarBrandCategory (Long id, BrandCategoryEntity BrandCategoryAcualizar){
        BrandCategoryEntity brandCategoryUpdate = persistence.update(BrandCategoryAcualizar);
        return brandCategoryUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto
     * @param id 
     */
    public void eliminarBrandCategory(Long id){
        persistence.remove(id);
    }
}
