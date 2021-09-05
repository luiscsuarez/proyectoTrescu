package co.api.trescubos.persistence;

import co.api.trescubos.entities.EnterpriseUserEntity;
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
public class EnterpriseUserPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     * @return lista resultante
     */
    public List<EnterpriseUserEntity> findAll(){
        Query queryEnterpriseUser = entityManager.createQuery("select p from enterprise_users p");
        return queryEnterpriseUser.getResultList();
    }
    
    public List<EnterpriseUserEntity> validate(String email, String password){
        Query queryEnterpriseUser = entityManager.createQuery("select p from enterprise_users p where p.email = :email and p.password = :password")
                .setParameter("email", email)
                .setParameter("password", password);
        return queryEnterpriseUser.getResultList();
    }
    
    /**
     * Metodo que busca un objeto mediante su id
     * @param id
     * @return objeto encontrado
     */
    public EnterpriseUserEntity find(Long id){
        return entityManager.find(EnterpriseUserEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad 
     * @param EnterpriseUserNew
     * @return Nuevo
     */
    public EnterpriseUserEntity create(EnterpriseUserEntity EnterpriseUserNew){
        entityManager.persist(EnterpriseUserNew);
        return EnterpriseUserNew;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad
     * @param enterpriseUserUpdated
     * @return actualizado
     */
    public EnterpriseUserEntity update(EnterpriseUserEntity enterpriseUserUpdated){
        return entityManager.merge(enterpriseUserUpdated);
    }
    
    /**
     * Metodo usado para eliminar
     * @param id 
     */
    public void remove(Long id){
        EnterpriseUserEntity EnterpriseUserDelet = entityManager.find(EnterpriseUserEntity.class, id);
        entityManager.remove(EnterpriseUserDelet);
    }
}
