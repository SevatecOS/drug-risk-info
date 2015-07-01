
package com.sevatec.drugriskinfo.openfda.api.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gax
 */
public class DrugLabel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String set_id;
    private String[] brand_name;

    public String getSet_id() {
        return set_id;
    }

    public void setSet_id(String set_id) {
        this.set_id = set_id;
    }

    public String[] getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String[] brand_name) {
        this.brand_name = brand_name;
    }

    

    
    
}
