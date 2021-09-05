package co.api.trescubos.logic;

import co.api.trescubos.entities.CurrencyEntity;
import co.api.trescubos.persistence.CurrencyPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB 
 * @author Luis Suarez
 */
@Stateless
public class CurrencyLogic {
    
    /**
     * Inyeccion del persistence
     */
    @Inject
    private CurrencyPersistence persistence;
    
    /**
     * Obtener todos los objetos
     * @return 
     */
    public List<CurrencyEntity> obtenerCurrencies(){
        List<CurrencyEntity> currencies = persistence.findAll();
        return currencies;
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return currencyEntity
     */
    public CurrencyEntity obtenerCurrency(Long id){
        CurrencyEntity currency = persistence.find(id);
        if(currency == null){
            throw new IllegalArgumentException("No existe en la base de datos");
        }
        return currency;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear
     * @param currencyCrear
     * @return 
     */
    public CurrencyEntity crearCurrency(CurrencyEntity currencyCrear){
        persistence.create(currencyCrear);
        return currencyCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     * @param id
     * @param CurrencyAcualizar
     * @return currency actualizado
     */
    public CurrencyEntity actualizarCurrency (Long id, CurrencyEntity CurrencyAcualizar){
        CurrencyEntity currencyUpdate = persistence.update(CurrencyAcualizar);
        return currencyUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto
     * @param id 
     */
    public void eliminarCurrency(Long id){
        persistence.remove(id);
    }
}
