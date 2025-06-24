package com.example.dsa.sorting;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sorting")
@Tag(name = "Sorting", description = "DSA Sorting Algorithms")
public class SortingController {

    private final SortingService service;

    @Autowired
    public SortingController(SortingService service) {
        this.service = service;
    }

    @Operation(summary = "Sort an array using Bubble Sort")
    @PostMapping("/bubble-sort")
    public ResponseEntity<SortingResponse> bubbleSort(@Validated @RequestBody SortingRequest.SortInput request) {
        int[] sortedArray = service.bubbleSort(request.getNums());
        return ResponseEntity.ok(new SortingResponse(sortedArray));
    }

    @Operation(summary = "Sort an array using Insertion Sort")
    @PostMapping("/insertion-sort")
    public ResponseEntity<SortingResponse> insertionSort(@Validated @RequestBody SortingRequest.SortInput request) {
        int[] sortedArray = service.insertionSort(request.getNums());
        return ResponseEntity.ok(new SortingResponse(sortedArray));
    }

    @Operation(summary = "Sort an array using Merge Sort")
    @PostMapping("/merge-sort")
    public ResponseEntity<SortingResponse> mergeSort(@Validated @RequestBody SortingRequest.SortInput request) {
        int[] sortedArray = service.mergeSort(request.getNums());
        return ResponseEntity.ok(new SortingResponse(sortedArray));
    }

    @Operation(summary = "Sort an array using Quick Sort")
    @PostMapping("/quick-sort")
    public ResponseEntity<SortingResponse> quickSort(@Validated @RequestBody SortingRequest.SortInput request) {
        int[] sortedArray = service.quickSort(request.getNums());
        return ResponseEntity.ok(new SortingResponse(sortedArray));
    }
} 