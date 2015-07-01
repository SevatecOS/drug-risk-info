
package com.sevatec.drugriskinfo.openfda.api.dto;

import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gax
 */
public class DrugLabel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String set_id;
    private String[] indications_and_usage;
    private OpenFdaRecord openfda;
    

    public String getSet_id() {
        return set_id;
    }

    public void setSet_id(String set_id) {
        this.set_id = set_id;
    }

    public String[] getIndications_and_usage() {
        return indications_and_usage;
    }

    public void setIndications_and_usage(String[] indications_and_usage) {
        this.indications_and_usage = indications_and_usage;
    }

    public OpenFdaRecord getOpenfda() {
        return openfda;
    }

    public void setOpenfda(OpenFdaRecord openfda) {
        this.openfda = openfda;
    }
    
    

    public static class OpenFdaRecord implements Serializable {
        private List<String> brand_name = new ArrayList<>();
        
        public void setBrand_name(List<String> brand_name) {
            this.brand_name.clear();
            this.brand_name.addAll(brand_name);
        }

        public List<String> getBrand_name() {
            return brand_name;
        }
        public void setBrand_name(String[] brand_name) {
            this.setBrand_name(Arrays.asList(brand_name));
        }
    }

    

    
    
}
