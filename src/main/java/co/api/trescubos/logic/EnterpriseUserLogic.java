package co.api.trescubos.logic;

import co.api.trescubos.entities.EnterpriseUserEntity;
import co.api.trescubos.persistence.EnterpriseUserPersistence;
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
public class EnterpriseUserLogic {
    
    /**
     * Inyeccion del persistence
     */
    @Inject
    private EnterpriseUserPersistence persistence;
    
    /**
     * Obtener todos los objetos
     * @return 
     */
    public List<EnterpriseUserEntity> obtenerEnterpriseUsers(){
        List<EnterpriseUserEntity> enterpriseUsers = persistence.findAll();
        return enterpriseUsers;
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return enterpriseUserEntity
     */
    public EnterpriseUserEntity obtenerEnterpriseUser(Long id){
        EnterpriseUserEntity enterpriseUser = persistence.find(id);
        if(enterpriseUser == null){
            throw new IllegalArgumentException("No existe en la base de datos");
        }
        return enterpriseUser;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear
     * @param enterpriseUserCrear
     * @return 
     */
    public EnterpriseUserEntity crearEnterpriseUser(EnterpriseUserEntity enterpriseUserCrear){
        enterpriseUserCrear.setBalance(0.00);
        enterpriseUserCrear.setDateCreated(Date.from(Instant.now()));
        enterpriseUserCrear.setDateUpdated(Date.from(Instant.now()));
        persistence.create(enterpriseUserCrear);
        return enterpriseUserCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     * @param id
     * @param EnterpriseUserAcualizar
     * @return enterpriseUser actualizado
     */
    public EnterpriseUserEntity actualizarEnterpriseUser (Long id, EnterpriseUserEntity EnterpriseUserAcualizar){
        EnterpriseUserAcualizar.setDateUpdated(Date.from(Instant.now()));
        EnterpriseUserEntity enterpriseUserUpdate = persistence.update(EnterpriseUserAcualizar);
        return enterpriseUserUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto
     * @param id 
     */
    public void eliminarEnterpriseUser(Long id){
        persistence.remove(id);
    }
}
