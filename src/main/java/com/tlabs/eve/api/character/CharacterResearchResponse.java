package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class CharacterResearchResponse extends EveAPIResponse {

    private static final long serialVersionUID = -6541706200116880518L;

    private List<ResearchJob> jobs;

    public CharacterResearchResponse() {
        super();
        this.jobs = new LinkedList<>();
    }

    public List<ResearchJob> getJobs() {
        return this.jobs;
    }

    public void addJob(ResearchJob j) {
        this.jobs.add(j);
    }
}
