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
    private int manufacturingTime;

    private List<Map<Long, Integer>> inventionMaterials;
    private List<Map<Long, Integer>> inventionProducts;
    private List<Map<Long, Integer>> inventionSkills;
    private int inventionTime;

    private List<Map<Long, Integer>> copyingMaterials;
    private List<Map<Long, Integer>> copyingSkills;
    private int copyingTime;

    private List<Map<Long, Integer>> researchMaterialsMaterials;
    private List<Map<Long, Integer>> researchMaterialsSkills;
    private int researchMaterialsTime;

    private List<Map<Long, Integer>> researchTimeMaterials;
    private List<Map<Long, Integer>> researchTimeSkills;
    private int researchTimeTime;
}
