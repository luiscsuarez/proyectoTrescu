package co.api.trescubos.dto;

import co.api.trescubos.entities.ReceiverEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad
 * @author Luis Suarez
 */
public class ReceiverDTO {
    
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String message;
    private Date dateShipping;
    
    
    public ReceiverDTO() {
    }
    
    /**
     * Transformacion entidad - objeto
     * @param receiverEntity 
     */
    public ReceiverDTO(ReceiverEntity receiverEntity) {
        this.id = receiverEntity.getId();
        this.fullName = receiverEntity.getFullName();
        this.phone = receiverEntity.getPhone();
        this.email = receiverEntity.getEmail();
        this.message = receiverEntity.getMessage();
        this.dateShipping = receiverEntity.getDateShipping();
    }
    
    /**
     * Transformacion objeto - entidad
     * @return ReceiverEntity
     */
    public ReceiverEntity toEntity(){
        ReceiverEntity entity = new ReceiverEntity();
        entity.setId(this.id);
        entity.setFullName(this.fullName);
        entity.setPhone(this.phone);
        entity.setEmail(this.email);
        entity.setMessage(this.message);
        entity.setDateShipping(this.dateShipping);
        return entity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaReceivers
     * @return 
     */
    public static List<ReceiverDTO> toReceiverList(List<ReceiverEntity> listaReceivers){
        List<ReceiverDTO> listaReceiversDTO = new ArrayList<>();
        for(ReceiverEntity entity : listaReceivers){
            listaReceiversDTO.add(new ReceiverDTO(entity));
        }
        return listaReceiversDTO;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateShipping() {
        return dateShipping;
    }

    public void setDateShipping(Date dateShipping) {
        this.dateShipping = dateShipping;
    }

    
}
