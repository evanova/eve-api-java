package com.tlabs.eve.crest;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.tlabs.eve.api.Sovereignty;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class SovereigntyStructure implements Serializable {

    private static final long serialVersionUID = -5074812115334607737L;

    @Getter
    @Setter
    public static class SovereigntyItem implements Serializable {

        private static final long serialVersionUID = 1791161767707159487L;

        @JsonProperty
        private long id;

        @JsonProperty
        private String name;

        @JsonProperty
        private String href;

    }

    @JsonProperty
    @Getter
    @Setter
    private long structureID;

    @JsonProperty
    @Getter
    @Setter
    private long vulnerabilityOccupancyLevel;

    @Getter
    @Setter
    private long vulnerableStartTime;

    @Getter
    @Setter
    private long vulnerableEndTime;

    @Getter
    @Setter
    private Map<String, SovereigntyItem> items;

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
