package co.api.trescubos.dto;

import co.api.trescubos.entities.CurrencyEntity;
import co.api.trescubos.entities.EnterpriseEntity;
import co.api.trescubos.entities.EnterpriseUserEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad
 * @author Luis Suarez
 */
public class EnterpriseUserDTO {
    
    private Long id;
    private EnterpriseEntity enterpriseId;
    private String fullName;
    private String identificationType;
    private String identificationNumber;
    private String phone;
    private String email;
    private String password;
    private Boolean enabled;
    private Date dateCreated;
    private Date dateUpdated;
    private Double balance;
    private CurrencyEntity currencyId;
    
    
    public EnterpriseUserDTO() {
    }
    
    /**
     * Transformacion entidad - objeto
     * @param enterpriseUserEntity 
     */
    public EnterpriseUserDTO(EnterpriseUserEntity enterpriseUserEntity) {
        this.id = enterpriseUserEntity.getId();
        this.enterpriseId = enterpriseUserEntity.getEnterpriseId();
        this.fullName = enterpriseUserEntity.getFullName();
        this.identificationType = enterpriseUserEntity.getIdentificationType();
        this.identificationNumber = enterpriseUserEntity.getIdentificationNumber();
        this.phone = enterpriseUserEntity.getPhone();
        this.email = enterpriseUserEntity.getEmail();
        this.password = enterpriseUserEntity.getPassword();
        this.enabled = enterpriseUserEntity.getEnabled();
        this.dateCreated = enterpriseUserEntity.getDateCreated();
        this.dateUpdated = enterpriseUserEntity.getDateUpdated();
        this.balance = enterpriseUserEntity.getBalance();
        this.currencyId = enterpriseUserEntity.getCurrencyId();
    }
    
    /**
     * Transformacion objeto - entidad
     * @return EnterpriseUserEntity
     */
    public EnterpriseUserEntity toEntity(){
        EnterpriseUserEntity entity = new EnterpriseUserEntity();
        entity.setId(this.id);
        entity.setEnterpriseId(this.enterpriseId);
        entity.setFullName(this.fullName);
        entity.setIdentificationType(this.identificationType);
        entity.setIdentificationNumber(this.identificationNumber);
        entity.setPhone(this.phone);
        entity.setEmail(this.email);
        entity.setPassword(this.password);
        entity.setEnabled(this.enabled);
        entity.setDateCreated(this.dateCreated);
        entity.setDateUpdated(this.dateUpdated);
        entity.setBalance(this.balance);
        entity.setCurrencyId(this.currencyId);
        return entity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaEnterpriseUsers
     * @return 
     */
    public static List<EnterpriseUserDTO> toEnterpriseUserList(List<EnterpriseUserEntity> listaEnterpriseUsers){
        List<EnterpriseUserDTO> listaEnterpriseUsersDTO = new ArrayList<>();
        for(EnterpriseUserEntity entity : listaEnterpriseUsers){
            listaEnterpriseUsersDTO.add(new EnterpriseUserDTO(entity));
        }
        return listaEnterpriseUsersDTO;
    }   

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
