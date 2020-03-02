package com.carldroid.itjobs;

public class AndroidDevModel {
    private String jobtitle;
    private String jobdescription;
    private String jobtime;
    private String joblocation;
    private Double jobbudget;

    public AndroidDevModel() {
        //Needed
    }

    public AndroidDevModel(String jobtitle, String jobdescription, String jobtime, String joblocation, Double jobbudget) {
        this.jobtitle = jobtitle;
        this.jobdescription = jobdescription;
        this.jobtime = jobtime;
        this.joblocation = joblocation;
        this.jobbudget = jobbudget;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }

    public String getJobtime() {
        return jobtime;
    }

    public void setJobtime(String jobtime) {
        this.jobtime = jobtime;
    }

    public String getJoblocation() {
        return joblocation;
    }

    public void setJoblocation(String joblocation) {
        this.joblocation = joblocation;
    }

    public Double getJobbudget() {
        return jobbudget;
    }

    public void setJobbudget(Double jobbudget) {
        this.jobbudget = jobbudget;
    }
}
