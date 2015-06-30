package com.sevatec.drugriskinfo.openfda.api;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gax
 */
public class DrugDataStore {
    
    private static DrugDataStore INSTANCE;
    private static HashMap<String, Drug> cache;
    private File csvPath;

    public static synchronized DrugDataStore getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DrugDataStore();
        }
        return INSTANCE;
    }
    
    public File getCsvPath() {
        return csvPath;
    }

    /**
     * set the file that has a CSV of the drug names from FAERE.
     */
    public void setCsvPath(File csvPath) {
        this.csvPath = csvPath;
    }

    public Map<String, Drug> getCache() {
        return Collections.unmodifiableMap(cache);
    }
    
    
    /**
     * init the drug name cache.
     */
    public void load() throws IOException {
        
        CSVReader reader = new CSVReader(new FileReader(getCsvPath()), '$');
        String [] line = reader.readNext();        
        ColumnPositionMappingStrategy<Drug> strat = new ColumnPositionMappingStrategy<Drug>();
        String[] columns = line;
        strat.setColumnMapping(columns);
        
        CsvToBean csv = new CsvToBean();
        List<Drug> list = csv.parse(strat, reader);
        if (!list.isEmpty()) {
            cache = new HashMap<String, Drug>();
        }
        for (Drug entry : list) {
            cache.put(entry.getDrugname(), entry);
        }
        
    }
    
}
