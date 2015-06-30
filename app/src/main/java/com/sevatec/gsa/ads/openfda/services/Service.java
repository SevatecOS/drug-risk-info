/*
 * Main class represetenting our services (REST/JSON)
 */
package com.sevatec.gsa.ads.openfda.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/services")
public class Service {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrugNames(String drug) {
        return Response.status(Response.Status.OK).entity("here ya go").build();

    }
}
