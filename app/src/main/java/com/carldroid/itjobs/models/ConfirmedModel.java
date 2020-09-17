package com.carldroid.itjobs.models;

public
class ConfirmedModel {

    private String jobTitle;
    private String jobDescription;
    private String jobBudget;
    private String jobDuration;
    private String payMethod;
    private long idNumber;

    public ConfirmedModel(){
        /* Empty constructor*/
    }

    public ConfirmedModel(String jobTitle, String jobDescription, String jobBudget, String jobDuration, String payMethod, long idNumber) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobBudget = jobBudget;
        this.jobDuration = jobDuration;
        this.payMethod = payMethod;
        this.idNumber = idNumber;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
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
}
