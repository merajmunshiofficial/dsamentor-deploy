package com.example.dsa.recursion;

import java.util.List;

public class RecursionResponse {
    private boolean hasSubsequenceSum;
    private List<List<Integer>> combinations;
    private int count;
    private boolean wordExists;
    private List<String> paths;
    private List<String> parentheses;
    private boolean canColor;
    private List<List<String>> partitions;
    private List<String> letterCombinations;
    private double result;
    private List<List<Integer>> powerSet;
    private List<List<String>> nQueensSolutions;
    private char[][] solvedBoard;
    private List<List<Integer>> subsetsWithDup;
    private List<Integer> subsetSums;
    public RecursionResponse() {}
    public RecursionResponse(boolean hasSubsequenceSum) { this.hasSubsequenceSum = hasSubsequenceSum; }
    public boolean isHasSubsequenceSum() { return hasSubsequenceSum; }
    public void setHasSubsequenceSum(boolean hasSubsequenceSum) { this.hasSubsequenceSum = hasSubsequenceSum; }
    public List<List<Integer>> getCombinations() { return combinations; }
    public void setCombinations(List<List<Integer>> combinations) { this.combinations = combinations; }
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
    public boolean isWordExists() { return wordExists; }
    public void setWordExists(boolean wordExists) { this.wordExists = wordExists; }
    public List<String> getPaths() { return paths; }
    public void setPaths(List<String> paths) { this.paths = paths; }
    public List<String> getParentheses() { return parentheses; }
    public void setParentheses(List<String> parentheses) { this.parentheses = parentheses; }
    public boolean isCanColor() { return canColor; }
    public void setCanColor(boolean canColor) { this.canColor = canColor; }
    public List<List<String>> getPartitions() { return partitions; }
    public void setPartitions(List<List<String>> partitions) { this.partitions = partitions; }
    public List<String> getLetterCombinations() { return letterCombinations; }
    public void setLetterCombinations(List<String> letterCombinations) { this.letterCombinations = letterCombinations; }
    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
    public List<List<Integer>> getPowerSet() { return powerSet; }
    public void setPowerSet(List<List<Integer>> powerSet) { this.powerSet = powerSet; }
    public List<List<String>> getNQueensSolutions() { return nQueensSolutions; }
    public void setNQueensSolutions(List<List<String>> nQueensSolutions) { this.nQueensSolutions = nQueensSolutions; }
    public char[][] getSolvedBoard() { return solvedBoard; }
    public void setSolvedBoard(char[][] solvedBoard) { this.solvedBoard = solvedBoard; }
    public List<List<Integer>> getSubsetsWithDup() { return subsetsWithDup; }
    public void setSubsetsWithDup(List<List<Integer>> subsetsWithDup) { this.subsetsWithDup = subsetsWithDup; }
    public List<Integer> getSubsetSums() { return subsetSums; }
    public void setSubsetSums(List<Integer> subsetSums) { this.subsetSums = subsetSums; }
} 