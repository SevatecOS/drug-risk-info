package com.sevatec.gsa.ads.openfda.data.model.response;

public class DrugResponseNode {

    private String drugauthorizationnumb;
    private String medicinalproduct;
    private String drugdosagetext;
    private OpenFdaResponseNode openfda;

    public String getDrugauthorizationnumb() {
        return drugauthorizationnumb;
    }

    public void setDrugauthorizationnumb(String drugauthorizationnumb) {
        this.drugauthorizationnumb = drugauthorizationnumb;
    }

    public String getMedicinalproduct() {
        return medicinalproduct;
    }

    public void setMedicinalproduct(String medicinalproduct) {
        this.medicinalproduct = medicinalproduct;
    }

    public String getDrugdosagetext() {
        return drugdosagetext;
    }

    public void setDrugdosagetext(String drugdosagetext) {
        this.drugdosagetext = drugdosagetext;
    }

    public OpenFdaResponseNode getOpenfda() {
        return openfda;
    }

    public void setOpenfda(OpenFdaResponseNode openfda) {
        this.openfda = openfda;
    }

}
