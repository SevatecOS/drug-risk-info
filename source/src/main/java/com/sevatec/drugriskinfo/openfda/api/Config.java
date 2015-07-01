package com.sevatec.drugriskinfo.openfda.api;

/**
 *
 * @author gax
 */
public class Config {
    public static final String TARGET_URL = "https://api.fda.gov";
    
    public class EndPoint {
        public static final String END_POINT_DRUG_EVENT = "drug/event.json";
        public static final String END_POINT_DRUG_LABEL = "/drug/label.json";
    }
}
