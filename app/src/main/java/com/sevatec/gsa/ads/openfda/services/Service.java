/*
 * Main class represetenting our services (REST/JSON)
 */
package com.sevatec.gsa.ads.openfda.services;

import com.sevatec.gsa.ads.openfda.data.model.NameSearchResult;
import com.sevatec.gsa.ads.openfda.data.model.Drug;
import com.sevatec.gsa.ads.openfda.data.model.response.OpenFdaResponse;
import com.sevatec.gsa.ads.openfda.data.setup.DynamoSetup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
        List<Drug> drugs = new Drug().findByAttributeGreaterThan("views", 1);
        // have to put drugs in new list due to aws bindings
        List<Drug> sortDrugs = new ArrayList<Drug>();
        sortDrugs.addAll(drugs);
        Collections.sort(sortDrugs, new Comparator<Drug>() {
            @Override
            public int compare(Drug one, Drug two) {
                return two.getViews() - one.getViews();
            }
        });
		return Response.ok().entity(sortDrugs).build();
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
        Drug drug = new Drug().findByAttribute("searchName", drugName.toLowerCase());
        Map<String, Object> result = OpenFdaClientService.getDrugDetail(drug);
        // TODO: we should do this outside the connection - don't block
        if (hasResults(result)) {
            drug.setViews(drug.getViews() + 1);
            drug.save();
        }
        return Response.ok().entity(result).build();
    }
    
    @GET
    @Path("/getNewLabelResponse/{drugName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewLabelResponse(@PathParam("drugName") String drugName) {
        Drug drug = new Drug().findByAttribute("searchName", drugName.toLowerCase());
        OpenFdaResponse result = OpenFdaClientService.getNewLabelResponse(drug.getName(), drug.getProductNdc());
        return Response.ok().entity(result).build();
    }

    private boolean hasResults(Map<String, Object> result) {
        if (result != null) {
            return (
                    ((Map<String, Object>)result.get("label")).get("error") == null ||
                    ((Map<String, Object>)result.get("events")).get("error") == null ||
                    ((Map<String, Object>)result.get("enforcements")).get("error") == null
                    );
        }
        return false;
    }

}
