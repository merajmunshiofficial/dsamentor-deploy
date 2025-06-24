package com.example.dsa.binarysearch;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public class BinarySearchResponse {
    @Schema(description = "Result as a single integer", example = "3")
    private Integer result;
    private int[] resultArr;
    private Double median;
    @Schema(description = "Indices result, e.g. [row, col] for 2D peak element")
    private List<Integer> indices;

    public BinarySearchResponse() {}
    public BinarySearchResponse(Integer result) { this.result = result; }
    public Integer getResult() { return result; }
    public void setResult(Integer result) { this.result = result; }
    public BinarySearchResponse(int[] resultArr) { this.resultArr = resultArr; }
    public int[] getResultArr() { return resultArr; }
    public void setResultArr(int[] resultArr) { this.resultArr = resultArr; }
    public BinarySearchResponse(Double median) { this.median = median; }
    public Double getMedian() { return median; }
    public void setMedian(Double median) { this.median = median; }
    public BinarySearchResponse(List<Integer> indices) { this.indices = indices; }
    public List<Integer> getIndices() { return indices; }
    public void setIndices(List<Integer> indices) { this.indices = indices; }
} 