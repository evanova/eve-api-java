package com.tlabs.eve.api.character;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Certificate implements Serializable {

    public enum Level {
        BASIC(0), STANDARD(1), IMPROVED(2), ADVANCED(3), ELITE(4);

        private final int level;

        private Level(final int level) {
            this.level = level;
        }

        public static Level min(final Level a, final Level b) {
            if ((null == a) || (null == b)) {
                return null;
            }
            return (a.level <= b.level) ? a : b;
        }

        public static Level max(final Level a, final Level b) {
            if (null == a) {
                return b;
            }
            if (null == b) {
                return a;
            }
            return (a.level > b.level) ? a : b;
        }
    }

    private static final long serialVersionUID = -2288742167364516064L;

    private long certificateID;
    private long groupID;
    private String name;
    private String description;

    private List<Long> recommendedForTypes;
    //Map<Skill ID, Map<Certificate.Type, level>>
    private Map<Long, Map<Level, Integer>> skillTypeLevels;

    public final long getCertificateID() {
        return certificateID;
    }

    public final void setCertificateID(long certificateID) {
        this.certificateID = certificateID;
    }

    public final long getGroupID() {
        return groupID;
    }

    public final void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final List<Long> getRecommendedFor() {
        return recommendedForTypes;
    }

    public final void setRecommendedFor(List<Long> recommendedForTypes) {
        this.recommendedForTypes = recommendedForTypes;
    }

    public final Map<Long, Map<Level, Integer>> getRequiredSkills() {
        return skillTypeLevels;
    }

    public final void setRequiredSkills(Map<Long, Map<Level, Integer>> skillTypeLevels) {
        this.skillTypeLevels = skillTypeLevels;
    }

}
