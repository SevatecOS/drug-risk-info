package com.sevatec.gsa.ads.openfda.data.model.response;

import java.util.List;

public class OpenFdaResponseNode {

    private List<String> substance_name;
    private List<String> product_type;
    private List<String> pharm_class_cs;
    private List<String> manufacturer_name;
    private List<String> brand_name;
    private List<String> route;
    private List<String> pharm_class_epc;
    private List<String> generic_name;

    public List<String> getSubstance_name() {
        return substance_name;
    }

    public void setSubstance_name(List<String> substance_name) {
        this.substance_name = substance_name;
    }

    public List<String> getProduct_type() {
        return product_type;
    }

    public void setProduct_type(List<String> product_type) {
        this.product_type = product_type;
    }

    public List<String> getPharm_class_cs() {
        return pharm_class_cs;
    }

    public void setPharm_class_cs(List<String> pharm_class_cs) {
        this.pharm_class_cs = pharm_class_cs;
    }

    public List<String> getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(List<String> manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public List<String> getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(List<String> brand_name) {
        this.brand_name = brand_name;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public List<String> getPharm_class_epc() {
        return pharm_class_epc;
    }

    public void setPharm_class_epc(List<String> pharm_class_epc) {
        this.pharm_class_epc = pharm_class_epc;
    }

    public List<String> getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(List<String> generic_name) {
        this.generic_name = generic_name;
    }



}
