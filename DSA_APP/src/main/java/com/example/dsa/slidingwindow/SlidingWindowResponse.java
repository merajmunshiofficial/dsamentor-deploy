package com.example.dsa.slidingwindow;

public class SlidingWindowResponse {
    private Integer result;
    private String minWindow;
    public SlidingWindowResponse() {}
    public SlidingWindowResponse(Integer result) { this.result = result; }
    public SlidingWindowResponse(String minWindow) { this.minWindow = minWindow; }
    public Integer getResult() { return result; }
    public void setResult(Integer result) { this.result = result; }
    public String getMinWindow() { return minWindow; }
    public void setMinWindow(String minWindow) { this.minWindow = minWindow; }
} 