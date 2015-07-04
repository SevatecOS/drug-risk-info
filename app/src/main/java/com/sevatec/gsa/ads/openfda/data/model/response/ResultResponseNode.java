package com.sevatec.gsa.ads.openfda.data.model.response;

import java.util.List;

public class ResultResponseNode {

    /* label.json */
    private String use_in_specific_populations_table;
    private String information_for_patients;
    private List<String> indications_and_usage;
    private String contraindications;
    private String how_supplied;
    private List<String> dosage_and_administration;
    private List<String> package_label_principal_display_panel;
    private String description;
    private String warnings_and_cautions;
    private String pharmacodynamics;
    private String pediatric_use;
    private String mechanism_of_action;
    private String pediatric_use_table;
    private List<String> spl_product_data_elements;
    private String adverse_reactions_table;
    private String geriatric_use;
    private String adverse_reactions;
    private String overdosage;
    private String drug_interactions;
    private String nonclinical_toxicology;
    private String use_in_specific_populations;
    private String carcinogenesis_and_mutagenesis_and_impairment_of_fertility;
    private String dosage_forms_and_strengths;
    private String pregnancy;
    private String clinical_studies;
    private String nursing_mothers;
    private String clinical_pharmacology;
    private String pharmacokinetics;
    private String clinical_studies_table;

    private OpenFdaResponseNode openfda;
    /* label.json */

    /* event.json */
    private String primarysourcecountry;
    private String receiptdate;
    private String transmissiondate;
    private String occurcountry;
    private PatientResponseNode patient;
    /* event.json */

    /* enforcement.json */
    private String recall_number;
    private String reason_for_recall;
    private String status;
    private String distribution_pattern;
    private String product_quantity;
    private String recall_initiation_date;
    private String state;
    private String event_id;
    private List<String> product_type;
    private String product_description;
    private String country;
    private String city;
    private String recalling_firm;
    private String report_date;
    private String voluntary_mandated;
    private String classification;
    private String code_info;
    private String initial_firm_notification;
    /* enforcement.json */

    public String getUse_in_specific_populations_table() {
        return use_in_specific_populations_table;
    }

    public void setUse_in_specific_populations_table(String use_in_specific_populations_table) {
        this.use_in_specific_populations_table = use_in_specific_populations_table;
    }

    public String getInformation_for_patients() {
        return information_for_patients;
    }

    public void setInformation_for_patients(String information_for_patients) {
        this.information_for_patients = information_for_patients;
    }

    public List<String> getIndications_and_usage() {
        return indications_and_usage;
    }

