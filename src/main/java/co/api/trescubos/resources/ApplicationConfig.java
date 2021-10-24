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
        Set<Class<?>> resources = new HashSet<>();
        addRestResourceClasses(resources);
        return resources;      
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        //===========Clases de recursos api===========
        resources.add(co.api.trescubos.resources.BrandCategoryResource.class);
        resources.add(co.api.trescubos.resources.BrandResource.class);
        resources.add(co.api.trescubos.resources.CategoryResource.class);
        resources.add(co.api.trescubos.resources.CountryResource.class);
        resources.add(co.api.trescubos.resources.CurrencyResource.class);
        resources.add(co.api.trescubos.resources.EnterpriseResource.class);
        resources.add(co.api.trescubos.resources.EnterpriseUserResource.class);
        resources.add(co.api.trescubos.resources.Intercepter.class);
        resources.add(co.api.trescubos.resources.ReceiverResource.class);
        resources.add(co.api.trescubos.resources.TransactionResource.class);
    }
}
