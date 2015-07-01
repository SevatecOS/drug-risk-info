/*
 * Main class represetenting our services (REST/JSON)
 */
package com.sevatec.gsa.ads.openfda.services;

import com.sevatec.gsa.ads.openfda.data.Drug;
import com.sevatec.gsa.ads.openfda.data.setup.DynamoSetup;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/services")
public class Service {

    public Service() {
        Logger.getLogger(Service.class.getName()).log(Level.INFO, "Running Dynamo setup...");
        DynamoSetup.runSetup();
        Logger.getLogger(Service.class.getName()).log(Level.INFO, "DONE running Dynamo setup...");
    }

	@GET
	@Path("/getTags")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTags() {
		return Response.ok().entity("here ya go: ").build();
	}

	@GET
	@Path("/getDrugNames/{drug}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDrugNames(@PathParam("drug") String drug) {

		Result result = new Result();
        for (Drug d : new Drug().searchByAttribute("searchName", drug.toLowerCase())) {
            result.addName(d.getName());
        }
		return Response.ok().entity(result).build();
	}

	@GET
	@Path("/getLabel/{drug}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLabel(@PathParam("drug") String drug) {
		return Response.ok().entity("here is the label: " + drug).build();
	}

	@GET
	@Path("/getAdverseEvents/{drug}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdverseEvents(@PathParam("drug") String drug) {
		return Response.ok().entity("here is the adverse events: " + drug).build();
	}

	@GET
	@Path("/getEnforcementReports/{drug}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEnforcementReports(@PathParam("drug") String drug) {
		return Response.ok().entity("here is the enforcement reports: " + drug).build();
	}

}
