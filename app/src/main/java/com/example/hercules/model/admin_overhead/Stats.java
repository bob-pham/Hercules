package com.example.hercules.model.admin_overhead;

public class Stats {

    private int gold;
    private int experience;
    private int level;
    private int currentStreak;
    private int longestStreak;

    private int weightChange;
    private int currentWeight;
    private int minutesExercised;
    private double bodyFatPercentage;
    private double bodyMassIndex;
    private double height;
    private double waistCircumference;
    private double bloodPressure;
    private double bench;
    private double squat;
    private double deadLift;

    public Stats(int gold, int experience, int level, int weightChange, int currentWeight, int minutesExercised, int currentStreak, int longestStreak, double bodyFatPercentage, double bodyMassIndex, double height, double waistCircumference, double bloodPressure, double bench, double squat, double deadLift) {
        this.gold = gold;
        this.experience = experience;
        this.level = level;
        this.weightChange = weightChange;
        this.currentWeight = currentWeight;
        this.minutesExercised = minutesExercised;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.bodyFatPercentage = bodyFatPercentage;
        this.bodyMassIndex = bodyMassIndex;
        this.height = height;
        this.waistCircumference = waistCircumference;
        this.bloodPressure = bloodPressure;
        this.bench = bench;
        this.squat = squat;
        this.deadLift = deadLift;
    }

    public Stats() {
        this.gold = -1;
        this.experience = -1;
        this.level = -1;
        this.weightChange = 0;
        this.currentWeight = -1;
        this.minutesExercised = -1;
        this.currentStreak = -1;
        this.longestStreak = -1;
        this.bodyFatPercentage = -1;
        this.bodyMassIndex = -1;
        this.height = -1;
        this.waistCircumference = -1;
        this.bloodPressure = -1;
        this.bench = -1;
        this.squat = -1;
        this.deadLift = -1;
    }

    public void updateStreak() {
        this.currentStreak++;
        if (this.currentStreak > this.longestStreak) {
            this.longestStreak = currentStreak;
        }
    }

    public void purchase(int price) throws Exception {
        if (gold - price < 0) {
            throw new Exception("Insufficient funds");
        } else {
            gold -= price;
        }
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void addExperience(int exp) {
        int xpNeeded = calculateXPNeeded();
        this.experience += exp;

        if (this.experience > xpNeeded) {
            int temp = this.experience - xpNeeded;
            this.level++;
            addExperience(temp);
        }
    }

    private int calculateXPNeeded() {
        return (this.level * this.level) + (this.level * 10);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public void setLongestStreak(int longestStreak) {
        this.longestStreak = longestStreak;
    }

    public int getWeightChange() {
        return weightChange;
    }

    public void setWeightChange(int weightChange) {
        this.weightChange = weightChange;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getMinutesExercised() {
        return minutesExercised;
    }

    public void setMinutesExercised(int minutesExercised) {
        this.minutesExercised = minutesExercised;
    }

    public double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public double getBodyMassIndex() {
        return bodyMassIndex;
    }

    public void setBodyMassIndex(double bodyMassIndex) {
        this.bodyMassIndex = bodyMassIndex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWaistCircumference() {
        return waistCircumference;
    }

    public void setWaistCircumference(double waistCircumference) {
        this.waistCircumference = waistCircumference;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getBench() {
        return bench;
    }

    public void setBench(double bench) {
        this.bench = bench;
    }

    public double getSquat() {
        return squat;
    }

    public void setSquat(double squat) {
        this.squat = squat;
    }

    public double getDeadLift() {
        return deadLift;
    }

    public void setDeadLift(double deadLift) {
        this.deadLift = deadLift;
    }
}
