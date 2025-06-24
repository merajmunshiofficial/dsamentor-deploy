package com.example.dsa.heaps;

public class HeapsResponse {
    private int[] intArrayResult;
    private Integer intResult;
    private Boolean boolResult;

    public HeapsResponse() {}
    public HeapsResponse(int[] intArrayResult) { this.intArrayResult = intArrayResult; }
    public HeapsResponse(int intResult) { this.intResult = intResult; }
    public HeapsResponse(boolean boolResult) { this.boolResult = boolResult; }

    public int[] getIntArrayResult() { return intArrayResult; }
    public void setIntArrayResult(int[] intArrayResult) { this.intArrayResult = intArrayResult; }
    public Integer getIntResult() { return intResult; }
    public void setIntResult(Integer intResult) { this.intResult = intResult; }
    public Boolean getBoolResult() { return boolResult; }
    public void setBoolResult(Boolean boolResult) { this.boolResult = boolResult; }
} 