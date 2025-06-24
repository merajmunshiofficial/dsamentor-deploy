package com.example.dsa.dynamicprogramming;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DynamicProgrammingRequest {

    public static class ClimbStairsInput {
        @NotNull(message = "Number of stairs cannot be null")
        @Min(value = 1, message = "Number of stairs must be at least 1")
        private Integer n;

        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
    }

    public static class Knapsack01Input {
        @NotNull(message = "Weights array cannot be null")
        @NotEmpty(message = "Weights array cannot be empty")
        private int[] wt;
        
        @NotNull(message = "Values array cannot be null")
        @NotEmpty(message = "Values array cannot be empty")
        private int[] val;
        
        @NotNull(message = "Number of items cannot be null")
        @Min(value = 1, message = "Number of items must be at least 1")
        private Integer n;
        
        @NotNull(message = "Knapsack capacity cannot be null")
        @Min(value = 0, message = "Knapsack capacity must be non-negative")
        private Integer W;

        public int[] getWt() { return wt; }
        @JsonProperty("wt")
        public void setWt(int[] wt) { this.wt = wt; }
        @JsonProperty("WT")
        public void setWtUpper(int[] wt) { this.wt = wt; }
        
        public int[] getVal() { return val; }
        @JsonProperty("val")
        public void setVal(int[] val) { this.val = val; }
        @JsonProperty("VAL")
        public void setValUpper(int[] val) { this.val = val; }
        
        public Integer getN() { return n; }
        @JsonProperty("n")
        public void setN(Integer n) { this.n = n; }
        @JsonProperty("N")
        public void setNUpper(Integer n) { this.n = n; }
        
        public Integer getW() { return W; }
        @JsonProperty("W")
        public void setW(Integer W) { this.W = W; }
        @JsonProperty("w")
        public void setwLower(Integer W) { this.W = W; }
    }

    public static class FrogJumpInput {
        @NotNull(message = "Heights array cannot be null")
        @NotEmpty(message = "Heights array cannot be empty")
        private int[] heights;

        public int[] getHeights() { return heights; }
        public void setHeights(int[] heights) { this.heights = heights; }
    }

    public static class FrogJumpKInput {
        @NotNull(message = "Heights array cannot be null")
        @NotEmpty(message = "Heights array cannot be empty")
        private int[] heights;
        
        @NotNull(message = "Number of steps cannot be null")
        @Min(value = 1, message = "Number of steps must be at least 1")
        private Integer k;

        public int[] getHeights() { return heights; }
        public void setHeights(int[] heights) { this.heights = heights; }
        
        public Integer getK() { return k; }
        public void setK(Integer k) { this.k = k; }
    }

    public static class HouseRobberInput {
        @NotNull(message = "Nums array cannot be null")
        @NotEmpty(message = "Nums array cannot be empty")
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class LCSInput {
        @NotNull(message = "Text1 cannot be null")
        @Size(min = 1, message = "Text1 cannot be empty")
        private String text1;
        
        @NotNull(message = "Text2 cannot be null")
        @Size(min = 1, message = "Text2 cannot be empty")
        private String text2;

        public String getText1() { return text1; }
        public void setText1(String text1) { this.text1 = text1; }
        
        public String getText2() { return text2; }
        public void setText2(String text2) { this.text2 = text2; }
    }

    public static class EditDistanceInput {
        @NotNull(message = "Word1 cannot be null")
        private String word1;
        
        @NotNull(message = "Word2 cannot be null")
        private String word2;

        public String getWord1() { return word1; }
        public void setWord1(String word1) { this.word1 = word1; }
        
        public String getWord2() { return word2; }
        public void setWord2(String word2) { this.word2 = word2; }
    }

    public static class DistinctSubsequencesInput {
        @NotNull(message = "String s cannot be null")
        private String s;
        
        @NotNull(message = "String t cannot be null")
        private String t;

        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
        
        public String getT() { return t; }
        public void setT(String t) { this.t = t; }
    }

    public static class MinimumCoinsInput {
        @NotNull(message = "Coins array cannot be null")
        @NotEmpty(message = "Coins array cannot be empty")
        private int[] coins;
        
        @NotNull(message = "Amount cannot be null")
        @Min(value = 0, message = "Amount must be non-negative")
        private Integer amount;

        public int[] getCoins() { return coins; }
        public void setCoins(int[] coins) { this.coins = coins; }
        
        public Integer getAmount() { return amount; }
        public void setAmount(Integer amount) { this.amount = amount; }
    }

    public static class RodCuttingInput {
        @NotNull(message = "Price array cannot be null")
        @NotEmpty(message = "Price array cannot be empty")
        private int[] price;
        
        @NotNull(message = "Length cannot be null")
        @Min(value = 1, message = "Length must be at least 1")
        private Integer n;

        public int[] getPrice() { return price; }
        public void setPrice(int[] price) { this.price = price; }
        
        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
    }

    public static class TargetSumInput {
        @NotNull(message = "Number of elements cannot be null")
        @Min(value = 1, message = "Number of elements must be at least 1")
        private Integer n;
        
        @NotNull(message = "Target cannot be null")
        private Integer target;
        
        @NotNull(message = "Nums array cannot be null")
        @NotEmpty(message = "Nums array cannot be empty")
        private int[] nums;

        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
        
        public Integer getTarget() { return target; }
        public void setTarget(Integer target) { this.target = target; }
        
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class PartitionEqualSubsetSumInput {
        @NotNull(message = "Nums array cannot be null")
        @NotEmpty(message = "Nums array cannot be empty")
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class PerfectSumInput {
        @NotNull(message = "Number of elements cannot be null")
        @Min(value = 1, message = "Number of elements must be at least 1")
        private Integer n;
        
        @NotNull(message = "Sum cannot be null")
        @Min(value = 0, message = "Sum must be non-negative")
        private Integer sum;
        
        @NotNull(message = "Array cannot be null")
        @NotEmpty(message = "Array cannot be empty")
        private int[] arr;

        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
        
        public Integer getSum() { return sum; }
        public void setSum(Integer sum) { this.sum = sum; }
        
        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
    }

    public static class CherryPickupInput {
        @NotNull(message = "Matrix cannot be null")
        @NotEmpty(message = "Matrix cannot be empty")
        private int[][] matrix;

        public int[][] getMatrix() { return matrix; }
        public void setMatrix(int[][] matrix) { this.matrix = matrix; }
    }

    public static class NinjaTrainingInput {
        @NotNull(message = "Points cannot be null")
        @NotEmpty(message = "Points cannot be empty")
        private int[][] points;

        public int[][] getPoints() { return points; }
        public void setPoints(int[][] points) { this.points = points; }
    }

    public static class LongestPalindromicSubsequenceInput {
        @NotNull(message = "String cannot be null")
        @Size(min = 1, message = "String cannot be empty")
        private String s;

        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
    }

    public static class UniquePathsInput {
        @NotNull(message = "M cannot be null")
        @Min(value = 1, message = "M must be at least 1")
        private Integer m;
        
        @NotNull(message = "N cannot be null")
        @Min(value = 1, message = "N must be at least 1")
        private Integer n;

        public Integer getM() { return m; }
        public void setM(Integer m) { this.m = m; }
        
        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
    }

    public static class UniquePathsWithObstaclesInput {
        @NotNull(message = "Obstacle grid cannot be null")
        @NotEmpty(message = "Obstacle grid cannot be empty")
        private int[][] obstacleGrid;

        public int[][] getObstacleGrid() { return obstacleGrid; }
        public void setObstacleGrid(int[][] obstacleGrid) { this.obstacleGrid = obstacleGrid; }
    }

    public static class MinFallingPathSumInput {
        @NotNull(message = "Matrix cannot be null")
        @NotEmpty(message = "Matrix cannot be empty")
        private int[][] matrix;

        public int[][] getMatrix() { return matrix; }
        public void setMatrix(int[][] matrix) { this.matrix = matrix; }
    }

    public static class MinTriangleSumInput {
        @NotNull(message = "Triangle cannot be null")
        @NotEmpty(message = "Triangle cannot be empty")
        private List<List<Integer>> triangle;

        public List<List<Integer>> getTriangle() { return triangle; }
        public void setTriangle(List<List<Integer>> triangle) { this.triangle = triangle; }
    }

    public static class MaxCoinsInput {
        @NotNull(message = "Nums array cannot be null")
        @NotEmpty(message = "Nums array cannot be empty")
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class MatrixChainMultiplicationInput {
        @NotNull(message = "Array cannot be null")
        @NotEmpty(message = "Array cannot be empty")
        private int[] arr;

        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
    }

    public static class MinCostInput {
        @NotNull(message = "Length cannot be null")
        @Min(value = 1, message = "Length must be at least 1")
        private Integer n;
        
        @NotNull(message = "Cuts array cannot be null")
        private int[] cuts;

        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
        
        public int[] getCuts() { return cuts; }
        public void setCuts(int[] cuts) { this.cuts = cuts; }
    }

    public static class MinCutInput {
        @NotNull(message = "String cannot be null")
        @Size(min = 1, message = "String cannot be empty")
        private String s;

        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
    }

    public static class MinDifferenceInput {
        @NotNull(message = "Nums array cannot be null")
        @NotEmpty(message = "Nums array cannot be empty")
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class MinInsertionsInput {
        @NotNull(message = "String cannot be null")
        @Size(min = 1, message = "String cannot be empty")
        private String s;

        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
    }

    public static class MinOperationsInput {
        @NotNull(message = "Nums array cannot be null")
        @NotEmpty(message = "Nums array cannot be empty")
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class NonAdjacentInput {
        @NotNull(message = "Nums array cannot be null")
        @NotEmpty(message = "Nums array cannot be empty")
        private int[] nums;

        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class WildcardInput {
        @NotNull(message = "Pattern cannot be null")
        private String pattern;
        
        @NotNull(message = "String cannot be null")
        private String str;

        public String getPattern() { return pattern; }
        public void setPattern(String pattern) { this.pattern = pattern; }
        
        public String getStr() { return str; }
        public void setStr(String str) { this.str = str; }
    }

    public static class CountPartitionsInput {
        @NotNull(message = "Number of elements cannot be null")
        @Min(value = 1, message = "Number of elements must be at least 1")
        private Integer n;
        
        @NotNull(message = "Difference cannot be null")
        private Integer d;
        
        @NotNull(message = "Array cannot be null")
        @NotEmpty(message = "Array cannot be empty")
        private int[] arr;

        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
        
        public Integer getD() { return d; }
        public void setD(Integer d) { this.d = d; }
        
        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
    }

    public static class EqualPartitionInput {
        @NotNull(message = "Number of elements cannot be null")
        @Min(value = 1, message = "Number of elements must be at least 1")
        private Integer n;
        
        @NotNull(message = "Array cannot be null")
        @NotEmpty(message = "Array cannot be empty")
        private int[] arr;

        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
        
        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
    }

    public static class IsSubsetSumInput {
        @NotNull(message = "Number of elements cannot be null")
        @Min(value = 1, message = "Number of elements must be at least 1")
        private Integer n;
        
        @NotNull(message = "Array cannot be null")
        @NotEmpty(message = "Array cannot be empty")
        private int[] arr;
        
        @NotNull(message = "Sum cannot be null")
        @Min(value = 0, message = "Sum must be non-negative")
        private Integer sum;

        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
        
        public int[] getArr() { return arr; }
        public void setArr(int[] arr) { this.arr = arr; }
        
        public Integer getSum() { return sum; }
        public void setSum(Integer sum) { this.sum = sum; }
    }

    public static class CountInput {
        @NotNull(message = "Number of stairs cannot be null")
        @Min(value = 1, message = "Number of stairs must be at least 1")
        private Integer n;

        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
    }
}