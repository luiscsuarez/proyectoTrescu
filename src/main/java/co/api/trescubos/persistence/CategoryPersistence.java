package co.api.trescubos.persistence;

import co.api.trescubos.entities.CategoryEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad 
 * @author Luis Suarez
 */ 
@Stateless
public class CategoryPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     * @return lista resultante
     */
    public List<CategoryEntity> findAll(){
        Query queryCategory = entityManager.createQuery("select p from categories p");
        return queryCategory.getResultList();
    }
    
    /**
     * Metodo que busca un objeto mediante su id
     * @param id
     * @return objeto encontrado
     */
    public CategoryEntity find(Long id){
        return entityManager.find(CategoryEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad 
     * @param CategoryNew
     * @return Nuevo
     */
    public CategoryEntity create(CategoryEntity CategoryNew){
        entityManager.persist(CategoryNew);
        return CategoryNew;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad
     * @param categoryUpdated
     * @return actualizado
     */
    public CategoryEntity update(CategoryEntity categoryUpdated){
        return entityManager.merge(categoryUpdated);
    }
    
    /**
     * Metodo usado para eliminar
     * @param id 
     */
    public void remove(Long id){
        CategoryEntity CategoryDelet = entityManager.find(CategoryEntity.class, id);
        entityManager.remove(CategoryDelet);
    }
}
