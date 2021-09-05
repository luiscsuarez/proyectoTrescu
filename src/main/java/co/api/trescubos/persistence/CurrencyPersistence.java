package co.api.trescubos.persistence;

import co.api.trescubos.entities.CurrencyEntity;
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
public class CurrencyPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     * @return lista resultante
     */
    public List<CurrencyEntity> findAll(){
        Query queryCurrency = entityManager.createQuery("select p from currencies p");
        return queryCurrency.getResultList();
    }
    
    /**
     * Metodo que busca un objeto mediante su id
     * @param id
     * @return objeto encontrado
     */
    public CurrencyEntity find(Long id){
        return entityManager.find(CurrencyEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad 
     * @param CurrencyNew
     * @return Nuevo
     */
    public CurrencyEntity create(CurrencyEntity CurrencyNew){
        entityManager.persist(CurrencyNew);
        return CurrencyNew;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad
     * @param currencyUpdated
     * @return actualizado
     */
    public CurrencyEntity update(CurrencyEntity currencyUpdated){
        return entityManager.merge(currencyUpdated);
    }
    
    /**
     * Metodo usado para eliminar
     * @param id 
     */
    public void remove(Long id){
        CurrencyEntity CurrencyDelet = entityManager.find(CurrencyEntity.class, id);
        entityManager.remove(CurrencyDelet);
    }
}
