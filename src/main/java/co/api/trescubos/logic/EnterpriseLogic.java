package co.api.trescubos.logic;

import co.api.trescubos.entities.EnterpriseEntity;
import co.api.trescubos.persistence.EnterprisePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB 
 * @author Luis Suarez
 */
@Stateless
public class EnterpriseLogic {
    
    /**
     * Inyeccion del persistence
     */
    @Inject
    private EnterprisePersistence persistence;
    
    /**
     * Obtener todos los objetos
     * @return 
     */
    public List<EnterpriseEntity> obtenerEnterprises(){
        List<EnterpriseEntity> enterprises = persistence.findAll();
        return enterprises;
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return enterpriseEntity
     */
    public EnterpriseEntity obtenerEnterprise(Long id){
        EnterpriseEntity enterprise = persistence.find(id);
        if(enterprise == null){
            throw new IllegalArgumentException("No existe en la base de datos");
        }
        return enterprise;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear
     * @param enterpriseCrear
     * @return 
     */
    public EnterpriseEntity crearEnterprise(EnterpriseEntity enterpriseCrear){
        persistence.create(enterpriseCrear);
        return enterpriseCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     * @param id
     * @param EnterpriseAcualizar
     * @return enterprise actualizado
     */
    public EnterpriseEntity actualizarEnterprise (Long id, EnterpriseEntity EnterpriseAcualizar){
        EnterpriseEntity enterpriseUpdate = persistence.update(EnterpriseAcualizar);
        return enterpriseUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto
     * @param id 
     */
    public void eliminarEnterprise(Long id){
        persistence.remove(id);
    }
}
