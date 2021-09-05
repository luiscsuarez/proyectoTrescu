package co.api.trescubos.entities;

import java.io.Serializable;
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
@Entity(name = "currencies")
public class CurrencyEntity implements Serializable {

    /**
     * Llave primaria de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;
    
    @JoinColumn(name = "country_id", nullable = false)
    @ManyToOne
    private CountryEntity countryId;
    
    /**
     * Constructor
     */
    public CurrencyEntity() {
    }

    public CurrencyEntity(Long id, String currencyName, String currencyCode, CountryEntity countryId) {
        this.id = id;
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.countryId = countryId;
    }

    

    /* ----- METODOS SET Y GET ----- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public CountryEntity getCountryId() {
        return countryId;
    }

    public void setCountryId(CountryEntity countryId) {
        this.countryId = countryId;
    }
    
    
    
    
}
