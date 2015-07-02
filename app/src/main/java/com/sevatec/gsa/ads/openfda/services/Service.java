/*
 * Main class represetenting our services (REST/JSON)
 */
package com.sevatec.gsa.ads.openfda.services;

import com.sevatec.gsa.ads.openfda.data.model.NameSearchResult;
import com.sevatec.gsa.ads.openfda.data.model.Drug;
import com.sevatec.gsa.ads.openfda.data.setup.DynamoSetup;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/services")
public class Service {

    public Service() {
        DynamoSetup.runSetup();
    }

    @GET
    @Path("/drugCount")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDrugCount() {
        Integer i = new Drug().count();
		return Response.ok().entity(i).build();
	}

	@GET
	@Path("/getRecentSearches")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRecentSearches() {
		return Response.ok().entity("here ya go: ").build();
	}

	@GET
	@Path("/getDrugNames/{drugName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDrugNames(@PathParam("drugName") String drugName) {

		NameSearchResult result = new NameSearchResult();
        for (Drug d : new Drug().searchByAttribute("searchName", drugName.toLowerCase())) {
            result.addName(d.getName());
        }
		return Response.ok().entity(result).build();
	}

    @GET
    @Path("/getDrugDetail/{drugName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrugDetail(@PathParam("drugName") String drugName) {
        Map<String, Object> result = OpenFdaClientService.getDrugDetail(drugName);
        return Response.ok().entity(result).build();
    }

}
