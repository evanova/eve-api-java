package com.tlabs.eve.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

//@see blueprints.yaml
public class Blueprint implements Serializable {

    private long typeID;

    private int maxProduction;

    private List<Map<Long, Integer>> manufacturingMaterials;
    private List<Map<Long, Integer>> manufacturingProducts;
    private List<Map<Long, Integer>> manufacturingSkills;
    private long manufacturingTime;

    private List<Map<Long, Integer>> inventionMaterials;
    private List<Map<Long, Integer>> inventionProducts;
    private List<Map<Long, Integer>> inventionSkills;
    private long inventionTime;

    private List<Map<Long, Integer>> copyingMaterials;
    private List<Map<Long, Integer>> copyingSkills;
    private long copyingTime;

    private List<Map<Long, Integer>> researchMaterialsMaterials;
    private List<Map<Long, Integer>> researchMaterialsSkills;
    private long researchMaterialsTime;

    private List<Map<Long, Integer>> researchTimeMaterials;
    private List<Map<Long, Integer>> researchTimeSkills;
    private long researchTimeTime;

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public long getResearchMaterialsTime() {
        return researchMaterialsTime;
    }

    public void setResearchMaterialsTime(long researchMaterialsTime) {
        this.researchMaterialsTime = researchMaterialsTime;
    }

    public long getCopyingTime() {
        return copyingTime;
    }

    public void setCopyingTime(long copyingTime) {
        this.copyingTime = copyingTime;
    }

    public long getInventionTime() {
        return inventionTime;
    }

    public void setInventionTime(long inventionTime) {
        this.inventionTime = inventionTime;
    }

    public long getManufacturingTime() {
        return manufacturingTime;
    }

    public void setManufacturingTime(long manufacturingTime) {
        this.manufacturingTime = manufacturingTime;
    }

    public long getResearchTimeTime() {
        return researchTimeTime;
    }

    public void setResearchTimeTime(long researchTimeTime) {
        this.researchTimeTime = researchTimeTime;
    }

    public int getMaxProduction() {
        return maxProduction;
    }

    public void setMaxProduction(int maxProduction) {
        this.maxProduction = maxProduction;
    }
}
