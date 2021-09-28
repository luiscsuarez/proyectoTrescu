package co.api.trescubos.persistence;

import co.api.trescubos.entities.ReceiverEntity;
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
public class ReceiverPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     * @return lista resultante
     */
    public List<ReceiverEntity> findAll(){
        Query queryReceiver = entityManager.createQuery("select p from receivers p");
        return queryReceiver.getResultList();
    }
    
    /**
     * Metodo que busca un objeto mediante su id
     * @param id
     * @return objeto encontrado
     */
    public ReceiverEntity find(Long id){
        return entityManager.find(ReceiverEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad 
     * @param ReceiverNew
     * @return Nuevo
     */
    public ReceiverEntity create(ReceiverEntity ReceiverNew){
        entityManager.persist(ReceiverNew);
        return ReceiverNew;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad
     * @param receiverUpdated
     * @return actualizado
     */
    public ReceiverEntity update(ReceiverEntity receiverUpdated){
        return entityManager.merge(receiverUpdated);
    }
    
    /**
     * Metodo usado para eliminar
     * @param id 
     */
    public void remove(Long id){
        ReceiverEntity ReceiverDelet = entityManager.find(ReceiverEntity.class, id);
        entityManager.remove(ReceiverDelet);
    }
}
