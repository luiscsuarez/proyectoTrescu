package co.api.trescubos.dto;

import co.api.trescubos.entities.CountryEntity;
import co.api.trescubos.entities.CurrencyEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad
 * @author Luis Suarez
 */
public class CurrencyDTO {
    
    private Long id;
    private String currencyName;
    private String currencyCode;
    private CountryEntity countryId;
    
    public CurrencyDTO() {
    }
    
    /**
     * Transformacion entidad - objeto
     * @param currencyEntity 
     */
    public CurrencyDTO(CurrencyEntity currencyEntity) {
        this.id = currencyEntity.getId();
        this.currencyName = currencyEntity.getCurrencyName();
        this.currencyCode = currencyEntity.getCurrencyCode();
        this.countryId = currencyEntity.getCountryId();
    }
    
    /**
     * Transformacion objeto - entidad
     * @return CurrencyEntity
     */
    public CurrencyEntity toEntity(){
        CurrencyEntity entity = new CurrencyEntity();
        entity.setId(this.id);
        entity.setCurrencyName(this.currencyName);
        entity.setCurrencyCode(this.currencyCode);
        entity.setCountryId(this.countryId);
        return entity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaCurrencies
     * @return 
     */
    public static List<CurrencyDTO> toCurrencyList(List<CurrencyEntity> listaCurrencies){
        List<CurrencyDTO> listaCurrenciesDTO = new ArrayList<>();
        for(CurrencyEntity entity : listaCurrencies){
            listaCurrenciesDTO.add(new CurrencyDTO(entity));
        }
        return listaCurrenciesDTO;
    }
        
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
