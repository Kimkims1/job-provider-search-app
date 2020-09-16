package com.carldroid.itjobs.models;

public
class JobModel {

    private String jobTitle;
    private String jobDescription;
    private String jobBudget;
    private String jobDuration;
    private String payMethod;

    public JobModel(){
        /* Empty constructor*/
    }

    public JobModel(String jobTitle, String jobDescription, String jobBudget, String jobDuration, String payMethod) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobBudget = jobBudget;
        this.jobDuration = jobDuration;
        this.payMethod = payMethod;
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
