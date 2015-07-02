package com.sevatec.gsa.ads.openfda.services;

import com.sevatec.gsa.ads.openfda.data.model.Drug;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/* https://api.fda.gov/drug/label.json?search=openfda.brand_name.exact:Glimepiride&limit=4 */
/* https://api.fda.gov/drug/label.json?limit=3&search=openfda.product_ndc:"43063-510" */
public abstract class OpenFdaClientService {

    private final static String BASE_URL = "https://api.fda.gov";
    private final static String PATH_LABEL = "/drug/label.json";
    private final static String PATH_EVENTS = "/drug/event.json";
    private final static String PATH_ENFORCEMENT = "/drug/enforcement.json";

    public static Map<String, Object> getDrugDetail(String drugName) {
        Map<String, Object> result = new HashMap<String, Object>();

        Drug drug = new Drug().findByAttribute("name", drugName);
        if (drug != null) {
            String productNdc = drug.getProductNdc();

            result.put("label", getDrugLabel(drugName, productNdc));
            result.put("events", getDrugEvents(drugName, productNdc));
            result.put("enforcements", getDrugEnforcements(drugName, productNdc));
        }

        return result;
    }

    private static Map<String, Object> getDrugLabel(String drugName, String productNdc) {
        WebTarget target = ClientBuilder.newClient().target(BASE_URL)
                .path(PATH_LABEL)
                .queryParam("search", "openfda.product_ndc:\"" + productNdc + "\"")
                .queryParam("limit", "1");

        return getResults(target, drugName, productNdc);
    }


    private static Map<String, Object> getDrugEvents(String drugName, String productNdc) {
        return new HashMap<String, Object>();
    }

    private static Map<String, Object> getDrugEnforcements(String drugName, String productNdc) {
        return new HashMap<String, Object>();
    }

    private static Map<String, Object> getResults(WebTarget target, String drugName, String productNdc) {
        Map<String, Object> result;
        try {
            result = target.request(MediaType.APPLICATION_JSON_TYPE).get(Map.class);
        } catch (NotFoundException nfe) {
            result = new HashMap<String, Object>();
            result.put("error", "Nothing found for " + drugName + ":" + productNdc);
            nfe.printStackTrace();
        }
        return result;
    }

}
