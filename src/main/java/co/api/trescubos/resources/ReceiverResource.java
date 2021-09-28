package co.api.trescubos.resources;


import co.api.trescubos.dto.ReceiverDTO;
import co.api.trescubos.entities.ReceiverEntity;
import co.api.trescubos.logic.ReceiverLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Recurso API
 * @author Luis Suarez
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/receivers")
public class ReceiverResource {
    
    @EJB
    private ReceiverLogic receiversLogic;

    /**
     * Metodo que obtiene todos los datos 
     * @return Lista 
     */
    @GET
    public List<ReceiverDTO> getReceiverList(){
        List <ReceiverEntity> receivers = receiversLogic.obtenerReceivers();
        return ReceiverDTO.toReceiverList(receivers);
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return ReceiverEntity
     */
    @GET
    @Path("{id: \\d+}")
    public ReceiverDTO getReceiver(@PathParam("id") Long id){
        ReceiverEntity receiver = receiversLogic.obtenerReceiver(id);
        if (receiver == null){
            throw new RuntimeException("No existe");
        } 
        return new ReceiverDTO(receiver);
    }
    
    @POST
    public ReceiverDTO createReceiver(ReceiverDTO receiverDTO){
        return new ReceiverDTO(receiversLogic.crearReceiver(receiverDTO.toEntity()));
    }
    
    
    /**
     * Actualizar 
     * @param id
     * @param receiverDTO
     * @return actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public ReceiverDTO updateReceiver(@PathParam("id") Long id, ReceiverDTO receiverDTO){
        ReceiverEntity receiverEntity = receiversLogic.obtenerReceiver(id);
        if(receiverEntity == null){
            throw new RuntimeException("No existe.");
        }
        return new ReceiverDTO(receiversLogic.actualizarReceiver(id, receiverDTO.toEntity()));
    }
    
    @DELETE
    @Path("{receiverId: \\d+}")
    public void deleteReceiver(@PathParam("receiverId") Long id){
        ReceiverEntity receiverEntity = receiversLogic.obtenerReceiver(id);
        if(receiverEntity == null){
            throw new RuntimeException("No existe.");
        }
        receiversLogic.eliminarReceiver(id);
    }
}
