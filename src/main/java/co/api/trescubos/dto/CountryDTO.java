package co.api.trescubos.dto;

import co.api.trescubos.entities.CountryEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad
 * @author Luis Suarez
 */
public class CountryDTO {
    
    private Long id;
    private String countryName;
    private String countryCode;
    
    public CountryDTO() {
    }
    
    /**
     * Transformacion entidad - objeto
     * @param productoEntity 
     */
    public CountryDTO(CountryEntity productoEntity) {
        this.id = productoEntity.getId();
        this.countryName = productoEntity.getCountryName();
        this.countryCode = productoEntity.getCountryCode();
    }
    
    /**
     * Transformacion objeto - entidad
     * @return CountryEntity
     */
    public CountryEntity toEntity(){
        CountryEntity entity = new CountryEntity();
        entity.setId(this.id);
        entity.setCountryName(this.countryName);
        entity.setCountryCode(this.countryCode);
        return entity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaProductos
     * @return 
     */
    public static List<CountryDTO> toCountryList(List<CountryEntity> listaProductos){
        List<CountryDTO> listaProductosDTO = new ArrayList<>();
        for(CountryEntity entity : listaProductos){
            listaProductosDTO.add(new CountryDTO(entity));
        }
        return listaProductosDTO;
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

     public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    
}
