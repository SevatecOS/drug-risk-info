package com.sevatec.drugriskinfo.openfda.web;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.sevatec.drugriskinfo.openfda.api.dto.Drug;
import com.sevatec.drugriskinfo.openfda.api.DrugDataStore;
import com.sevatec.drugriskinfo.openfda.api.EventServiceImpl;
import com.sevatec.drugriskinfo.openfda.api.dto.DrugLabelList;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author gax
 */

@Path("/DrugService")
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
     * @param name drug name
     */
    
    @GET
    @Path("/label/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @WebMethod(operationName = "label")
    public DrugLabelList getlabel(@WebParam(name = "name") String name) {
        return eventService.getLabels(name);
        
    }
}




