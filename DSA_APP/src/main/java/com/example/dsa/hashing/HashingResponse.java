package com.example.dsa.hashing;

public class HashingResponse {
    private int longestConsecutive;
    private int subarraySum;
    private int longestSubarray;
    private int subarraysWithXorK;

    public HashingResponse() {}

    public HashingResponse(int result) {
        this.longestConsecutive = result;
    }

    // Getters and Setters
    public int getLongestConsecutive() { return longestConsecutive; }
    public void setLongestConsecutive(int longestConsecutive) { this.longestConsecutive = longestConsecutive; }

    public int getSubarraySum() { return subarraySum; }
    public void setSubarraySum(int subarraySum) { this.subarraySum = subarraySum; }

    public int getLongestSubarray() { return longestSubarray; }
    public void setLongestSubarray(int longestSubarray) { this.longestSubarray = longestSubarray; }

    public int getSubarraysWithXorK() { return subarraysWithXorK; }
    public void setSubarraysWithXorK(int subarraysWithXorK) { this.subarraysWithXorK = subarraysWithXorK; }
} 