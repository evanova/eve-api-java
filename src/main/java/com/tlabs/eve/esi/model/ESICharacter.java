package com.tlabs.eve.esi.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ESICharacter {

    public static class Skill {
        private long skillId;
        private long skillPoints;
        private int skillLevel;

        public long getSkillId() {
            return skillId;
        }

        public void setSkillId(long skillId) {
            this.skillId = skillId;
        }

        public long getSkillPoints() {
            return skillPoints;
        }

        public void setSkillPoints(long skillPoints) {
            this.skillPoints = skillPoints;
        }

        public int getSkillLevel() {
            return skillLevel;
        }

        public void setSkillLevel(int skillLevel) {
            this.skillLevel = skillLevel;
        }
    }

    public static class Training {
        private long finishDate;

        private int finishedLevel;

        private long levelEndSp;

        private long levelStartSp;

        private int queuePosition;

        private long skillId;

        private long startDate;

        private long trainingStartSp;

        public long getFinishDate() {
            return finishDate;
        }

        public void setFinishDate(long finishDate) {
            this.finishDate = finishDate;
        }

        public int getFinishedLevel() {
            return finishedLevel;
        }

        public void setFinishedLevel(int finishedLevel) {
            this.finishedLevel = finishedLevel;
        }

        public long getLevelEndSp() {
            return levelEndSp;
        }

        public void setLevelEndSp(long levelEndSp) {
            this.levelEndSp = levelEndSp;
        }

        public long getLevelStartSp() {
            return levelStartSp;
        }

        public void setLevelStartSp(long levelStartSp) {
            this.levelStartSp = levelStartSp;
        }

        public int getQueuePosition() {
            return queuePosition;
        }

        public void setQueuePosition(int queuePosition) {
            this.queuePosition = queuePosition;
        }

        public long getSkillId() {
            return skillId;
        }

        public void setSkillId(long skillId) {
            this.skillId = skillId;
        }

        public long getStartDate() {
            return startDate;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }

        public long getTrainingStartSp() {
            return trainingStartSp;
        }

        public void setTrainingStartSp(long trainingStartSp) {
            this.trainingStartSp = trainingStartSp;
        }
    }

    public static class History {
        private long corporationId;
        private boolean isDeleted;

        private long recordId;

        private long startDate;

        public long getCorporationId() {
            return corporationId;
        }

        public void setCorporationId(long corporationId) {
            this.corporationId = corporationId;
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        public void setDeleted(boolean deleted) {
            isDeleted = deleted;
        }

        public long getRecordId() {
            return recordId;
        }

        public void setRecordId(long recordId) {
            this.recordId = recordId;
        }

        public long getStartDate() {
            return startDate;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }
    }

    private final List<History> history = new ArrayList<>();
    private final List<Skill> skills = new ArrayList<>();
    private final List<Training> trainings = new ArrayList<>();

    private final Long id;
    private String name;

    private String portrait64;
    private String portrait128;
    private String portrait256;
    private String portrait512;

    private long remapCooldownDate;
    private long lastRemapDate;

    private int bonusRemaps;

    private int charisma;
    private int intelligence;
    private int memory;
    private int perception;
    private int willpower;

    private float walletBalance;
    private long totalSkillPoints;

    public ESICharacter(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<History> getHistory() {
        return history;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public String getName() {
        return name;
    }

    public ESICharacter setName(String name) {
        this.name = name;
        return this;
    }

    public ESICharacter add(final History h) {
        this.history.add(h);
        return this;
    }

    public ESICharacter add(final Skill skill) {
        this.skills.add(skill);
        return this;
    }

    public ESICharacter add(final Training training) {
        this.trainings.add(training);
        Collections.sort(this.trainings, new Comparator<Training>() {
            @Override
            public int compare(Training o1, Training o2) {
                return Integer.compare(o1.getQueuePosition(), o2.getQueuePosition());
            }
        });
        return this;
    }

    public String getPortrait64() {
        return portrait64;
    }

    public void setPortrait64(String portrait64) {
        this.portrait64 = portrait64;
    }

    public String getPortrait128() {
        return portrait128;
    }

    public void setPortrait128(String portrait128) {
        this.portrait128 = portrait128;
    }

    public String getPortrait256() {
        return portrait256;
    }

    public void setPortrait256(String portrait256) {
        this.portrait256 = portrait256;
    }

    public String getPortrait512() {
        return portrait512;
    }

    public void setPortrait512(String portrait512) {
        this.portrait512 = portrait512;
    }

    public long getRemapCooldownDate() {
        return remapCooldownDate;
    }

    public void setRemapCooldownDate(long remapCooldownDate) {
        this.remapCooldownDate = remapCooldownDate;
    }

    public long getLastRemapDate() {
        return lastRemapDate;
    }

    public void setLastRemapDate(long lastRemapDate) {
        this.lastRemapDate = lastRemapDate;
    }

    public int getBonusRemaps() {
        return bonusRemaps;
    }

    public void setBonusRemaps(int bonusRemaps) {
        this.bonusRemaps = bonusRemaps;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getWillpower() {
        return willpower;
    }

    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }

    public float getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(float walletBalance) {
        this.walletBalance = walletBalance;
    }

    public long getTotalSkillPoints() {
        return totalSkillPoints;
    }

    public void setTotalSkillPoints(long totalSkillPoints) {
        this.totalSkillPoints = totalSkillPoints;
    }
}
