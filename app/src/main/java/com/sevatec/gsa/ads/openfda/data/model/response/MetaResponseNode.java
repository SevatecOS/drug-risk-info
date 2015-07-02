package com.sevatec.gsa.ads.openfda.data.model.response;

public class MetaResponseNode {

    private String disclaimer;
    private String license;
    private String last_updated;
    private MetaResultsResponseNode results;

    public MetaResultsResponseNode getResults() {
        return results;
    }

    public void setResults(MetaResultsResponseNode results) {
        this.results = results;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

}
