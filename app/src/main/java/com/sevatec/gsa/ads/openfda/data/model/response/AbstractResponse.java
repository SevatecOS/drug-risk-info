package com.sevatec.gsa.ads.openfda.data.model.response;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gax
 */
public abstract class AbstractResponse<T> {
    private Error error;
    private List<T> results;
    private MetaResponseNode meta;
    

    public MetaResponseNode getMeta() {
        return meta;
    }

    public void setMeta(MetaResponseNode meta) {
        this.meta = meta;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
    
    public static class Error {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        
        
    }
}
