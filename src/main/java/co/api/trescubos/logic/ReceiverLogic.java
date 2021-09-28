package co.api.trescubos.logic;

import co.api.trescubos.entities.ReceiverEntity;
import co.api.trescubos.persistence.ReceiverPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB 
 * @author Luis Suarez
 */
@Stateless
public class ReceiverLogic {
    
    /**
     * Inyeccion del persistence
     */
    @Inject
    private ReceiverPersistence persistence;
    
    /**
     * Obtener todos los objetos
     * @return 
     */
    public List<ReceiverEntity> obtenerReceivers(){
        List<ReceiverEntity> receivers = persistence.findAll();
        return receivers;
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return receiverEntity
     */
    public ReceiverEntity obtenerReceiver(Long id){
        ReceiverEntity receiver = persistence.find(id);
        if(receiver == null){
            throw new IllegalArgumentException("No existe en la base de datos");
        }
        return receiver;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear
     * @param receiverCrear
     * @return 
     */
    public ReceiverEntity crearReceiver(ReceiverEntity receiverCrear){
        persistence.create(receiverCrear);
        return receiverCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     * @param id
     * @param ReceiverAcualizar
     * @return receiver actualizado
     */
    public ReceiverEntity actualizarReceiver (Long id, ReceiverEntity ReceiverAcualizar){
        ReceiverEntity receiverUpdate = persistence.update(ReceiverAcualizar);
        return receiverUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto
     * @param id 
     */
    public void eliminarReceiver(Long id){
        persistence.remove(id);
    }
}
