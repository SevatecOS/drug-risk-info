package com.sevatec.gsa.ads.openfda.data.model.response;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gax
 */
public class EventNode implements Serializable {
    
    //meta
    
    private List<Event> results;

    public List<Event> getResults() {
        return results;
    }

    public void setResults(List<Event> results) {
        this.results = results;
    }
    
    
    
    
    public static class Event implements Serializable {
        private String companynumb;
        private String primarysourcecountry;

        public String getCompanynumb() {
            return companynumb;
        }

        public void setCompanynumb(String companynumb) {
            this.companynumb = companynumb;
        }

        public String getPrimarysourcecountry() {
            return primarysourcecountry;
        }

        public void setPrimarysourcecountry(String primarysourcecountry) {
            this.primarysourcecountry = primarysourcecountry;
        }
        
        
        
    }
}
