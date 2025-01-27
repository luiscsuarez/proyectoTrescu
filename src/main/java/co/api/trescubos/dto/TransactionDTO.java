package co.api.trescubos.dto;

import co.api.trescubos.entities.BrandEntity;
import co.api.trescubos.entities.CurrencyEntity;
import co.api.trescubos.entities.EnterpriseUserEntity;
import co.api.trescubos.entities.TransactionEntity;
import co.api.trescubos.entities.ReceiverEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad
 * @author Luis Suarez
 */
public class TransactionDTO {
    
    private Long id;
    private EnterpriseUserEntity userId;
    private Date dateCreated;
    private Date dateUpdated;
    private String description;
    private Double amount;
    private CurrencyEntity currencyId;
    private Double previousBalance;
    private Double newBalance;
    private String type;
    private ReceiverEntity receiverId;
    private BrandEntity brandId;
    private String token;
    
    
    public TransactionDTO() {
    }
    
    /**
     * Transformacion entidad - objeto
     * @param transactionEntity 
     */
    public TransactionDTO(TransactionEntity transactionEntity) {
        this.id = transactionEntity.getId();
        this.userId = transactionEntity.getUserId();
        this.dateCreated = transactionEntity.getDateCreated();
        this.dateUpdated = transactionEntity.getDateUpdated();
        this.description = transactionEntity.getDescription();
        this.amount = transactionEntity.getAmount();
        this.currencyId = transactionEntity.getCurrencyId();
        this.previousBalance = transactionEntity.getPreviousBalance();
        this.newBalance = transactionEntity.getNewBalance();
        this.type = transactionEntity.getType();
        this.receiverId = transactionEntity.getReceiverId();
        this.brandId = transactionEntity.getBrandId();
        this.token = transactionEntity.getToken();
    }
    
    /**
     * Transformacion objeto - entidad
     * @return TransactionEntity
     */
    public TransactionEntity toEntity(){
        TransactionEntity entity = new TransactionEntity();
        entity.setId(this.id);
        entity.setUserId(this.userId);
        entity.setDateCreated(this.dateCreated);
        entity.setDateUpdated(this.dateUpdated);
        entity.setDescription(this.description);
        entity.setAmount(this.amount);
        entity.setCurrencyId(this.currencyId);
        entity.setPreviousBalance(this.previousBalance);
        entity.setNewBalance(this.newBalance);
        entity.setType(this.type);
        entity.setReceiverId(this.receiverId);
        entity.setBrandId(this.brandId);
        entity.setToken(this.token);
        return entity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaTransactions
     * @return 
     */
    public static List<TransactionDTO> toTransactionList(List<TransactionEntity> listaTransactions){
        List<TransactionDTO> listaTransactionsDTO = new ArrayList<>();
        for(TransactionEntity entity : listaTransactions){
            listaTransactionsDTO.add(new TransactionDTO(entity));
        }
        return listaTransactionsDTO;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnterpriseUserEntity getUserId() {
        return userId;
    }

    public void setUserId(EnterpriseUserEntity userId) {
        this.userId = userId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CurrencyEntity getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(CurrencyEntity currencyId) {
        this.currencyId = currencyId;
    }

    public Double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(Double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public Double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Double newBalance) {
        this.newBalance = newBalance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ReceiverEntity getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(ReceiverEntity receiverId) {
        this.receiverId = receiverId;
    }

    public BrandEntity getBrandId() {
        return brandId;
    }

    public void setBrandId(BrandEntity brandId) {
        this.brandId = brandId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    
        
}
