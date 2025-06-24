package com.example.dsa.bitmanipulation;

import java.util.List;

public class BitManipulationResponse {
    private Integer divideResult;
    private Integer singleNumber;
    private Integer singleNumberII;
    private int[] singleNumberIII;
    private List<List<Integer>> powerSet;
    private Integer findRangeXOR;
    private Integer minBitsFlip;

    public BitManipulationResponse() {}

    public BitManipulationResponse(Integer divideResult) {
        this.divideResult = divideResult;
    }

    public BitManipulationResponse(Integer singleNumber, boolean isSingleNumber) {
        this.singleNumber = singleNumber;
    }

    public BitManipulationResponse(List<List<Integer>> powerSet) {
        this.powerSet = powerSet;
    }

    public BitManipulationResponse(Integer findRangeXOR, String type) {
        this.findRangeXOR = findRangeXOR;
    }

    public BitManipulationResponse(Integer minBitsFlip, int dummy) {
        this.minBitsFlip = minBitsFlip;
    }

    // Getters and Setters
    public Integer getDivideResult() { return divideResult; }
    public void setDivideResult(Integer divideResult) { this.divideResult = divideResult; }

    public Integer getSingleNumber() { return singleNumber; }
    public void setSingleNumber(Integer singleNumber) { this.singleNumber = singleNumber; }

    public Integer getSingleNumberII() { return singleNumberII; }
    public void setSingleNumberII(Integer singleNumberII) { this.singleNumberII = singleNumberII; }

    public int[] getSingleNumberIII() { return singleNumberIII; }
    public void setSingleNumberIII(int[] singleNumberIII) { this.singleNumberIII = singleNumberIII; }

    public List<List<Integer>> getPowerSet() { return powerSet; }
    public void setPowerSet(List<List<Integer>> powerSet) { this.powerSet = powerSet; }

    public Integer getFindRangeXOR() { return findRangeXOR; }
    public void setFindRangeXOR(Integer findRangeXOR) { this.findRangeXOR = findRangeXOR; }

    public Integer getMinBitsFlip() { return minBitsFlip; }
    public void setMinBitsFlip(Integer minBitsFlip) { this.minBitsFlip = minBitsFlip; }
} 