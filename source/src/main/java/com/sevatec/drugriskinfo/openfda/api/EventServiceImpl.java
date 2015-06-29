package com.sevatec.drugriskinfo.openfda.api;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import edu.emory.mathcs.backport.java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author gax
 */
public class EventServiceImpl implements EventService {
    
    public EventServiceImpl() {
        // noop
    }
    
    @Override
    public List<Drug> getDrugsByName(String name) {
        
        String searchString = name;// TODO
        Invocation.Builder request = ClientBuilder.newClient()
                .target(Config.TARGET_URL)
                .path(Config.EndPoint.END_POINT_DRUG_EVENT)
                .queryParam("search", searchString).request();
        Response response = request.get();
        Response.StatusType statusInfo = response.getStatusInfo();
        if (statusInfo.getStatusCode() != 200) {
            throw new RuntimeException("openfda respons " + statusInfo.getStatusCode() +" : "+ response.getStatusInfo().getReasonPhrase());
        }
        return null;
    }
    
    @Override
    public List<Drug> findDrugByName(String prefix) throws IOException {
        if (StringUtils.isEmpty(prefix)) {
            return Collections.emptyList();
        }
        File data = new File("~/Downloads/faers_data/ascii/DRUG14Q4.txt");
        CSVReader reader = new CSVReader(new FileReader(data), '$');
        String [] line = reader.readNext();
        ArrayList<Drug> result = new ArrayList<Drug>();
        
        ColumnPositionMappingStrategy<Drug> strat = new ColumnPositionMappingStrategy<Drug>();
        String[] columns = line;
        strat.setColumnMapping(columns);

        CsvToBean csv = new CsvToBean();
        List<Drug> list = csv.parse(strat, reader);
        for (Drug drug : list){
            if (StringUtils.containsIgnoreCase(drug.getDrugname(), prefix)) {
                result.add(drug);
            }
        }
        return result;
    }
}
