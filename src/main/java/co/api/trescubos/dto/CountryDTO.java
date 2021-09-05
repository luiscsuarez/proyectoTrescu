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
     * @param countryEntity 
     */
    public CountryDTO(CountryEntity countryEntity) {
        this.id = countryEntity.getId();
        this.countryName = countryEntity.getCountryName();
        this.countryCode = countryEntity.getCountryCode();
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
     * @param listaCountries
     * @return 
     */
    public static List<CountryDTO> toCountryList(List<CountryEntity> listaCountries){
        List<CountryDTO> listaCountriesDTO = new ArrayList<>();
        for(CountryEntity entity : listaCountries){
            listaCountriesDTO.add(new CountryDTO(entity));
        }
        return listaCountriesDTO;
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
