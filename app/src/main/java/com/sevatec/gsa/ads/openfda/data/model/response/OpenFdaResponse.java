package com.sevatec.gsa.ads.openfda.data.model.response;

import java.util.List;

public class OpenFdaResponse {

    private String error;
    private MetaResponseNode meta;
    private List<ResultResponseNode> results;
    
    private EventNode events;
    private EnforcementNode enforcement;
    private EnforcementNode enforcements;

    public EventNode getEvents() {
        return events;
    }

    public void setEvents(EventNode events) {
        this.events = events;
    }
    
    public List<ResultResponseNode> getResults() {
        return results;
    }

    public void setResults(List<ResultResponseNode> results) {
        this.results = results;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public MetaResponseNode getMeta() {
        return meta;
    }

    public void setMeta(MetaResponseNode meta) {
        this.meta = meta;
    }

    public void setEnforcements(EnforcementNode enforcements) {
        this.enforcements = enforcements;
    }

    public EnforcementNode getEnforcement() {
        return enforcement;
    }

    public void setEnforcement(EnforcementNode enforcement) {
        this.enforcement = enforcement;
    }
    
    
}
