package com.tlabs.eve.zkb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tlabs.eve.api.mail.KillMail;

public class ZKillMail extends KillMail {

    public static class Info {
        private String hash;
        private double totalValue;
        private long points;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public double getTotalValue() {
            return totalValue;
        }

        public void setTotalValue(double totalValue) {
            this.totalValue = totalValue;
        }

        public long getPoints() {
            return points;
        }

        public void setPoints(long points) {
            this.points = points;
        }
    }

    @JsonProperty("zkb")
    private Info info = new Info();

    public String getHash() {
        return info.hash;
    }

    public double getValue() {
        return info.getTotalValue();
    }

    public long getPoints() {
        return info.getPoints();
    }
}
