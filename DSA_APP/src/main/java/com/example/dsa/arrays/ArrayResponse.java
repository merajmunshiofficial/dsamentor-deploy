package com.example.dsa.arrays;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArrayResponse {
    @Schema(description = "Result as a single integer", example = "3")
    private Integer result;

    @Schema(description = "Result as an array of integers", example = "[2,3]")
    private int[] resultArr;

    @Schema(description = "Result as a list of quadruplets (for fourSum)")
    private List<List<Integer>> quadruplets;

    @Schema(description = "Error message, if any")
    private String error;

    public ArrayResponse(Integer result) { this.result = result; }
    public ArrayResponse(int[] resultArr) { this.resultArr = resultArr; }
    public ArrayResponse(List<List<Integer>> quadruplets) { this.quadruplets = quadruplets; }
    public ArrayResponse(String error) { this.error = error; }
    public ArrayResponse(int[][] matrix) {
        if (matrix != null && matrix.length > 0) {
            int n = matrix.length, m = matrix[0].length;
            int[] flat = new int[n * m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    flat[i * m + j] = matrix[i][j];
                }
            }
            this.resultArr = flat;
        }
    }

    public Integer getResult() { return result; }
    public void setResult(Integer result) { this.result = result; }
    public int[] getResultArr() { return resultArr; }
    public void setResultArr(int[] resultArr) { this.resultArr = resultArr; }
    public List<List<Integer>> getQuadruplets() { return quadruplets; }
    public void setQuadruplets(List<List<Integer>> quadruplets) { this.quadruplets = quadruplets; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    // Static inner classes for more complex outputs if needed
} 