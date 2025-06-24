package com.example.dsa.heaps;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class HeapsRequest {
    public static class HeapConverterInput {
        @NotNull
        @Schema(description = "Input array", example = "[3, 1, 4, 1, 5]")
        private int[] array;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
    }
    public static class HeapSorterInput {
        @NotNull
        @Schema(description = "Input array", example = "[3, 1, 4, 1, 5]")
        private int[] array;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
    }
    public static class KthLargestInput {
        @NotNull
        @Schema(description = "Input array", example = "[3, 2, 1, 5, 6, 4]")
        private int[] array;
        @NotNull
        @Schema(description = "K value", example = "2")
        private int k;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }
    public static class KthLargestElementInput {
        @NotNull
        @Schema(description = "Input array", example = "[3, 2, 1, 5, 6, 4]")
        private int[] array;
        @NotNull
        @Schema(description = "K value", example = "2")
        private int k;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }
    public static class MaxHeapInput {
        @NotNull
        @Schema(description = "Input array", example = "[3, 1, 4, 1, 5]")
        private int[] array;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
    }
    public static class MinHeapInput {
        @NotNull
        @Schema(description = "Input array", example = "[3, 1, 4, 1, 5]")
        private int[] array;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
    }
    public static class MinHeapAdjusterInput {
        @NotNull
        @Schema(description = "Input array", example = "[3, 1, 4, 1, 5]")
        private int[] array;
        @NotNull
        @Schema(description = "Index to adjust", example = "2")
        private int index;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
        public int getIndex() { return index; }
        public void setIndex(int index) { this.index = index; }
    }
    public static class MinHeapBuilderInput {
        @NotNull
        @Schema(description = "Input array", example = "[3, 1, 4, 1, 5]")
        private int[] array;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
    }
    public static class MinHeapValidatorInput {
        @NotNull
        @Schema(description = "Input array", example = "[1, 3, 4, 5, 6]")
        private int[] array;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
    }
    public static class AdjustMinHeapInput {
        @NotNull
        @Schema(description = "Input array", example = "[1, 3, 5, 7, 9, 2, 4, 6, 8, 0]")
        private int[] array;
        @NotNull
        @Schema(description = "Index to adjust", example = "3")
        private int index;
        @NotNull
        @Schema(description = "New value", example = "0")
        private int val;
        public int[] getArray() { return array; }
        public void setArray(int[] array) { this.array = array; }
        public int getIndex() { return index; }
        public void setIndex(int index) { this.index = index; }
        public int getVal() { return val; }
        public void setVal(int val) { this.val = val; }
    }
}