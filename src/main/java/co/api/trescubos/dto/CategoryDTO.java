package co.api.trescubos.dto;

import co.api.trescubos.entities.CategoryEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad
 * @author Luis Suarez
 */
public class CategoryDTO {
    
    private Long id;
    private String categoryName;
    private Boolean enabled;
    private Date dateCreated;
    private Date dateUpdated;
    private String iconUrl;
    
    
    public CategoryDTO() {
    }
    
    /**
     * Transformacion entidad - objeto
     * @param categoryEntity 
     */
    public CategoryDTO(CategoryEntity categoryEntity) {
        this.id = categoryEntity.getId();
        this.categoryName = categoryEntity.getCategoryName();
        this.enabled = categoryEntity.getEnabled();
        this.dateCreated = categoryEntity.getDateCreated();
        this.dateUpdated = categoryEntity.getDateUpdated();
        this.iconUrl = categoryEntity.getIconUrl();
    }
    /**
     * Transformacion objeto - entidad
     * @return CategoryEntity
     */
    public CategoryEntity toEntity(){
        CategoryEntity entity = new CategoryEntity();
        entity.setId(this.id);
        entity.setCategoryName(this.categoryName);
        entity.setEnabled(this.enabled);
        entity.setDateCreated(this.dateCreated);
        entity.setDateUpdated(this.dateUpdated);
        entity.setIconUrl(this.iconUrl);
        return entity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaCategories
     * @return 
     */
    public static List<CategoryDTO> toCategoryList(List<CategoryEntity> listaCategories){
        List<CategoryDTO> listaCategoriesDTO = new ArrayList<>();
        for(CategoryEntity entity : listaCategories){
            listaCategoriesDTO.add(new CategoryDTO(entity));
        }
        return listaCategoriesDTO;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
    
        
}
