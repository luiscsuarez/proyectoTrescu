package co.api.trescubos.logic;

import co.api.trescubos.entities.TransactionEntity;
import co.api.trescubos.persistence.TransactionPersistence;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.UUID;
import co.api.trescubos.generator.Generate;

/**
 * EJB
 *
 * @author Luis Suarez
 */
@Stateless
public class TransactionLogic {

    /**
     * Inyeccion del persistence
     */
    @Inject
    private TransactionPersistence persistence;

    /**
     * Obtener todos los objetos
     *
     * @return
     */
    public List<TransactionEntity> obtenerTransactions() {
        List<TransactionEntity> transactions = persistence.findAll();
        return transactions;
    }

    /**
     * Obtener por su id
     *
     * @param id
     * @return transactionEntity
     */
    public TransactionEntity obtenerTransaction(Long id) {
        TransactionEntity transaction = persistence.find(id);
        if (transaction == null) {
            throw new IllegalArgumentException("No existe en la base de datos");
        }
        return transaction;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear
     *
     * @param transactionCrear
     * @return
     */
    public TransactionEntity crearTransaction(TransactionEntity transactionCrear) {
        transactionCrear.setDateCreated(Date.from(Instant.now()));
        transactionCrear.setDateUpdated(Date.from(Instant.now()));
        transactionCrear.setToken("tx-" + UUID.randomUUID().toString());
        //Aca debera ir la logica del consumo y envio de tx a api externo trescubos
        persistence.create(transactionCrear);
        return transactionCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     *
     * @param id
     * @param TransactionAcualizar
     * @return transaction actualizado
     */
    public TransactionEntity actualizarTransaction(Long id, TransactionEntity TransactionAcualizar) {
        TransactionAcualizar.setDateUpdated(Date.from(Instant.now()));
        TransactionEntity transactionUpdate = persistence.update(TransactionAcualizar);
        return transactionUpdate;
    }

    /**
     * Metodo para eliminar un objeto
     *
     * @param id
     */
    public void eliminarTransaction(Long id) {
        persistence.remove(id);
    }
}
