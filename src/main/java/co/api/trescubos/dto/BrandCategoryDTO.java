package co.api.trescubos.dto;

import co.api.trescubos.entities.CountryEntity;
import co.api.trescubos.entities.BrandCategoryEntity;
import co.api.trescubos.entities.BrandEntity;
import co.api.trescubos.entities.CategoryEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad
 * @author Luis Suarez
 */
public class BrandCategoryDTO {
    
    private CategoryEntity categoryId;
    private BrandEntity brandId;
    
    public BrandCategoryDTO() {
    }
    
    /**
     * Transformacion entidad - objeto
     * @param brandCategoryEntity 
     */
    public BrandCategoryDTO(BrandCategoryEntity brandCategoryEntity) {
        this.categoryId = brandCategoryEntity.getCategoryId();
        this.brandId = brandCategoryEntity.getBrandId();
    }
    
    /**
     * Transformacion objeto - entidad
     * @return BrandCategoryEntity
     */
    public BrandCategoryEntity toEntity(){
        BrandCategoryEntity entity = new BrandCategoryEntity();
        entity.setCategoryId(this.categoryId);
        entity.setBrandId(this.brandId);
        return entity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaBrandCategories
     * @return 
     */
    public static List<BrandCategoryDTO> toBrandCategoryList(List<BrandCategoryEntity> listaBrandCategories){
        List<BrandCategoryDTO> listaBrandCategoriesDTO = new ArrayList<>();
        for(BrandCategoryEntity entity : listaBrandCategories){
            listaBrandCategoriesDTO.add(new BrandCategoryDTO(entity));
        }
        return listaBrandCategoriesDTO;
    }

    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }

    public BrandEntity getBrandId() {
        return brandId;
    }

    public void setBrandId(BrandEntity brandId) {
        this.brandId = brandId;
    }
       
    
    
}
