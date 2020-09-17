package com.carldroid.itjobs.models;

public
class AppliedModel {

    private String documentId;
    private String jobTitle;
    private String jobDescription;
    private String jobBudget;
    private String jobDuration;
    private String payMethod;
    private long idNumber;
    private int isApplied;

    public AppliedModel() {
    }

    public AppliedModel(String documentId, String jobTitle, String jobDescription, String jobBudget, String jobDuration, String payMethod, long idNumber, int isApplied) {
        this.documentId = documentId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobBudget = jobBudget;
        this.jobDuration = jobDuration;
        this.payMethod = payMethod;
        this.idNumber = idNumber;
        this.isApplied = isApplied;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobBudget() {
        return jobBudget;
    }

    public void setJobBudget(String jobBudget) {
        this.jobBudget = jobBudget;
    }

    public String getJobDuration() {
        return jobDuration;
    }

    public void setJobDuration(String jobDuration) {
        this.jobDuration = jobDuration;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public int getIsApplied() {
        return isApplied;
    }

    public void setIsApplied(int isApplied) {
        this.isApplied = isApplied;
    }
}
