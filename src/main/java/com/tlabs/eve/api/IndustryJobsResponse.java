package com.tlabs.eve.api;


import java.util.ArrayList;
import java.util.List;

public class IndustryJobsResponse extends EveAPIResponse {

    private static final long serialVersionUID = 2480972831954307791L;

    private List<IndustryJob> jobs;

    public IndustryJobsResponse() {
        super();
        this.jobs = new ArrayList<>();
    }

    public List<IndustryJob> getJobs() {
        return this.jobs;
    }

    public void addJob(IndustryJob j) {
        this.jobs.add(j);
    }
}
