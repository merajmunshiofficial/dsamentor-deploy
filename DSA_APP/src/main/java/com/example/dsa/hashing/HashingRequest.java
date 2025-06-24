package com.example.dsa.hashing;

import jakarta.validation.constraints.*;

public class HashingRequest {

    public static class LongestConsecutiveInput {
        @NotNull
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class SubarraySumInput {
        @NotNull
        @Size(min = 1)
        private int[] nums;
        
        private int k;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class LongestSubarrayInput {
        @NotNull
        @Size(min = 1)
        private int[] nums;
        
        private int k;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class SubarraysWithXorKInput {
        @NotNull
        @Size(min = 1)
        private int[] nums;
        
        private int k;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }
} 