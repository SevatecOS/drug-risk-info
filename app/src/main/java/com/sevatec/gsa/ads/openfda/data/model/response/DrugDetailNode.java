package com.sevatec.gsa.ads.openfda.data.model.response;

import java.io.Serializable;

/**
 *
 * @author gax
 */
public class DrugDetailNode implements Serializable {
    private OpenFdaResponse label;
    private EventResponse events;
    private EnforcementResponse enforcements;
    private String error;

    public OpenFdaResponse getLabel() {
        return label;
    }

    public void setLabel(OpenFdaResponse label) {
        this.label = label;
    }

    public EventResponse getEvents() {
        return events;
    }

    public void setEvents(EventResponse events) {
        this.events = events;
    }

    public EnforcementResponse getEnforcements() {
        return enforcements;
    }

    public void setEnforcements(EnforcementResponse enforcements) {
        this.enforcements = enforcements;
    }

    public String getError() {
        return error;
    }
    
    public void setError(String error) {
        this.error = error;
    }
    
    
}
