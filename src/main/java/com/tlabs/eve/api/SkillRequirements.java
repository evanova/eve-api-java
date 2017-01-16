package com.tlabs.eve.api;

import java.util.LinkedHashMap;
import java.util.Map;

final class SkillRequirements {

    private SkillRequirements() {}

    public static Map<Skill, Integer> mapAll(final Skill skill) {
        final Map<Skill, Integer> all = new LinkedHashMap<>();
        putAll(skill, all);

        final Map<Skill, Integer> returned = new LinkedHashMap<>();
        for (Map.Entry<Skill, Integer> a: all.entrySet()) {
            put(a.getKey(), a.getValue(), returned);
        }
        return returned;
    }

    private static void put(final Skill skill, Integer value, final Map<Skill, Integer> map) {
        for (Map.Entry<Skill, Integer> m: map.entrySet()) {
            if (m.getKey().getSkillID() == skill.getSkillID()) {
                if (value > m.getValue()) {
                    m.setValue(value);
                }
                return;
            }
        }

        map.put(skill, value);
    }

    private static void putAll(final Skill skill, final Map<Skill, Integer> map) {
        for (Skill s: skill.getRequirements().keySet()) {
            putAll(s, map);
        }
        map.putAll(skill.getRequirements());
    }
}
