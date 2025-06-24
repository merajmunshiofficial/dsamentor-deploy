package com.example.dsa.greedyalgorithm;

import jakarta.validation.constraints.*;
import java.util.List;

public class GreedyAlgorithmRequest {

    public static class MaxMeetingsInput {
        @NotNull
        @Size(min = 1)
        private int[] start;
        
        @NotNull
        @Size(min = 1)
        private int[] end;

        public int[] getStart() { return start; }
        public void setStart(int[] start) { this.start = start; }
        
        public int[] getEnd() { return end; }
        public void setEnd(int[] end) { this.end = end; }
    }

    public static class MaxNonOverlappingIntervalsInput {
        @NotNull
        private List<List<Integer>> intervals;

        public List<List<Integer>> getIntervals() { return intervals; }
        public void setIntervals(List<List<Integer>> intervals) { this.intervals = intervals; }
    }

    public static class InsertNewIntervalInput {
        @NotNull
        private List<List<Integer>> intervals;
        
        @NotNull
        @Size(min = 2, max = 2)
        private List<Integer> newInterval;

        public List<List<Integer>> getIntervals() { return intervals; }
        public void setIntervals(List<List<Integer>> intervals) { this.intervals = intervals; }
        
        public List<Integer> getNewInterval() { return newInterval; }
        public void setNewInterval(List<Integer> newInterval) { this.newInterval = newInterval; }
    }

    public static class LemonadeChangeInput {
        @NotNull
        @Size(min = 1)
        private int[] bills;

        public int[] getBills() { return bills; }
        public void setBills(int[] bills) { this.bills = bills; }
    }

    public static class JobSchedulingInput {
        @NotNull
        private List<List<Integer>> jobs;

        public List<List<Integer>> getJobs() { return jobs; }
        public void setJobs(List<List<Integer>> jobs) { this.jobs = jobs; }
    }

    public static class FindPlatformInput {
        @NotNull
        @Size(min = 1)
        private int[] arr;
        
        @NotNull
        @Size(min = 1)
        private int[] dep;
        
        @Min(1)
        private int n;

        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
        
        public int[] getDep() { return dep; }
        public void setDep(int[] dep) { this.dep = dep; }
        
        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
    }

    public static class FindMaximumCookieStudentsInput {
        @NotNull
        @Size(min = 1)
        private int[] g;
        
        @NotNull
        @Size(min = 1)
        private int[] s;

        public int[] getG() { return g; }
        public void setG(int[] g) { this.g = g; }
        
        public int[] getS() { return s; }
        public void setS(int[] s) { this.s = s; }
    }

    public static class CanJumpInput {
        @NotNull
        @Size(min = 1)
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class CandyInput {
        @NotNull
        @Size(min = 1)
        private int[] ratings;

        public int[] getRatings() { return ratings; }
        public void setRatings(int[] ratings) { this.ratings = ratings; }
    }

    public static class IsValidInput {
        @NotBlank
        private String s;

        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
    }

    public static class SolveInput {
        @Min(0)
        private int n;
        
        @NotNull
        private int[] arr;

        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
        
        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
    }
} 