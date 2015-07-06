package com.sevatec.gsa.ads.openfda.services;

import com.sevatec.gsa.ads.openfda.data.model.Drug;
import com.sevatec.gsa.ads.openfda.data.model.response.DrugDetailNode;
import com.sevatec.gsa.ads.openfda.data.model.response.EnforcementResponse;
import com.sevatec.gsa.ads.openfda.data.model.response.EventResponse;
import com.sevatec.gsa.ads.openfda.data.model.response.OpenFdaResponse;
import com.sevatec.gsa.ads.openfda.data.model.response.ResultResponseNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private final static String PATH_ENFORCEMENT = "/drug/enforcement.json"; // TODO : find the real path 

    @Deprecated
    public static Map<String, Object> getDrugDetail(Drug drug) {
        Map<String, Object> result = new HashMap<String, Object>();

        if (drug != null) {
            String productNdc = drug.getProductNdc();

            result.put("label", getDrugLabel(drug.getName(), productNdc));
            result.put("events", getDrugEvents(drug.getName(), productNdc));
            result.put("enforcements", getDrugEnforcements(drug.getName(), productNdc));
        }

        return result;
    }

    @Deprecated
    public static Map<String, Object> getDrugLabel(String drugName, String productNdc) {
        WebTarget target = ClientBuilder.newClient().target(BASE_URL)
                .path(PATH_LABEL)
                .queryParam("search", "openfda.product_ndc:\"" + productNdc + "\"")
                .queryParam("limit", "1");

        return getResults(target, drugName, productNdc);
    }

    @Deprecated
    public static Map<String, Object> getDrugEvents(String drugName, String productNdc) {
        WebTarget target = ClientBuilder.newClient().target(BASE_URL)
                .path(PATH_EVENTS)
                .queryParam("search", "patient.drug.openfda.product_ndc:" + productNdc + "")
                .queryParam("limit", "10");
        // fomething like https://api.fda.gov/drug/event.json?search=patient.drug.openfda.product_ndc:%2276237-113%22&limit=10
        return getResults(target, drugName, productNdc);
    }

    @Deprecated
    public static Map<String, Object> getDrugEnforcements(String drugName, String productNdc) {
        WebTarget target = ClientBuilder.newClient().target(BASE_URL)
                .path(PATH_ENFORCEMENT)
                .queryParam("search", "product_ndc:" + productNdc + "")
                .queryParam("limit", "10");

        return getResults(target, drugName, productNdc);
    }

    @Deprecated
    private static Map<String, Object> getResults(WebTarget target, String drugName, String productNdc) {
        Map<String, Object> result;
        try {
            result = target.request(MediaType.APPLICATION_JSON_TYPE).get(Map.class);
            filterOutput(result);
        } catch (NotFoundException nfe) {
            result = new HashMap<String, Object>();
            result.put("error", "Nothing found for " + drugName + ":" + productNdc);
        }
        return result;
    }

    private static ResultResponseNode getDrugEnforcements(String productNdc) {
        WebTarget target = ClientBuilder.newClient().target(BASE_URL)
                .path(PATH_ENFORCEMENT)
                .queryParam("search", "openfda.product_ndc:" + productNdc + "")
                .queryParam("limit", "1");

        return target.request().get(ResultResponseNode.class);
    }

    private static DrugDetailNode getDrugDetailResponse(String productNdc) {
        DrugDetailNode detail = new DrugDetailNode();
        WebTarget labelTarget = ClientBuilder.newClient().target(BASE_URL)
                .path(PATH_LABEL)
                .queryParam("search", "openfda.product_ndc:\"" + productNdc + "\"")
                .queryParam("limit", "1");
        // something like https://api.fda.gov/drug/label.json?search=openfda.product_ndc:%2276237-113%22&limit=1
        OpenFdaResponse label = labelTarget.request(MediaType.APPLICATION_JSON_TYPE).get(OpenFdaResponse.class);
        detail.setLabel(label);

        WebTarget eventsTarget = ClientBuilder.newClient().target(BASE_URL)
                .path(PATH_EVENTS)
                .queryParam("search", "product_ndc:" + productNdc + "")
                .queryParam("limit", "10");

        // something like https://api.fda.gov/drug/event.json?search=patient.drug.openfda.product_ndc:76237-113&limit=10
        EventResponse events = eventsTarget.request(MediaType.APPLICATION_JSON_TYPE).get(EventResponse.class);
        detail.setEvents(events);

        WebTarget enforcementTarget = ClientBuilder.newClient().target(BASE_URL)
                .path(PATH_ENFORCEMENT)
                .queryParam("search", "product_ndc:" + productNdc + "")
                .queryParam("limit", "10");
        // something like https://api.fda.gov/drug/enforcement.json?search=product_ndc:76237-113&limit=10
        EnforcementResponse enforcement = enforcementTarget.request(MediaType.APPLICATION_JSON_TYPE).get(EnforcementResponse.class);
        detail.setEnforcements(enforcement);
        return detail;
    }

    public static DrugDetailNode getNewLDrugDetail(String drugName, String productNdc) {
        DrugDetailNode result = null;
        try {
            result = getDrugDetailResponse(productNdc);
        } catch (Exception nfe) {
            result = new DrugDetailNode();
            result.setError("Nothing found for " + drugName + ":" + productNdc + " " + nfe.toString());
            nfe.printStackTrace();
        }
        return result;

    }

    private static final String[] FIELD_BLACKLIST = {
        "spl_id",
        "product_ndc",
        "rxcui",
        "spl_set_id",
        "package_ndc",
        "application_number"

    };
    static {
        Arrays.sort(FIELD_BLACKLIST);
    }
    
    private static void filterOutput(Map<String, Object> result) {
        List<String> removables = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            if (entry.getValue() == null) {
                removables.add(entry.getKey());
                continue;
            }

            if (Arrays.binarySearch(FIELD_BLACKLIST, entry.getKey()) >= 0) {
                removables.add(entry.getKey());
            }
            if (entry.getValue() instanceof Map) {
                filterOutput((Map<String, Object>) entry.getValue());
            }
            
            if (entry.getValue() instanceof List) {
                List array = (List) entry.getValue();
                for (Object arrayEntry : array) {
                    if (arrayEntry instanceof Map) {
                        filterOutput((Map<String, Object>) arrayEntry);
                    }
                }
            }
        }
        for (String key : removables) {
            result.remove(key);
        }
    }

}
