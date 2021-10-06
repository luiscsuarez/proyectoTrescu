package co.api.trescubos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * Clase encargada de crear la entidad
 *
 * @author Luis Suarez
 */
@Entity(name = "transactions")
public class TransactionEntity implements Serializable {

    /**
     * Llave primaria de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private EnterpriseUserEntity userId;

    @Column(name = "date_created", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_updated", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @JoinColumn(name = "currency_id", nullable = false)
    @ManyToOne
    private CurrencyEntity currencyId;

    @Column(name = "previous_balance", nullable = false)
    private Double previousBalance;

    @Column(name = "new_balance", nullable = false)
    private Double newBalance;

    @Column(name = "type", nullable = false)
    private String type;
    
    @JoinColumn(name = "receiver_id")
    @ManyToOne
    private ReceiverEntity receiverId;

    public TransactionEntity() {
    }

    public TransactionEntity(Long id, EnterpriseUserEntity userId, Date dateCreated, Date dateUpdated, String description, Double amount, CurrencyEntity currencyId, Double previousBalance, Double newBalance, String type, ReceiverEntity receiverId) {
        this.id = id;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.description = description;
        this.amount = amount;
        this.currencyId = currencyId;
        this.previousBalance = previousBalance;
        this.newBalance = newBalance;
        this.type = type;
        this.receiverId = receiverId;
    }


    /* ----- METODOS SET Y GET ----- */
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
    
    

}
