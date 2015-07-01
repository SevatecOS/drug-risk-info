package com.sevatec.drugriskinfo.openfda.api;

import com.sevatec.drugriskinfo.openfda.api.dto.Drug;
import com.google.gson.Gson;
import com.sevatec.drugriskinfo.openfda.api.dto.DrugLabelList;
import edu.emory.mathcs.backport.java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author gax
 */
public class EventServiceImpl implements EventService {
    
    private DrugDataStore cache;
    
    public EventServiceImpl() {
        // noop
    }

    public DrugDataStore getCache() {
        return cache;
    }

    public void setCache(DrugDataStore cache) {
        this.cache = cache;
    }
    
    @Override
    public List<Drug> getDrugsByName(String name) {
        
        String searchString = name;// TODO
        Invocation.Builder request = ClientBuilder.newClient()
                .target(Config.TARGET_URL)
                .path(Config.EndPoint.END_POINT_DRUG_EVENT)
                .queryParam("search", searchString).request();
        Response response = request.get();
//        Response.StatusType statusInfo = response.getStatusInfo();
//        if (statusInfo.getStatusCode() != 200) {
//            throw new RuntimeException("openfda response " + statusInfo.getStatusCode() +" : "+ response.getStatusInfo().getReasonPhrase());
//        }
        
//        Gson gson = new Gson();
//        List<Drug> listlist = response.readEntity(List<Drug>.class);
//        return list;
        return null;
    }
    
    /**
     *
     * @param drugId
     * @return
     */
    public DrugLabelList getLabels(String drugId) {
        // TODO check if cached.
        String searchString =   "patient.drug.openfda.generic_name.exact:" + drugId;// TODO bulid serch string
        Invocation.Builder request = ClientBuilder.newClient()
                .target(Config.TARGET_URL)
                .path(Config.EndPoint.END_POINT_DRUG_EVENT)
                .queryParam("search", searchString)
                .queryParam("limit", 100)
                .request();
        DrugLabelList list = request.get(DrugLabelList.class);
        
        // TOD added to cache
        return list;
    }
    
    @Override
    public List<Drug> findDrugByName(String prefix) throws IOException {
        if (StringUtils.isEmpty(prefix)) {
            return Collections.emptyList();
        }
        ArrayList<Drug> result = new ArrayList<Drug>();
        for (Map.Entry<String, Drug> entry : getCache().getCache().entrySet()) {
            if (StringUtils.containsIgnoreCase(entry.getKey(), prefix)) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
