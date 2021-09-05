package co.api.trescubos.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase encargada de crear la entidad
 *
 * @author Luis Suarez
 */
@Entity(name = "enterprises")
public class EnterpriseEntity implements Serializable {

    /**
     * Llave primaria de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "identification_type", nullable = false)
    private String identificationType;
    
    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;
    
    @JoinColumn(name = "currency_id")
    @ManyToOne
    private CurrencyEntity currencyId;
    
    @Column(name = "business_name", nullable = false)
    private String businessName;
    
    @Column(name = "trade_name", nullable = false)
    private String tradeName;
    
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @JoinColumn(name = "country_id")
    @ManyToOne
    private CountryEntity countryId;
    
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;
    
    @Column(name = "date_updated", nullable = false)
    private LocalDateTime dateUpdated;
    
    /**
     * Constructor
     */
    public EnterpriseEntity() {
    }

    public EnterpriseEntity(Long id, String identificationType, String identificationNumber, CurrencyEntity currencyId, String businessName, String tradeName, String phone, String address, String city, CountryEntity countryId, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.id = id;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.currencyId = currencyId;
        this.businessName = businessName;
        this.tradeName = tradeName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.countryId = countryId;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CurrencyEntity getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(CurrencyEntity currencyId) {
        this.currencyId = currencyId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryEntity getCountryId() {
        return countryId;
    }

    public void setCountryId(CountryEntity countryId) {
        this.countryId = countryId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    
    
}
