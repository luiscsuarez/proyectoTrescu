package co.api.trescubos.logic;

import co.api.trescubos.entities.BrandEntity;
import co.api.trescubos.persistence.BrandPersistence;
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
public class BrandLogic {
    
    /**
     * Inyeccion del persistence
     */
    @Inject
    private BrandPersistence persistence;
    
    /**
     * Obtener todos los objetos
     * @return 
     */
    public List<BrandEntity> obtenerBrands(){
        List<BrandEntity> brands = persistence.findAll();
        return brands;
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return brandEntity
     */
    public BrandEntity obtenerBrand(Long id){
        BrandEntity brand = persistence.find(id);
        if(brand == null){
            throw new IllegalArgumentException("No existe en la base de datos");
        }
        return brand;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear
     * @param brandCrear
     * @return 
     */
    public BrandEntity crearBrand(BrandEntity brandCrear){
        brandCrear.setDateCreated(Date.from(Instant.now()));
        brandCrear.setDateUpdated(Date.from(Instant.now()));
        persistence.create(brandCrear);
        return brandCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     * @param id
     * @param BrandAcualizar
     * @return brand actualizado
     */
    public BrandEntity actualizarBrand (Long id, BrandEntity BrandAcualizar){
        BrandAcualizar.setDateUpdated(Date.from(Instant.now()));
        BrandEntity brandUpdate = persistence.update(BrandAcualizar);
        return brandUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto
     * @param id 
     */
    public void eliminarBrand(Long id){
        persistence.remove(id);
    }
}
