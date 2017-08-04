package com.tlabs.eve.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//fuzzwork SDE or blueprint.yaml.
public class Blueprint {

    public static class Activity {

        private final Map<Long, Long> materials = new HashMap<>();
        private final Map<Long, Long> products = new HashMap<>();
        private final Map<Long, Long> skills = new HashMap<>();
        private final Map<Long, Float> probabilities = new HashMap<>();

        private long activityID;
        private long typeID;
        private long time;

        public long getTypeID() {
            return typeID;
        }

        public Activity setTypeID(long typeID) {
            this.typeID = typeID;
            return this;
        }

        public long getActivityID() {
            return activityID;
        }

        public Activity setActivityID(long activityID) {
            this.activityID = activityID;
            return this;
        }

        public long getTime() {
            return time;
        }

        public Activity setTime(long time) {
            this.time = time;
            return this;
        }

        public Map<Long, Long> getMaterials() {
            return Collections.unmodifiableMap(this.materials);
        }

        public void addMaterial(final long typeID, final long quantity) {
            final Long a = this.materials.get(typeID);
            this.materials.put(typeID, (null == a) ? quantity : a + quantity);
        }

        public Map<Long, Long> getProducts() {
            return Collections.unmodifiableMap(this.products);
        }

        public void addProduct(final long typeID, final long quantity) {
            final Long a = this.products.get(typeID);
            this.products.put(typeID, (null == a) ? quantity : a + quantity);
        }

        public Map<Long, Long> getSkills() {
            return Collections.unmodifiableMap(this.skills);
        }

        public void addSkill(final long typeID, final long quantity) {
            final Long a = this.skills.get(typeID);
            this.skills.put(typeID, (null == a) ? quantity : a + quantity);
        }

        public Map<Long, Float> getProbabilities() {
            return Collections.unmodifiableMap(this.probabilities);
        }

        public void addProbability(final long typeID, final float quantity) {
            final Float a = this.probabilities.get(typeID);
            this.probabilities.put(typeID, (null == a) ? quantity : a + quantity);
        }
    }

    private long typeID;
    private int maxProduction;

    private final List<Activity> activities = new ArrayList<>();

    public long getTypeID() {
        return typeID;
    }

    public Blueprint setTypeID(long typeID) {
        this.typeID = typeID;
        return this;
    }

    public int getMaxProduction() {
        return maxProduction;
    }

    public Blueprint setMaxProduction(int maxProduction) {
        this.maxProduction = maxProduction;
        return this;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(final Activity activity) {
        this.activities.add(activity);
    }
}
