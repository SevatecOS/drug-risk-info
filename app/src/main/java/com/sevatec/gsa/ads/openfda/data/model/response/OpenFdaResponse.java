package com.sevatec.gsa.ads.openfda.data.model.response;

import java.util.List;

public class OpenFdaResponse {

    private MetaResponseNode meta;
    private List<ResultResponseNode> results;
    

    public List<ResultResponseNode> getResults() {
        return results;
    }

    public void setResults(List<ResultResponseNode> results) {
        this.results = results;
    }

    public MetaResponseNode getMeta() {
        return meta;
    }

    public void setMeta(MetaResponseNode meta) {
        this.meta = meta;
    }
    
}
