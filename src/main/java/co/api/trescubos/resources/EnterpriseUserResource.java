package co.api.trescubos.resources;


import co.api.trescubos.dto.EnterpriseUserDTO;
import co.api.trescubos.entities.EnterpriseUserEntity;
import co.api.trescubos.logic.EnterpriseUserLogic;
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
@Path("/enterprise/users")
public class EnterpriseUserResource {
    
    @EJB
    private EnterpriseUserLogic enterpriseUsersLogic;

    /**
     * Metodo que obtiene todos los datos 
     * @return Lista 
     */
    @GET
    public List<EnterpriseUserDTO> getEnterpriseUserList(){
        List <EnterpriseUserEntity> enterpriseUsers = enterpriseUsersLogic.obtenerEnterpriseUsers();
        return EnterpriseUserDTO.toEnterpriseUserList(enterpriseUsers);
    }
    
    /**
     * Obtener por su id
     * @param id
     * @return EnterpriseUserEntity
     */
    @GET
    @Path("{id: \\d+}")
    public EnterpriseUserDTO getEnterpriseUser(@PathParam("id") Long id){
        EnterpriseUserEntity enterpriseUser = enterpriseUsersLogic.obtenerEnterpriseUser(id);
        if (enterpriseUser == null){
            throw new RuntimeException("No existe");
        } 
        return new EnterpriseUserDTO(enterpriseUser);
    }
    
    @POST
    public EnterpriseUserDTO createEnterpriseUser(EnterpriseUserDTO enterpriseUserDTO){
        return new EnterpriseUserDTO(enterpriseUsersLogic.crearEnterpriseUser(enterpriseUserDTO.toEntity()));
    }
    
    
    /**
     * Actualizar 
     * @param id
     * @param enterpriseUserDTO
     * @return actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public EnterpriseUserDTO updateEnterpriseUser(@PathParam("id") Long id, EnterpriseUserDTO enterpriseUserDTO){
        EnterpriseUserEntity enterpriseUserEntity = enterpriseUsersLogic.obtenerEnterpriseUser(id);
        if(enterpriseUserEntity == null){
            throw new RuntimeException("No existe.");
        }
        return new EnterpriseUserDTO(enterpriseUsersLogic.actualizarEnterpriseUser(id, enterpriseUserDTO.toEntity()));
    }
    
    @DELETE
    @Path("{enterpriseUserId: \\d+}")
    public void deleteEnterpriseUser(@PathParam("enterpriseUserId") Long id){
        EnterpriseUserEntity enterpriseUserEntity = enterpriseUsersLogic.obtenerEnterpriseUser(id);
        if(enterpriseUserEntity == null){
            throw new RuntimeException("No existe.");
        }
        enterpriseUsersLogic.eliminarEnterpriseUser(id);
    }
}
