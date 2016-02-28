package com.tlabs.eve.api;


import java.util.ArrayList;
import java.util.List;

public class StandingsResponse extends EveAPIResponse {

    private static final long serialVersionUID = -8557614838323097880L;

    private List<Standing> corporationStandings;
    private List<Standing> agentStandings;
    private List<Standing> factionStandings;

    public StandingsResponse() {
        super();
        this.corporationStandings = new ArrayList<>();
        this.agentStandings = new ArrayList<>();
        this.factionStandings = new ArrayList<>();
    }

    public final List<Standing> getCorporationStandings() {
        return corporationStandings;
    }

    public final List<Standing> getAgentStandings() {
        return agentStandings;
    }

    public final List<Standing> getFactionStandings() {
        return factionStandings;
    }

    public void addCorporationStanding(Standing j) {
        this.corporationStandings.add(j);
    }

    public void addAgentStanding(Standing j) {
        this.agentStandings.add(j);
    }

    public void addFactionStanding(Standing j) {
        this.factionStandings.add(j);
    }
}
