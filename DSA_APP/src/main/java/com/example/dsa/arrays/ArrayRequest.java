package com.example.dsa.arrays;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArrayRequest {
    @Schema(description = "Input array of integers", example = "[1,2,3,4]")
    private int[] nums;

    @Schema(description = "Target value (for problems like fourSum)", example = "0")
    private Integer target;

    public int[] getNums() {
        return nums;
    }
    public void setNums(int[] nums) {
        this.nums = nums;
    }
    public Integer getTarget() {
        return target;
    }
    public void setTarget(Integer target) {
        this.target = target;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IntArrayInput {
        @NotNull
        @Schema(description = "Input array of integers", example = "[1,2,3,4]")
        private int[] nums;
        public int[] getNums() { return nums; }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IntArrayAndTargetInput {
        @NotNull
        @Schema(description = "Input array of integers", example = "[1,0,-1,0,2,-2]")
        private int[] nums;
        @NotNull
        @Schema(description = "Target value", example = "0")
        private int target;
        public int[] getNums() { return nums; }
        public int getTarget() { return target; }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RotateArrayInput {
        @NotNull
        @Schema(description = "Input array of integers", example = "[1,2,3,4,5,6,7]")
        private int[] nums;
        @NotNull
        @Schema(description = "Number of positions to rotate", example = "2")
        private int k;
        public int[] getNums() { return nums; }
        public int getK() { return k; }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IntersectionArrayInput {
        @NotNull
        @Schema(description = "First input array", example = "[1,2,2,1]")
        private int[] nums1;
        @NotNull
        @Schema(description = "Second input array", example = "[2,2]")
        private int[] nums2;
        public int[] getNums1() { return nums1; }
        public int[] getNums2() { return nums2; }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PascalTriangleInput {
        @NotNull
        @Schema(description = "Number of rows for Pascal's Triangle", example = "5")
        private int n;
        public int getN() { return n; }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MatrixInput {
        @NotNull
        @Schema(description = "2D input matrix", example = "[[1,2,3],[4,5,6],[7,8,9]]")
        private int[][] matrix;
        public int[][] getMatrix() { return matrix; }
    }
}