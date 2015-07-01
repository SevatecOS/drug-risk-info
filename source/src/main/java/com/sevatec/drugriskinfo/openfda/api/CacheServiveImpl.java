package com.sevatec.drugriskinfo.openfda.api;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

/**
 *
 * @author gax
 */
public class CacheServiveImpl {
    private static final int CHACHE_LIMIT = 1000;
    
    public void init() {
        initDrugNames();
        initLabels();
    }

    private void initLabels() {
 /*       String searchString = "";
        Invocation.Builder request = ClientBuilder.newClient()
                .target(Config.TARGET_URL)
                .path(Config.EndPoint.END_POINT_DRUG_EVENT)
                .queryParam("search", searchString).request();
        Response response = request.get();
        Response.StatusType statusInfo = response.getStatusInfo();
        if (statusInfo.getStatusCode() != 200) {
            throw new RuntimeException("openfda response " + statusInfo.getStatusCode() +" : "+ response.getStatusInfo().getReasonPhrase());
        }
        response.r
        */
    }

    private void initDrugNames() {
        
    }
}
