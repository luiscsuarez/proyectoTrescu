package co.api.trescubos.resources;


import co.api.trescubos.dto.TransactionDTO;
import co.api.trescubos.entities.TransactionEntity;
import co.api.trescubos.logic.TransactionLogic;
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
@Path("/transactions")
public class TransactionResource {
    
    @EJB
    private TransactionLogic transactionsLogic;

    /**
     * Metodo que obtiene todos los datos 
     * @return Lista 
     */
    @GET
    public List<TransactionDTO> getTransactionList(){
        List <TransactionEntity> transactions = transactionsLogic.obtenerTransactions();
        return TransactionDTO.toTransactionList(transactions);
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return TransactionEntity
     */
    @GET
    @Path("{id: \\d+}")
    public TransactionDTO getTransaction(@PathParam("id") Long id){
        TransactionEntity transaction = transactionsLogic.obtenerTransaction(id);
        if (transaction == null){
            throw new RuntimeException("No existe");
        } 
        return new TransactionDTO(transaction);
    }
    
    @POST
    public TransactionDTO createTransaction(TransactionDTO transactionDTO){
        return new TransactionDTO(transactionsLogic.crearTransaction(transactionDTO.toEntity()));
    }
    
    
    /**
     * Actualizar 
     * @param id
     * @param transactionDTO
     * @return actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public TransactionDTO updateTransaction(@PathParam("id") Long id, TransactionDTO transactionDTO){
        TransactionEntity transactionEntity = transactionsLogic.obtenerTransaction(id);
        if(transactionEntity == null){
            throw new RuntimeException("No existe.");
        }
        return new TransactionDTO(transactionsLogic.actualizarTransaction(id, transactionDTO.toEntity()));
    }
    
    @DELETE
    @Path("{transactionId: \\d+}")
    public void deleteTransaction(@PathParam("transactionId") Long id){
        TransactionEntity transactionEntity = transactionsLogic.obtenerTransaction(id);
        if(transactionEntity == null){
            throw new RuntimeException("No existe.");
        }
        transactionsLogic.eliminarTransaction(id);
    }
}
