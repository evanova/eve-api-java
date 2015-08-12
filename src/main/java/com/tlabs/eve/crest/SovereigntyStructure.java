package com.tlabs.eve.crest;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class SovereigntyStructure implements Serializable {

    private static final long serialVersionUID = -5074812115334607737L;

    public static class SovereigntyItem implements Serializable {

        private static final long serialVersionUID = 1791161767707159487L;

        @JsonProperty
        private long id;

        @JsonProperty
        private String name;

        @JsonProperty
        private String href;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    @JsonProperty
    private long structureID;

    @JsonProperty
    private long vulnerabilityOccupancyLevel;

    private long vulnerableStartTime;

    private long vulnerableEndTime;

    private Map<String, SovereigntyItem> items;

    public long getStructureID() {
        return structureID;
    }

    public void setStructureID(long structureID) {
        this.structureID = structureID;
    }

    public long getVulnerabilityOccupancyLevel() {
        return vulnerabilityOccupancyLevel;
    }

    public void setVulnerabilityOccupancyLevel(long vulnerabilityOccupancyLevel) {
        this.vulnerabilityOccupancyLevel = vulnerabilityOccupancyLevel;
    }

    public long getVulnerableStartTime() {
        return vulnerableStartTime;
    }

    public void setVulnerableStartTime(long vulnerableStartTime) {
        this.vulnerableStartTime = vulnerableStartTime;
    }

    public Map<String, SovereigntyItem> getItems() {
        return items;
    }

    public void setItems(Map<String, SovereigntyItem> items) {
        this.items = items;
    }

    public long getVulnerableEndTime() {
        return vulnerableEndTime;
    }

    public void setVulnerableEndTime(long vulnerableEndTime) {
        this.vulnerableEndTime = vulnerableEndTime;
    }

    @JsonSetter
    public void setVulnerableStartTime(final Date date) {
        this.vulnerableStartTime = date.getTime();
    }

    @JsonSetter
    public void setVulnerableEndTime(final Date date) {
        this.vulnerableEndTime = date.getTime();
    }

    @JsonAnySetter
    public void setItem(final String name, final SovereigntyItem item) {
        this.items.put(name, item);
    }
}
