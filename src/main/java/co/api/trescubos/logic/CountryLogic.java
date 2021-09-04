package co.api.trescubos.logic;

import co.api.trescubos.entities.CountryEntity;
import co.api.trescubos.persistence.CountryPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB 
 * @author Luis Suarez
 */
@Stateless
public class CountryLogic {
    
    /**
     * Inyeccion del persistence
     */
    @Inject
    private CountryPersistence persistence;
    
    /**
     * Obtener todos los objetos
     * @return 
     */
    public List<CountryEntity> obtenerCountries(){
        List<CountryEntity> countries = persistence.findAll();
        return countries;
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return productoEntity
     */
    public CountryEntity obtenerCountry(Long id){
        CountryEntity producto = persistence.find(id);
        if(producto == null){
            throw new IllegalArgumentException("No existe en la base de datos");
        }
        return producto;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear
     * @param countryCrear
     * @return 
     */
    public CountryEntity crearCountry(CountryEntity countryCrear){
        persistence.create(countryCrear);
        return countryCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     * @param id
     * @param CountryAcualizar
     * @return producto actualizado
     */
    public CountryEntity actualizarCountry (Long id, CountryEntity CountryAcualizar){
        CountryEntity countryUpdate = persistence.update(CountryAcualizar);
        return countryUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto
     * @param id 
     */
    public void eliminarCountry(Long id){
        persistence.remove(id);
    }
}