    public void setIndications_and_usage(List<String> indications_and_usage) {
        this.indications_and_usage = indications_and_usage;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public String getHow_supplied() {
        return how_supplied;
    }

    public void setHow_supplied(String how_supplied) {
        this.how_supplied = how_supplied;
    }

    public List<String> getDosage_and_administration() {
        return dosage_and_administration;
    }

    public void setDosage_and_administration(List<String> dosage_and_administration) {
        this.dosage_and_administration = dosage_and_administration;
    }

    public List<String> getPackage_label_principal_display_panel() {
        return package_label_principal_display_panel;
    }

    public void setPackage_label_principal_display_panel(List<String> package_label_principal_display_panel) {
        this.package_label_principal_display_panel = package_label_principal_display_panel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWarnings_and_cautions() {
        return warnings_and_cautions;
    }

    public void setWarnings_and_cautions(String warnings_and_cautions) {
        this.warnings_and_cautions = warnings_and_cautions;
    }

    public String getPharmacodynamics() {
        return pharmacodynamics;
    }

    public void setPharmacodynamics(String pharmacodynamics) {
        this.pharmacodynamics = pharmacodynamics;
    }

    public String getPediatric_use() {
        return pediatric_use;
    }

    public void setPediatric_use(String pediatric_use) {
        this.pediatric_use = pediatric_use;
    }

    public String getMechanism_of_action() {
        return mechanism_of_action;
    }

    public void setMechanism_of_action(String mechanism_of_action) {
        this.mechanism_of_action = mechanism_of_action;
    }

    public String getPediatric_use_table() {
        return pediatric_use_table;
    }

    public void setPediatric_use_table(String pediatric_use_table) {
        this.pediatric_use_table = pediatric_use_table;
    }

    public List<String> getSpl_product_data_elements() {
        return spl_product_data_elements;
    }

    public void setSpl_product_data_elements(List<String> spl_product_data_elements) {
        this.spl_product_data_elements = spl_product_data_elements;
    }

    public String getAdverse_reactions_table() {
        return adverse_reactions_table;
    }

    public void setAdverse_reactions_table(String adverse_reactions_table) {
        this.adverse_reactions_table = adverse_reactions_table;
    }

    public String getGeriatric_use() {
        return geriatric_use;
    }

    public void setGeriatric_use(String geriatric_use) {
        this.geriatric_use = geriatric_use;
    }

    public String getAdverse_reactions() {
        return adverse_reactions;
    }

    public void setAdverse_reactions(String adverse_reactions) {
        this.adverse_reactions = adverse_reactions;
    }

    public String getOverdosage() {
        return overdosage;
    }

    public void setOverdosage(String overdosage) {
        this.overdosage = overdosage;
    }

    public String getDrug_interactions() {
        return drug_interactions;
    }

    public void setDrug_interactions(String drug_interactions) {
        this.drug_interactions = drug_interactions;
    }

    public String getNonclinical_toxicology() {
        return nonclinical_toxicology;
    }

    public void setNonclinical_toxicology(String nonclinical_toxicology) {
        this.nonclinical_toxicology = nonclinical_toxicology;
    }

    public String getUse_in_specific_populations() {
        return use_in_specific_populations;
    }

    public void setUse_in_specific_populations(String use_in_specific_populations) {
        this.use_in_specific_populations = use_in_specific_populations;
    }

    public String getCarcinogenesis_and_mutagenesis_and_impairment_of_fertility() {
        return carcinogenesis_and_mutagenesis_and_impairment_of_fertility;
    }

    public void setCarcinogenesis_and_mutagenesis_and_impairment_of_fertility(String carcinogenesis_and_mutagenesis_and_impairment_of_fertility) {
        this.carcinogenesis_and_mutagenesis_and_impairment_of_fertility = carcinogenesis_and_mutagenesis_and_impairment_of_fertility;
    }

    public String getDosage_forms_and_strengths() {
        return dosage_forms_and_strengths;
    }

    public void setDosage_forms_and_strengths(String dosage_forms_and_strengths) {
        this.dosage_forms_and_strengths = dosage_forms_and_strengths;
    }

    public String getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(String pregnancy) {
        this.pregnancy = pregnancy;
    }

    public String getClinical_studies() {
        return clinical_studies;
    }

    public void setClinical_studies(String clinical_studies) {
        this.clinical_studies = clinical_studies;
    }

    public String getNursing_mothers() {
        return nursing_mothers;
    }

    public void setNursing_mothers(String nursing_mothers) {
        this.nursing_mothers = nursing_mothers;
    }

    public String getClinical_pharmacology() {
        return clinical_pharmacology;
    }

    public void setClinical_pharmacology(String clinical_pharmacology) {
        this.clinical_pharmacology = clinical_pharmacology;
    }

    public String getPharmacokinetics() {
        return pharmacokinetics;
    }

    public void setPharmacokinetics(String pharmacokinetics) {
        this.pharmacokinetics = pharmacokinetics;
    }

    public String getClinical_studies_table() {
        return clinical_studies_table;
    }

    public void setClinical_studies_table(String clinical_studies_table) {
        this.clinical_studies_table = clinical_studies_table;
    }

    public OpenFdaResponseNode getOpenfda() {
        return openfda;
    }

    public void setOpenfda(OpenFdaResponseNode openfda) {
        this.openfda = openfda;
    }

    public String getPrimarysourcecountry() {
        return primarysourcecountry;
    }

    public void setPrimarysourcecountry(String primarysourcecountry) {
        this.primarysourcecountry = primarysourcecountry;
    }

    public String getReceiptdate() {
        return receiptdate;
    }

    public void setReceiptdate(String receiptdate) {
        this.receiptdate = receiptdate;
    }

    public String getTransmissiondate() {
        return transmissiondate;
    }

    public void setTransmissiondate(String transmissiondate) {
        this.transmissiondate = transmissiondate;
    }

    public String getOccurcountry() {
        return occurcountry;
    }

    public void setOccurcountry(String occurcountry) {
        this.occurcountry = occurcountry;
    }

    public PatientResponseNode getPatient() {
        return patient;
    }

    public void setPatient(PatientResponseNode patient) {
        this.patient = patient;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public List<String> getProduct_type() {
        return product_type;
    }

    public void setProduct_type(List<String> product_type) {
        this.product_type = product_type;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRecalling_firm() {
        return recalling_firm;
    }

    public void setRecalling_firm(String recalling_firm) {
        this.recalling_firm = recalling_firm;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

    public String getVoluntary_mandated() {
        return voluntary_mandated;
    }

    public void setVoluntary_mandated(String voluntary_mandated) {
        this.voluntary_mandated = voluntary_mandated;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getCode_info() {
        return code_info;
    }

    public void setCode_info(String code_info) {
        this.code_info = code_info;
    }

    public String getInitial_firm_notification() {
        return initial_firm_notification;
    }

    public void setInitial_firm_notification(String initial_firm_notification) {
        this.initial_firm_notification = initial_firm_notification;
    }


    
}
