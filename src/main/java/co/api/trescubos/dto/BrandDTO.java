package co.api.trescubos.dto;

import co.api.trescubos.entities.BrandEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad
 * @author Luis Suarez
 */
public class BrandDTO {
    
    private Long id;
    private String brandName;
    private Boolean enabled;
    private Date dateCreated;
    private Date dateUpdated;
    private String iconUrl;
    private String description;
    private String flagType;
    private String values;
    
    
    public BrandDTO() {
    }
    
    /**
     * Transformacion entidad - objeto
     * @param brandEntity 
     */
    public BrandDTO(BrandEntity brandEntity) {
        this.id = brandEntity.getId();
        this.brandName = brandEntity.getBrandName();
        this.enabled = brandEntity.getEnabled();
        this.dateCreated = brandEntity.getDateCreated();
        this.dateUpdated = brandEntity.getDateUpdated();
        this.iconUrl = brandEntity.getIconUrl();
        this.description = brandEntity.getDescription();
        this.flagType = brandEntity.getFlagType();
        this.values = brandEntity.getValues();
    }
    
    /**
     * Transformacion objeto - entidad
     * @return BrandEntity
     */
    public BrandEntity toEntity(){
        BrandEntity entity = new BrandEntity();
        entity.setId(this.id);
        entity.setBrandName(this.brandName);
        entity.setEnabled(this.enabled);
        entity.setDateCreated(this.dateCreated);
        entity.setDateUpdated(this.dateUpdated);
        entity.setIconUrl(this.iconUrl);
        entity.setDescription(this.description);
        entity.setFlagType(this.flagType);
        entity.setValues(this.values);
        return entity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaBrands
     * @return 
     */
    public static List<BrandDTO> toBrandList(List<BrandEntity> listaBrands){
        List<BrandDTO> listaBrandsDTO = new ArrayList<>();
        for(BrandEntity entity : listaBrands){
            listaBrandsDTO.add(new BrandDTO(entity));
        }
        return listaBrandsDTO;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getFlagType() {
        return flagType;
    }

    public void setFlagType(String flagType) {
        this.flagType = flagType;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
