package co.api.trescubos.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Representa el registro de las clases que se personalizan como servicios REST
 * @author Luis Suarez
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;      
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(co.api.trescubos.resources.CountryResource.class);
    }
}
