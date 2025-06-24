package com.example.dsa.sorting;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class SortingRequest {

    public static class SortInput {
        @NotNull
        @Schema(description = "Array of numbers to sort", example = "[5, 2, 8, 1, 9]")
        private int[] nums;

        public int[] getNums() {
            return nums;
        }

        public void setNums(int[] nums) {
            this.nums = nums;
        }
    }
} 