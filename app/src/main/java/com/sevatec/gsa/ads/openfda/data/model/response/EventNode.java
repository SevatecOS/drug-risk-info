package com.sevatec.gsa.ads.openfda.data.model.response;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gax
 */
public class EventNode implements Serializable {

    //meta
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
