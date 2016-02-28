package com.tlabs.eve.api.character;


import java.util.ArrayList;
import java.util.List;
import com.tlabs.eve.api.EveAPIResponse;

public class CharacterResearchResponse extends EveAPIResponse {

    private static final long serialVersionUID = -6541706200116880518L;

    private List<ResearchJob> jobs;

    public CharacterResearchResponse() {
        super();
        this.jobs = new ArrayList<>();
    }

    public List<ResearchJob> getJobs() {
        return this.jobs;
    }

    public void addJob(ResearchJob j) {
        this.jobs.add(j);
    }
}
