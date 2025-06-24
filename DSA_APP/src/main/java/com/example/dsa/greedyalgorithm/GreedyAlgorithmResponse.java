package com.example.dsa.greedyalgorithm;

import java.util.List;

public class GreedyAlgorithmResponse {
    private int maxMeetings;
    private int maxNonOverlappingIntervals;
    private List<List<Integer>> insertNewInterval;
    private boolean lemonadeChange;
    private int jobScheduling;
    private int findPlatform;
    private int findMaximumCookieStudents;
    private boolean canJump;
    private int candy;
    private boolean isValid;
    private int solve;

    public GreedyAlgorithmResponse() {}

    public GreedyAlgorithmResponse(int result) {
        this.maxMeetings = result;
    }

    public GreedyAlgorithmResponse(boolean result) {
        this.lemonadeChange = result;
    }

    public GreedyAlgorithmResponse(List<List<Integer>> result) {
        this.insertNewInterval = result;
    }

    // Getters and Setters
    public int getMaxMeetings() { return maxMeetings; }
    public void setMaxMeetings(int maxMeetings) { this.maxMeetings = maxMeetings; }

    public int getMaxNonOverlappingIntervals() { return maxNonOverlappingIntervals; }
    public void setMaxNonOverlappingIntervals(int maxNonOverlappingIntervals) { this.maxNonOverlappingIntervals = maxNonOverlappingIntervals; }

    public List<List<Integer>> getInsertNewInterval() { return insertNewInterval; }
    public void setInsertNewInterval(List<List<Integer>> insertNewInterval) { this.insertNewInterval = insertNewInterval; }

    public boolean getLemonadeChange() { return lemonadeChange; }
    public void setLemonadeChange(boolean lemonadeChange) { this.lemonadeChange = lemonadeChange; }

    public int getJobScheduling() { return jobScheduling; }
    public void setJobScheduling(int jobScheduling) { this.jobScheduling = jobScheduling; }

    public int getFindPlatform() { return findPlatform; }
    public void setFindPlatform(int findPlatform) { this.findPlatform = findPlatform; }

    public int getFindMaximumCookieStudents() { return findMaximumCookieStudents; }
    public void setFindMaximumCookieStudents(int findMaximumCookieStudents) { this.findMaximumCookieStudents = findMaximumCookieStudents; }

    public boolean getCanJump() { return canJump; }
    public void setCanJump(boolean canJump) { this.canJump = canJump; }

    public int getCandy() { return candy; }
    public void setCandy(int candy) { this.candy = candy; }

    public boolean getIsValid() { return isValid; }
    public void setIsValid(boolean isValid) { this.isValid = isValid; }

    public int getSolve() { return solve; }
    public void setSolve(int solve) { this.solve = solve; }
} 