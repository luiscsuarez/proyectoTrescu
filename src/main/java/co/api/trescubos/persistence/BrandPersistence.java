package co.api.trescubos.persistence;

import co.api.trescubos.entities.BrandEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad
 *
 * @author Luis Suarez
 */
@Stateless
public class BrandPersistence {

    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;

    /**
     * Metodo que trae todos los datos que se encuentran en la tabla
     *
     * @return lista resultante
     */
    public List<BrandEntity> findAll() {
        Query queryBrand = entityManager.createQuery("select p from brands p where p.enabled = true");
        return queryBrand.getResultList();
    }

    /**
     * Metodo que busca un objeto mediante su id
     *
     * @param id
     * @return objeto encontrado
     */
    public BrandEntity find(Long id) {
        return entityManager.find(BrandEntity.class, id);
    }

    /**
     * Metodo para crear un objeto de la entidad
     *
     * @param BrandNew
     * @return Nuevo
     */
    public BrandEntity create(BrandEntity BrandNew) {
        entityManager.persist(BrandNew);
        return BrandNew;
    }

    /**
     * Metodo para actualizar un dato de la entidad
     *
     * @param brandUpdated
     * @return actualizado
     */
    public BrandEntity update(BrandEntity brandUpdated) {
        return entityManager.merge(brandUpdated);
    }

    /**
     * Metodo usado para eliminar
     *
     * @param id
     */
    public void remove(Long id) {
        BrandEntity BrandDelet = entityManager.find(BrandEntity.class, id);
        entityManager.remove(BrandDelet);
    }
}
