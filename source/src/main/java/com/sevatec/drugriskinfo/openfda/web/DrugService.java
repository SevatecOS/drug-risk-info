package com.sevatec.drugriskinfo.openfda.web;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.sevatec.drugriskinfo.openfda.api.Drug;
import com.sevatec.drugriskinfo.openfda.api.DrugDataStore;
import com.sevatec.drugriskinfo.openfda.api.EventServiceImpl;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author gax
 */

@Path("/DrugService")
@WebService(serviceName = "DrugService")
public class DrugService {

    private EventServiceImpl eventService;
    
    public DrugService() {
        eventService = new EventServiceImpl();
        eventService.setCache(DrugDataStore.getInstance());
    }

    public EventServiceImpl getEventService() {
        return eventService;
    }

    public void setEventService(EventServiceImpl eventService) {
        this.eventService = eventService;
    }
    
    
    /**
     * 
     */
    
    @GET
    @Path("/name")
    @Produces("application/json")
    public String drugName(@WebParam(name = "prefix") String prefix) throws IOException {
     
        List<Drug> drugNames = eventService.findDrugByName(prefix);
        Gson gson = new Gson();
        return gson.toJson(drugNames);

    }
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}




