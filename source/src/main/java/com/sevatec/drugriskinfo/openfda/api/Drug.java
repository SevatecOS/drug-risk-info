package com.sevatec.drugriskinfo.openfda.api;

import java.io.Serializable;

/**
 *
 * @author gax
 */
public class Drug implements Serializable {
    private static final long serialVersionUID = 1L;
    private String primaryid;

    
    private String caseid;
    
//    $drug_seq
//    $role_cod
    private String drugname;
//    $prod_ai
//    $val_vbm
//    $route
//    $dose_vbm
//    $cum_dose_chr$cum_dose_unit$dechal$rechal$lot_num$exp_dt$nda_num$dose_amt$dose_unit
//            $dose_form
//            $dose_freq

    public String getPrimaryid() {
        return primaryid;
    }

    public void setPrimaryid(String primaryid) {
        this.primaryid = primaryid;
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }
    
    
    
    
    
    
}
