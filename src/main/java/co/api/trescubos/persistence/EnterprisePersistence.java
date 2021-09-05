package co.api.trescubos.persistence;

import co.api.trescubos.entities.EnterpriseEntity;
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
public class EnterprisePersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     * @return lista resultante
     */
    public List<EnterpriseEntity> findAll(){
        Query queryEnterprise = entityManager.createQuery("select p from enterprises p");
        return queryEnterprise.getResultList();
    }
    
    /**
     * Metodo que busca un objeto mediante su id
     * @param id
     * @return objeto encontrado
     */
    public EnterpriseEntity find(Long id){
        return entityManager.find(EnterpriseEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad 
     * @param EnterpriseNew
     * @return Nuevo
     */
    public EnterpriseEntity create(EnterpriseEntity EnterpriseNew){
        entityManager.persist(EnterpriseNew);
        return EnterpriseNew;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad
     * @param enterpriseUpdated
     * @return actualizado
     */
    public EnterpriseEntity update(EnterpriseEntity enterpriseUpdated){
        return entityManager.merge(enterpriseUpdated);
    }
    
    /**
     * Metodo usado para eliminar
     * @param id 
     */
    public void remove(Long id){
        EnterpriseEntity EnterpriseDelet = entityManager.find(EnterpriseEntity.class, id);
        entityManager.remove(EnterpriseDelet);
    }
}
