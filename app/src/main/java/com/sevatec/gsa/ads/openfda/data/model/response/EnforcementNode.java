package com.sevatec.gsa.ads.openfda.data.model.response;

import java.io.Serializable;

/**
 *
 * @author gax
 */
public class EnforcementNode implements Serializable {

    private String recall_number;
    private String reason_for_recall;
    private String status;
    private String distribution_pattern;
    private String product_quantity;
    private String recall_initiation_date;

    public String getRecall_number() {
        return recall_number;
    }

    public void setRecall_number(String recall_number) {
        this.recall_number = recall_number;
    }

    public String getReason_for_recall() {
        return reason_for_recall;
    }

    public void setReason_for_recall(String reason_for_recall) {
        this.reason_for_recall = reason_for_recall;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDistribution_pattern() {
        return distribution_pattern;
    }

    public void setDistribution_pattern(String distribution_pattern) {
        this.distribution_pattern = distribution_pattern;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getRecall_initiation_date() {
        return recall_initiation_date;
    }

    public void setRecall_initiation_date(String recall_initiation_date) {
        this.recall_initiation_date = recall_initiation_date;
    }
    
    
}
