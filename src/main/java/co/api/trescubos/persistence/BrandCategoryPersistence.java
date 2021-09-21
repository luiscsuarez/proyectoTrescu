package co.api.trescubos.persistence;

import co.api.trescubos.entities.BrandCategoryEntity;
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
public class BrandCategoryPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     * @return lista resultante
     */
    public List<BrandCategoryEntity> findAll(){
        Query queryBrandCategory = entityManager.createQuery("select p from brand_categories p");
        return queryBrandCategory.getResultList();
    }
    
    /**
     * Metodo que busca un objeto mediante su id
     * @param id
     * @return objeto encontrado
     */
    public BrandCategoryEntity find(Long id){
        return entityManager.find(BrandCategoryEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad 
     * @param BrandCategoryNew
     * @return Nuevo
     */
    public BrandCategoryEntity create(BrandCategoryEntity BrandCategoryNew){
        entityManager.persist(BrandCategoryNew);
        return BrandCategoryNew;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad
     * @param brandCategoryUpdated
     * @return actualizado
     */
    public BrandCategoryEntity update(BrandCategoryEntity brandCategoryUpdated){
        return entityManager.merge(brandCategoryUpdated);
    }
    
    /**
     * Metodo usado para eliminar
     * @param id 
     */
    public void remove(Long id){
        BrandCategoryEntity BrandCategoryDelet = entityManager.find(BrandCategoryEntity.class, id);
        entityManager.remove(BrandCategoryDelet);
    }
}
