package com.example.dsa.binarysearch;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class BinarySearchRequest {
    public static class AggressiveCowsInput {
        @NotNull
        @Schema(description = "Input array of stall positions", example = "[0,3,4,7,10,9]")
        private int[] nums;
        @NotNull
        @Schema(description = "Number of cows", example = "4")
        private int k;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class FindFloorAndCeilInput {
        @NotNull
        @Schema(description = "Input array of integers (sorted)", example = "[1,2,8,10,10,12,19]")
        private int[] nums;
        @NotNull
        @Schema(description = "Value to find floor and ceil for", example = "5")
        private int x;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getX() { return x; }
        public void setX(int x) { this.x = x; }
    }

    @Schema(description = "Request with an integer array input")
    public static class IntArrayInput {
        @NotNull
        @Schema(description = "Input array", example = "[1,2,3,1]")
        private int[] nums;

        public IntArrayInput() {}
        public IntArrayInput(int[] nums) { this.nums = nums; }
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class FindMedianInput {
        @NotNull
        @Schema(description = "First sorted array", example = "[1,3]")
        private int[] nums1;
        @NotNull
        @Schema(description = "Second sorted array", example = "[2]")
        private int[] nums2;
        public int[] getNums1() { return nums1; }
        public void setNums1(int[] nums1) { this.nums1 = nums1; }
        public int[] getNums2() { return nums2; }
        public void setNums2(int[] nums2) { this.nums2 = nums2; }
    }

    public static class FindPagesInput {
        @NotNull
        @Schema(description = "Array of book pages", example = "[12,34,67,90]")
        private int[] nums;
        @NotNull
        @Schema(description = "Number of students", example = "2")
        private int students;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getStudents() { return students; }
        public void setStudents(int students) { this.students = students; }
    }

    @Schema(description = "Request with a 2D integer array input")
    public static class IntMatrixInput {
        @NotNull
        @Schema(description = "2D input array", example = "[[4,2,5],[2,9,3]]")
        private int[][] arr;

        public IntMatrixInput() {}
        public IntMatrixInput(int[][] arr) { this.arr = arr; }
        public int[][] getArr() { return arr; }
        public void setArr(int[][] arr) { this.arr = arr; }
    }

    public static class SearchInput {
        @NotNull
        @Schema(description = "Input array (sorted)", example = "[1,2,3,4,5]")
        private int[] nums;
        @NotNull
        @Schema(description = "Target value to search for", example = "3")
        private int target;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class SearchInsertInput {
        @NotNull
        @Schema(description = "Input array (sorted)", example = "[1,3,5,6]")
        private int[] nums;
        @NotNull
        @Schema(description = "Target value to search insert position for", example = "5")
        private int target;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class LowerBoundInput {
        @NotNull
        @Schema(description = "Input array (sorted)", example = "[1,2,2,3]")
        private int[] nums;
        @NotNull
        @Schema(description = "Value to find lower bound for", example = "2")
        private int x;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getX() { return x; }
        public void setX(int x) { this.x = x; }
    }

    public static class UpperBoundInput {
        @NotNull
        @Schema(description = "Input array (sorted)", example = "[1,2,2,3]")
        private int[] nums;
        @NotNull
        @Schema(description = "Value to find upper bound for", example = "2")
        private int x;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getX() { return x; }
        public void setX(int x) { this.x = x; }
    }

    public static class SearchMatrixInput {
        @NotNull
        @Schema(description = "2D input array (matrix)", example = "[[1,2,3],[4,5,6]]")
        private int[][] mat;
        @NotNull
        @Schema(description = "Target value to search for", example = "5")
        private int target;
        public int[][] getMat() { return mat; }
        public void setMat(int[][] mat) { this.mat = mat; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class SearchMatrix2DInput {
        @NotNull
        @Schema(description = "2D input array (matrix)", example = "[[1,4,7],[2,5,8],[3,6,9]]")
        private int[][] matrix;
        @NotNull
        @Schema(description = "Target value to search for", example = "8")
        private int target;
        public int[][] getMatrix() { return matrix; }
        public void setMatrix(int[][] matrix) { this.matrix = matrix; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class SmallestDivisorInput {
        @NotNull
        @Schema(description = "Input array", example = "[1,2,3,4,5]")
        private int[] nums;
        @NotNull
        @Schema(description = "Limit for the sum of divisions", example = "8")
        private int limit;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getLimit() { return limit; }
        public void setLimit(int limit) { this.limit = limit; }
    }

    public static class FloorSqrtInput {
        @NotNull
        @Schema(description = "Input number to find floor square root for", example = "28")
        private Long n;
        public Long getN() { return n; }
        public void setN(Long n) { this.n = n; }
    }

    public static class NthRootInput {
        @NotNull
        @Schema(description = "The root to find (N)", example = "3")
        private Integer n;
        @NotNull
        @Schema(description = "The number to find the root of (M)", example = "27")
        private Integer m;
        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
        public Integer getM() { return m; }
        public void setM(Integer m) { this.m = m; }
    }

    public static class SearchInRotatedArrayInput {
        @NotNull
        @Schema(description = "Input rotated sorted array", example = "[7,8,9,1,2,3,4,5,6]")
        private int[] nums;
        @NotNull
        @Schema(description = "Target value to search for", example = "1")
        private int target;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class SearchInRotatedArrayIIInput {
        @NotNull
        @Schema(description = "Input rotated sorted array (may contain duplicates)", example = "[7,8,1,2,3,3,3,4,5,6]")
        private int[] arr;
        @NotNull
        @Schema(description = "Target value to search for", example = "3")
        private int target;
        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class RowWithMax1sInput {
        @NotNull
        @Schema(description = "2D input array (matrix of 0s and 1s)", example = "[[1,1,1],[0,0,1],[0,0,0]]")
        private int[][] mat;
        public int[][] getMat() { return mat; }
        public void setMat(int[][] mat) { this.mat = mat; }
    }

    public static class RoseGardenInput {
        @NotNull
        @Schema(description = "Input array of bloom days", example = "[7,7,7,7,13,11,12,7]")
        private int[] nums;
        @NotNull
        @Schema(description = "Number of flowers per bouquet", example = "3")
        private int k;
        @NotNull
        @Schema(description = "Number of bouquets needed", example = "2")
        private int m;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
        public int getM() { return m; }
        public void setM(int m) { this.m = m; }
    }

    public static class MinimumRateToEatBananasInput {
        @NotNull
        @Schema(description = "Input array of banana piles", example = "[7,15,6,3]")
        private int[] nums;
        @NotNull
        @Schema(description = "Number of hours available", example = "8")
        private int h;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getH() { return h; }
        public void setH(int h) { this.h = h; }
    }

    public static class MinimiseMaxDistanceInput {
        @NotNull
        @Schema(description = "Input array of gas station positions", example = "[1,2,3,4,5]")
        private int[] arr;
        @NotNull
        @Schema(description = "Number of additional gas stations to add", example = "4")
        private int k;
        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class LargestSubarraySumMinimizedInput {
        @NotNull
        @Schema(description = "Input array", example = "[10,20,30,40]")
        private int[] a;
        @NotNull
        @Schema(description = "Number of partitions (subarrays)", example = "2")
        private int k;
        public int[] getA() { return a; }
        public void setA(int[] a) { this.a = a; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class KthElementInput {
        @NotNull
        @Schema(description = "First sorted array", example = "[2,3,6,7,9]")
        private int[] a;
        @NotNull
        @Schema(description = "Second sorted array", example = "[1,4,8,10]")
        private int[] b;
        @NotNull
        @Schema(description = "The k-th element to find", example = "5")
        private int k;
        public int[] getA() { return a; }
        public void setA(int[] a) { this.a = a; }
        public int[] getB() { return b; }
        public void setB(int[] b) { this.b = b; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class SearchRangeInput {
        @NotNull
        @Schema(description = "Input sorted array", example = "[5,7,7,8,8,10]")
        private int[] nums;
        @NotNull
        @Schema(description = "Target value to search for", example = "8")
        private int target;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }
} 