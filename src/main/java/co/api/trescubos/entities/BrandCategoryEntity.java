package co.api.trescubos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase encargada de crear la entidad
 *
 * @author Luis Suarez
 */
@Entity(name = "brand_categories")
public class BrandCategoryEntity implements Serializable {

    /**
     * Llave primaria de la entidad
     */
    @Id
    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne
    private CategoryEntity categoryId;
    
    /**
     * Llave primaria de la entidad
     */
    @Id
    @JoinColumn(name = "brand_id", nullable = false)
    @ManyToOne
    private BrandEntity brandId;

    
     /**
     * Constructor
     */
    public BrandCategoryEntity() {
    }

    public BrandCategoryEntity(CategoryEntity categoryId, BrandEntity brandId) {
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
    
    /* ----- METODOS SET Y GET ----- */

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
