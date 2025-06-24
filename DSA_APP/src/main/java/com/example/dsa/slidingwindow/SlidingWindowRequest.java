package com.example.dsa.slidingwindow;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class SlidingWindowRequest {

    public static class CharacterReplacementInput {
        @NotNull
        @Schema(description = "Input string", example = "ABAB")
        private String s;
        @NotNull
        @Schema(description = "Number of replacements allowed", example = "2")
        private int k;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class KDistinctCharInput {
        @NotNull
        @Schema(description = "Input string", example = "araaci")
        private String s;
        @NotNull
        @Schema(description = "Number of distinct characters", example = "2")
        private int k;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class LongestNonRepeatingSubstringInput {
        @NotNull
        @Schema(description = "Input string", example = "abcabcbb")
        private String s;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
    }

    public static class LongestOnesInput {
        @NotNull
        @Schema(description = "Array of numbers", example = "[1,1,1,0,0,0,1,1,1,1,0]")
        private int[] nums;
        @NotNull
        @Schema(description = "Number of zeros to flip", example = "2")
        private int k;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class MaxScoreInput {
        @NotNull
        @Schema(description = "Array of card points", example = "[1,2,3,4,5,6,1]")
        private int[] cardPoints;
        @NotNull
        @Schema(description = "Number of cards to take", example = "3")
        private int k;
        public int[] getCardPoints() { return cardPoints; }
        public void setCardPoints(int[] cardPoints) { this.cardPoints = cardPoints; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class MinWindowInput {
        @NotNull
        @Schema(description = "Source string", example = "ADOBECODEBANC")
        private String s;
        @NotNull
        @Schema(description = "Target string", example = "ABC")
        private String t;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
        public String getT() { return t; }
        public void setT(String t) { this.t = t; }
    }

    public static class NumberOfOddSubarraysInput {
        @NotNull
        @Schema(description = "Array of numbers", example = "[1,1,2,1,1]")
        private int[] nums;
        @NotNull
        @Schema(description = "Number of odd numbers", example = "3")
        private int k;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class NumberOfSubstringsInput {
        private String s;
        public NumberOfSubstringsInput() {}
        public NumberOfSubstringsInput(String s) { 
            this.s = s; 
        }
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
    }

    public static class NumSubarraysWithSumInput {
        private List<Integer> nums;
        private int goal;
        public NumSubarraysWithSumInput() {}
        public NumSubarraysWithSumInput(List<Integer> nums, int goal) { 
            this.nums = nums; 
            this.goal = goal; 
        }
        public List<Integer> getNums() { return nums; }
        public void setNums(List<Integer> nums) { this.nums = nums; }
        public int getGoal() { return goal; }
        public void setGoal(int goal) { this.goal = goal; }
    }
} 