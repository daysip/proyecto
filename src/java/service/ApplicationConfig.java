/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author DAY
 */
@javax.ws.rs.ApplicationPath("rs")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entidades.NewCrossOriginResourceSharingFilter.class);
        resources.add(service.AdicionalesFacadeREST.class);
        resources.add(service.DetalleFacadeREST.class);
        resources.add(service.HabitacionFacadeREST.class);
        resources.add(service.OrdenFacadeREST.class);
        resources.add(service.PersonaFacadeREST.class);
        resources.add(service.RolFacadeREST.class);
        resources.add(service.TipoHabFacadeREST.class);
    }
    
}
