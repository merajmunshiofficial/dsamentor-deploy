package com.example.dsa.stackandqueue;

public class StackAndQueueResponse {
    private int[] intArrayResult;
    private Integer intResult;
    private Long longResult;
    private Boolean boolResult;
    private String stringResult;

    public StackAndQueueResponse() {}
    public StackAndQueueResponse(int[] intArrayResult) { this.intArrayResult = intArrayResult; }
    public StackAndQueueResponse(int intResult) { this.intResult = intResult; }
    public StackAndQueueResponse(long longResult) { this.longResult = longResult; }
    public StackAndQueueResponse(boolean boolResult) { this.boolResult = boolResult; }
    public StackAndQueueResponse(String stringResult) { this.stringResult = stringResult; }

    public int[] getIntArrayResult() { return intArrayResult; }
    public void setIntArrayResult(int[] intArrayResult) { this.intArrayResult = intArrayResult; }
    public Integer getIntResult() { return intResult; }
    public void setIntResult(Integer intResult) { this.intResult = intResult; }
    public Long getLongResult() { return longResult; }
    public void setLongResult(Long longResult) { this.longResult = longResult; }
    public Boolean getBoolResult() { return boolResult; }
    public void setBoolResult(Boolean boolResult) { this.boolResult = boolResult; }
    public String getStringResult() { return stringResult; }
    public void setStringResult(String stringResult) { this.stringResult = stringResult; }
} 