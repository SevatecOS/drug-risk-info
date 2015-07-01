package com.sevatec.drugriskinfo.openfda.api.dto;

import edu.emory.mathcs.backport.java.util.Collections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gax
 */
public class DrugLabelList implements Serializable {

    private static final long serialVersionUID = 1L;

    private Meta meta;
    private ArrayList<DrugLabel> results = new ArrayList<DrugLabel>();

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<DrugLabel> getResults() {
        return results;
    }

    public void setResults(List<DrugLabel> labels) {
        results.clear();
        results.addAll(labels);
    }

    public void setResults(DrugLabel[] results) {
        setResults(Arrays.asList(results));
    }

    public static class Meta implements Serializable {
//    
//    "disclaimer": "openFDA is a beta research project and not for clinical use. While we make every effort to ensure that data is accurate, you should assume all results are unvalidated.",
//    "license": "http://open.fda.gov/license",

        private String last_updated; // should be a Date with the GsonBuilder set with the right format "2015-05-31",
        private Results results;
        
        public String getLast_updated() {
            return last_updated;
        }

        public void setLast_updated(String last_updated) {
            this.last_updated = last_updated;
        }

        public Results getResults() {
            return results;
        }

        public void setResults(Results results) {
            this.results = results;
        }
        
        
        
//"results": {

        public static class Results {

            private long skip;
            private int limit;
            private long total;

            public long getSkip() {
                return skip;
            }

            public void setSkip(long skip) {
                this.skip = skip;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public long getTotal() {
                return total;
            }

            public void setTotal(long total) {
                this.total = total;
            }
            
        }

    }
}
