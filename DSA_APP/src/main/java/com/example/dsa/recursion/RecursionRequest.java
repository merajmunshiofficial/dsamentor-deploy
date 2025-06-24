package com.example.dsa.recursion;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class RecursionRequest {
    public static class CheckSubsequenceSumInput {
        @NotNull
        @Schema(description = "Array of numbers", example = "[1, 2, 3]")
        private int[] nums;
        @NotNull
        @Schema(description = "Target sum", example = "3")
        private int target;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class CombinationSumInput {
        @NotNull
        @Schema(description = "Array of candidate numbers", example = "[2, 3, 6, 7]")
        private int[] candidates;
        @NotNull
        @Schema(description = "Target sum", example = "7")
        private int target;
        public int[] getCandidates() { return candidates; }
        public void setCandidates(int[] candidates) { this.candidates = candidates; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class CombinationSum2Input {
        @NotNull
        @Schema(description = "Array of candidate numbers with duplicates", example = "[10, 1, 2, 7, 6, 1, 5]")
        private int[] candidates;
        @NotNull
        @Schema(description = "Target sum", example = "8")
        private int target;
        public int[] getCandidates() { return candidates; }
        public void setCandidates(int[] candidates) { this.candidates = candidates; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class CombinationSum3Input {
        @NotNull
        @Schema(description = "Number of elements in combination", example = "3")
        private int k;
        @NotNull
        @Schema(description = "Target sum", example = "9")
        private int n;
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
    }

    public static class CountSubsequenceWithTargetSumInput {
        @NotNull
        @Schema(description = "Array of numbers", example = "[1, 2, 1]")
        private int[] nums;
        @NotNull
        @Schema(description = "Target sum", example = "2")
        private int target;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }

    public static class ExistInput {
        @NotNull
        @Schema(description = "2D board of characters", example = "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]")
        private char[][] board;
        @NotNull
        @Schema(description = "Word to search for", example = "ABCCED")
        private String word;
        public char[][] getBoard() { return board; }
        public void setBoard(char[][] board) { this.board = board; }
        public String getWord() { return word; }
        public void setWord(String word) { this.word = word; }
    }

    public static class FindPathInput {
        @NotNull
        @Schema(description = "Grid with obstacles", example = "[[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]")
        private int[][] grid;
        public int[][] getGrid() { return grid; }
        public void setGrid(int[][] grid) { this.grid = grid; }
    }

    public static class GenerateParenthesisInput {
        @NotNull
        @Schema(description = "Number of parenthesis pairs", example = "3")
        private int n;
        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
    }

    public static class GraphColoringInput {
        @NotNull
        @Schema(description = "Adjacency list of the graph", example = "[[1, 2], [0, 2], [0, 1]]")
        private int[][] edges;
        @NotNull
        @Schema(description = "Number of colors", example = "3")
        private int m;
        @NotNull
        @Schema(description = "Number of nodes", example = "3")
        private int n;
        public int[][] getEdges() { return edges; }
        public void setEdges(int[][] edges) { this.edges = edges; }
        public int getM() { return m; }
        public void setM(int m) { this.m = m; }
        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
    }

    public static class IsPalindromeInput {
        @NotNull
        @Schema(description = "String to partition", example = "aab")
        private String s;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
    }

    public static class LetterCombinationsInput {
        @NotNull
        @Schema(description = "Digit string", example = "23")
        private String digits;
        public String getDigits() { return digits; }
        public void setDigits(String digits) { this.digits = digits; }
    }

    public static class MyPowInput {
        @NotNull
        @Schema(description = "Base", example = "2.0")
        private double x;
        @NotNull
        @Schema(description = "Exponent", example = "10")
        private int n;
        public double getX() { return x; }
        public void setX(double x) { this.x = x; }
        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
    }

    public static class PowerSetInput {
        @NotNull
        @Schema(description = "Array of numbers", example = "[1, 2, 3]")
        private int[] nums;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }

    public static class SolveNQueensInput {
        @NotNull
        @Schema(description = "Size of the board", example = "4")
        private int n;
        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
    }

    public static class SolveSudokuInput {
        @NotNull
        @Schema(description = "Sudoku board", example = "[['5','3','.','.','7','.','.','.','.'],['6','.','.','1','9','5','.','.','.'],['.','9','8','.','.','.','.','6','.'],['8','.','.','.','6','.','.','.','3'],['4','.','.','8','.','3','.','.','1'],['7','.','.','.','2','.','.','.','6'],['.','6','.','.','.','.','2','8','.'],['.','.','.','4','1','9','.','.','5'],['.','.','.','.','8','.','.','7','9']]")
        private char[][] board;
        public char[][] getBoard() { return board; }
        public void setBoard(char[][] board) { this.board = board; }
    }

    public static class SubsetsWithDupInput {
        @NotNull
        @Schema(description = "Array with duplicates", example = "[1, 2, 2]")
        private int[] nums;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }
    public static class SubsetSumsInput {
        @NotNull
        @Schema(description = "Array of numbers", example = "[1, 2, 3]")
        private int[] nums;
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
    }
} 