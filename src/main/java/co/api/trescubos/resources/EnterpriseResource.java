package co.api.trescubos.resources;


import co.api.trescubos.dto.EnterpriseDTO;
import co.api.trescubos.entities.EnterpriseEntity;
import co.api.trescubos.logic.EnterpriseLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Recurso API
 * @author Luis Suarez
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/enterprises")
public class EnterpriseResource {
    
    @EJB
    private EnterpriseLogic enterprisesLogic;

    /**
     * Metodo que obtiene todos los datos 
     * @return Lista 
     */
    @GET
    public List<EnterpriseDTO> getEnterpriseList(){
        List <EnterpriseEntity> enterprises = enterprisesLogic.obtenerEnterprises();
        return EnterpriseDTO.toEnterpriseList(enterprises);
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return EnterpriseEntity
     */
    @GET
    @Path("{id: \\d+}")
    public EnterpriseDTO getEnterprise(@PathParam("id") Long id){
        EnterpriseEntity enterprise = enterprisesLogic.obtenerEnterprise(id);
        if (enterprise == null){
            throw new RuntimeException("No existe");
        } 
        return new EnterpriseDTO(enterprise);
    }
    
    @POST
    public EnterpriseDTO createEnterprise(EnterpriseDTO enterpriseDTO){
        return new EnterpriseDTO(enterprisesLogic.crearEnterprise(enterpriseDTO.toEntity()));
    }
    
    
    /**
     * Actualizar 
     * @param id
     * @param enterpriseDTO
     * @return actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public EnterpriseDTO updateEnterprise(@PathParam("id") Long id, EnterpriseDTO enterpriseDTO){
        EnterpriseEntity enterpriseEntity = enterprisesLogic.obtenerEnterprise(id);
        if(enterpriseEntity == null){
            throw new RuntimeException("No existe.");
        }
        return new EnterpriseDTO(enterprisesLogic.actualizarEnterprise(id, enterpriseDTO.toEntity()));
    }
    
    @DELETE
    @Path("{enterpriseId: \\d+}")
    public void deleteEnterprise(@PathParam("enterpriseId") Long id){
        EnterpriseEntity enterpriseEntity = enterprisesLogic.obtenerEnterprise(id);
        if(enterpriseEntity == null){
            throw new RuntimeException("No existe.");
        }
        enterprisesLogic.eliminarEnterprise(id);
    }
}
