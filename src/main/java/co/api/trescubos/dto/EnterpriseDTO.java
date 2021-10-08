package co.api.trescubos.dto;

import co.api.trescubos.entities.CountryEntity;
import co.api.trescubos.entities.CurrencyEntity;
import co.api.trescubos.entities.EnterpriseEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad
 * @author Luis Suarez
 */
public class EnterpriseDTO {
    
    private Long id;
    private String identificationType;
    private String identificationNumber;
    private CurrencyEntity currencyId;
    private String businessName;
    private String tradeName;
    private String phone;
    private String address;
    private String city;
    private CountryEntity countryId;
    private Date dateCreated;
    private Date dateUpdated;
    
    public EnterpriseDTO() {
    }
    
    /**
     * Transformacion entidad - objeto
     * @param enterpriseEntity 
     */
    public EnterpriseDTO(EnterpriseEntity enterpriseEntity) {
        this.id = enterpriseEntity.getId();
        this.identificationType = enterpriseEntity.getIdentificationType();
        this.identificationNumber =  enterpriseEntity.getIdentificationNumber();
        this.currencyId  = enterpriseEntity.getCurrencyId();
        this.businessName  = enterpriseEntity.getBusinessName();
        this.tradeName  = enterpriseEntity.getTradeName();
        this.phone  = enterpriseEntity.getPhone();
        this.address  = enterpriseEntity.getAddress();
        this.city  = enterpriseEntity.getCity();
        this.countryId = enterpriseEntity.getCountryId();
        this.dateCreated  = enterpriseEntity.getDateCreated();
        this.dateUpdated  = enterpriseEntity.getDateUpdated();
    }
    
    /**
     * Transformacion objeto - entidad
     * @return EnterpriseEntity
     */
    public EnterpriseEntity toEntity(){
        EnterpriseEntity entity = new EnterpriseEntity();
        entity.setId(this.id);
        entity.setIdentificationType(this.identificationType);
        entity.setIdentificationNumber(this.identificationNumber);
        entity.setCurrencyId(this.currencyId);
        entity.setBusinessName(this.businessName);
        entity.setTradeName(this.tradeName);
        entity.setPhone(this.phone);
        entity.setAddress(this.address);
        entity.setCity(this.city);
        entity.setCountryId(this.countryId);
        entity.setDateCreated(this.dateCreated);
        entity.setDateUpdated(this.dateUpdated);
        return entity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaEnterprises
     * @return 
     */
    public static List<EnterpriseDTO> toEnterpriseList(List<EnterpriseEntity> listaEnterprises){
        List<EnterpriseDTO> listaEnterprisesDTO = new ArrayList<>();
        for(EnterpriseEntity entity : listaEnterprises){
            listaEnterprisesDTO.add(new EnterpriseDTO(entity));
        }
        return listaEnterprisesDTO;
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
            
}
