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
@Entity(name = "enterprise_users")
public class EnterpriseUserEntity implements Serializable {

    /**
     * Llave primaria de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @JoinColumn(name = "enterprise_id")
    @ManyToOne
    private EnterpriseEntity enterpriseId;
    
    @Column(name = "full_name", nullable = false)
    private String fullName;
    
    @Column(name = "identification_type", nullable = false)
    private String identificationType;
    
    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;
    
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;
    
    @Column(name = "date_created", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Column(name = "date_updated", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateUpdated;
    
    @Column(name = "balance", nullable = false)
    private Double balance;
    
    @JoinColumn(name = "currency_id", nullable = false)
    @ManyToOne
    private CurrencyEntity currencyId;
    
    
    public EnterpriseUserEntity() {
    }

    public EnterpriseUserEntity(Long id, EnterpriseEntity enterpriseId, String fullName, String identificationType, String identificationNumber, String phone, String email, String password, Boolean enabled, Date dateCreated, Date dateUpdated, Double balance, CurrencyEntity currencyId) {
        this.id = id;
        this.enterpriseId = enterpriseId;
        this.fullName = fullName;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.balance = balance;
        this.currencyId = currencyId;
    }

    /* ----- METODOS SET Y GET ----- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnterpriseEntity getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(EnterpriseEntity enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public CurrencyEntity getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(CurrencyEntity currencyId) {
        this.currencyId = currencyId;
    }
    
}
