package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.LinkedList;
import java.util.List;

public class StandingsResponse extends EveAPIResponse {

	private List<Standing> corporationStandings;
    private List<Standing> agentStandings;
    private List<Standing> factionStandings;

	public StandingsResponse() {
		super();		
		this.corporationStandings = new LinkedList<Standing>();
		this.agentStandings = new LinkedList<Standing>();
		this.factionStandings = new LinkedList<Standing>();
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
