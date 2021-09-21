package co.api.trescubos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * Clase encargada de crear la entidad
 *
 * @author Luis Suarez
 */
@Entity(name = "categories")
public class CategoryEntity implements Serializable {

    /**
     * Llave primaria de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "category_name", nullable = false)
    private String categoryName;
    
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "date_created", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_updated", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @Column(name = "icon_url", nullable = false)
    private String iconUrl;
    
    public CategoryEntity() {
    }

    public CategoryEntity(Long id, String categoryName, Boolean enabled, Date dateCreated, Date dateUpdated, String iconUrl) {
        this.id = id;
        this.categoryName = categoryName;
        this.enabled = enabled;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.iconUrl = iconUrl;
    }
    
    /* ----- METODOS SET Y GET ----- */

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
