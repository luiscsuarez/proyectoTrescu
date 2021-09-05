package co.api.trescubos.resources;

import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author luis suarez
 */
@Provider
@PreMatching
public class Intercepter implements ContainerRequestFilter {

    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        String url = request.getUriInfo().getAbsolutePath().toString();
        if (url.contains("api/auth")) {
            return;
        }

        String token = request.getHeaderString("Authorization");

        if (token == null) {
            JsonObject json = Json.createObjectBuilder().add("Mensaje", "Credenciales son necesarias").build();
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json).type(MediaType.APPLICATION_JSON).build());
            return;
        }

        if (!token.equals("sdfh-drtj-hktf-yikt-ykyg-uikt")) {
            JsonObject json = Json.createObjectBuilder().add("Mensaje", "Credenciales incorrectas").build();
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json).type(MediaType.APPLICATION_JSON).build());
            return;
        }

        String email = request.getHeaderString("Email");
        if (email == null) {
            JsonObject json = Json.createObjectBuilder().add("Mensaje", "Email es necesario").build();
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json).type(MediaType.APPLICATION_JSON).build());
            return;
        }
        String password = request.getHeaderString("Password");
        if (password == null) {
            JsonObject json = Json.createObjectBuilder().add("Mensaje", "Password es necesario").build();
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json).type(MediaType.APPLICATION_JSON).build());
            return;
        }

        Query queryEnterpriseUser = entityManager.createQuery("select p from enterprise_users p where p.email = :email and p.password = :password")
                .setParameter("email", email)
                .setParameter("password", password);
        if (queryEnterpriseUser.getResultList() == null) {
            JsonObject json = Json.createObjectBuilder().add("Mensaje", "Usuario no autorizado, acceso denegado").build();
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json).type(MediaType.APPLICATION_JSON).build());
            return;
        }
    }

}
