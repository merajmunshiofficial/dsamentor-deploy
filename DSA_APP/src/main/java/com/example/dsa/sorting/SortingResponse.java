package com.example.dsa.sorting;

public class SortingResponse {

    private int[] sortedArray;

    public SortingResponse(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }
} 