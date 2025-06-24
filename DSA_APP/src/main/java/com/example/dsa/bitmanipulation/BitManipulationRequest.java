package com.example.dsa.bitmanipulation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class BitManipulationRequest {

    public static class DivideInput {
        @NotNull(message = "Dividend cannot be null")
        private Integer dividend;
        
        @NotNull(message = "Divisor cannot be null")
        private Integer divisor;

        public Integer getDividend() { return dividend; }
        public void setDividend(Integer dividend) { this.dividend = dividend; }
        
        public Integer getDivisor() { return divisor; }
        public void setDivisor(Integer divisor) { this.divisor = divisor; }
    }

    public static class SingleNumberInput {
        @NotNull(message = "Array cannot be null")
        @NotEmpty(message = "Array cannot be empty")
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class PowerSetInput {
        @NotNull(message = "Array cannot be null")
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class FindRangeXORInput {
        @NotNull(message = "Left bound cannot be null")
        private Integer l;
        
        @NotNull(message = "Right bound cannot be null")
        private Integer r;

        public Integer getL() { return l; }
        public void setL(Integer l) { this.l = l; }
        
        public Integer getR() { return r; }
        public void setR(Integer r) { this.r = r; }
    }

    public static class MinBitsFlipInput {
        @NotNull(message = "Start number cannot be null")
        private Integer start;
        
        @NotNull(message = "Goal number cannot be null")
        private Integer goal;

        public Integer getStart() { return start; }
        public void setStart(Integer start) { this.start = start; }
        
        public Integer getGoal() { return goal; }
        public void setGoal(Integer goal) { this.goal = goal; }
    }
} 