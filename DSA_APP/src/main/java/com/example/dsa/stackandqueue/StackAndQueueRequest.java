package com.example.dsa.stackandqueue;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class StackAndQueueRequest {
    public static class AsteroidCollisionInput {
        @NotNull
        @Schema(description = "Array of asteroids", example = "[5, 10, -5]")
        private int[] asteroids;
        public int[] getAsteroids() { return asteroids; }
        public void setAsteroids(int[] asteroids) { this.asteroids = asteroids; }
    }

    public static class CelebrityInput {
        @NotNull
        @Schema(description = "Matrix representing people", example = "[[0,1,0],[0,0,0],[0,1,0]]")
        private int[][] matrix;
        @NotNull
        @Schema(description = "Number of people", example = "3")
        private int n;
        public int[][] getMatrix() { return matrix; }
        public void setMatrix(int[][] matrix) { this.matrix = matrix; }
        @com.fasterxml.jackson.annotation.JsonProperty("Matrix")
        public void setMatrixUpper(int[][] matrix) { this.matrix = matrix; }
        @com.fasterxml.jackson.annotation.JsonProperty("matrix")
        public void setMatrixLower(int[][] matrix) { this.matrix = matrix; }
        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
        @jakarta.validation.constraints.AssertTrue(message = "matrix must not be null and must be a square matrix of size n x n")
        private boolean isMatrixValid() {
            if (matrix == null || n <= 0) return false;
            if (matrix.length != n) return false;
            for (int[] row : matrix) {
                if (row == null || row.length != n) return false;
            }
            return true;
        }
    }

    public static class IsValidInput {
        @NotNull
        @Schema(description = "Parentheses string", example = "()[]{}")
        private String s;
        public String getS() { return s; }
        @com.fasterxml.jackson.annotation.JsonProperty("s")
        public void setS(String s) { this.s = s; }
        @com.fasterxml.jackson.annotation.JsonProperty("S")
        public void setSUpper(String s) { this.s = s; }
    }

    public static class LargestRectangleAreaInput {
        @NotNull
        @Schema(description = "Heights of histogram bars", example = "[2,1,5,6,2,3]")
        private int[] heights;
        public int[] getHeights() { return heights; }
        public void setHeights(int[] heights) { this.heights = heights; }
    }

    public static class LFUCacheInput {
        @NotNull
        @Schema(description = "Operations for LFU Cache", example = "[{\"op\":\"put\",\"key\":1,\"value\":1},{\"op\":\"get\",\"key\":1}]")
        private String operations; // JSON string or custom structure
        public String getOperations() { return operations; }
        public void setOperations(String operations) { this.operations = operations; }
    }

    public static class StockSpanInput {
        @NotNull
        @Schema(description = "Stock prices", example = "[100, 80, 60, 70, 60, 75, 85]")
        private int[] prices;
        public int[] getPrices() { return prices; }
        public void setPrices(int[] prices) { this.prices = prices; }
    }

    public static class SubArrayRangesInput {
        @NotNull
        @Schema(description = "Array of numbers", example = "[1,2,3]")
        private int[] nums;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        @com.fasterxml.jackson.annotation.JsonProperty("Nums")
        public void setNumsUpper(int[] nums) { this.nums = nums; }
        @com.fasterxml.jackson.annotation.JsonProperty("nums")
        public void setNumsLower(int[] nums) { this.nums = nums; }
    }

    public static class SumSubarrayMinsInput {
        @NotNull
        @Schema(description = "Array of numbers", example = "[3,1,2,4]")
        private int[] arr;
        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
        @com.fasterxml.jackson.annotation.JsonProperty("Arr")
        public void setArrUpper(int[] arr) { this.arr = arr; }
        @com.fasterxml.jackson.annotation.JsonProperty("arr")
        public void setArrLower(int[] arr) { this.arr = arr; }
    }

    public static class TrapInput {
        @NotNull
        @Schema(description = "Heights of bars", example = "[0,1,0,2,1,0,1,3,2,1,2,1]")
        private int[] height;
        public int[] getHeight() { return height; }
        public void setHeight(int[] height) { this.height = height; }
        @com.fasterxml.jackson.annotation.JsonProperty("Height")
        public void setHeightUpper(int[] height) { this.height = height; }
        @com.fasterxml.jackson.annotation.JsonProperty("height")
        public void setHeightLower(int[] height) { this.height = height; }
    }
}