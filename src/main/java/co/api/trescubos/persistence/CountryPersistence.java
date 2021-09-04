package co.api.trescubos.persistence;

import co.api.trescubos.entities.CountryEntity;
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
public class CountryPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     * @return lista resultante
     */
    public List<CountryEntity> findAll(){
        Query queryProducto = entityManager.createQuery("select p from countries p");
        return queryProducto.getResultList();
    }
    
    /**
     * Metodo que busca un objeto mediante su id
     * @param id
     * @return objeto encontrado
     */
    public CountryEntity find(Long id){
        return entityManager.find(CountryEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad 
     * @param CountryNew
     * @return Nuevo
     */
    public CountryEntity create(CountryEntity CountryNew){
        entityManager.persist(CountryNew);
        return CountryNew;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad
     * @param countryUpdated
     * @return actualizado
     */
    public CountryEntity update(CountryEntity countryUpdated){
        return entityManager.merge(countryUpdated);
    }
    
    /**
     * Metodo usado para eliminar
     * @param id 
     */
    public void remove(Long id){
        CountryEntity CountryDelet = entityManager.find(CountryEntity.class, id);
        entityManager.remove(CountryDelet);
    }
}
