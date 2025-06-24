package com.example.dsa.tries;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class TriesRequest {
    public static class CountDistinctInput {
        @NotNull
        @Schema(description = "Input string", example = "ababa")
        private String s;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
    }

    public static class FindMaximumXORInput {
        @NotNull
        @Schema(description = "Array of numbers", example = "[3, 10, 5, 25, 2, 8]")
        private int[] nums;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }
} 