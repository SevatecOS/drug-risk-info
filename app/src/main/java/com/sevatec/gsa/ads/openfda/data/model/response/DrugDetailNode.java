package com.sevatec.gsa.ads.openfda.data.model.response;

import java.io.Serializable;

/**
 *
 * @author gax
 */
public class DrugDetailNode implements Serializable {
    private OpenFdaResponse label;
    private EventNode events;
    private EnforcementNode enforcements;
    private String error;

    public OpenFdaResponse getLabel() {
        return label;
    }

    public void setLabel(OpenFdaResponse label) {
        this.label = label;
    }

    public EventNode getEvents() {
        return events;
    }

    public void setEvents(EventNode events) {
        this.events = events;
    }

    public EnforcementNode getEnforcements() {
        return enforcements;
    }

    public void setEnforcements(EnforcementNode enforcements) {
        this.enforcements = enforcements;
    }

    public String getError() {
        return error;
    }
    
    public void setError(String error) {
        this.error = error;
    }
    
    
}
