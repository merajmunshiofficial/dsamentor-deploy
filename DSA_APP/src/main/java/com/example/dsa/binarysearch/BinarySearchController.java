package com.example.dsa.binarysearch;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/binary-search")
@Tag(name = "Binary Search", description = "DSA Binary Search Problems")
public class BinarySearchController {
    private final BinarySearchService service;

    @Autowired
    public BinarySearchController(BinarySearchService service) {
        this.service = service;
    }

    @Operation(summary = "Find the maximum possible minimum distance for placing cows in stalls (Aggressive Cows problem)")
    @PostMapping("/aggressive-cows")
    public ResponseEntity<BinarySearchResponse> aggressiveCows(@Validated @RequestBody BinarySearchRequest.AggressiveCowsInput request) {
        int result = service.aggressiveCows(request.getNums(), request.getK());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find floor and ceil of a number in a sorted array")
    @PostMapping("/find-floor-and-ceil")
    public ResponseEntity<BinarySearchResponse> findFloorAndCeil(@Validated @RequestBody BinarySearchRequest.FindFloorAndCeilInput request) {
        int[] result = service.findFloorAndCeil(request.getNums(), request.getX());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the number of times a sorted array has been rotated (index of the minimum element)")
    @PostMapping("/find-k-rotation")
    public ResponseEntity<BinarySearchResponse> findKRotation(@Validated @RequestBody BinarySearchRequest.IntArrayInput request) {
        int result = service.findKRotation(request.getNums());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the median of two sorted arrays")
    @PostMapping("/find-median")
    public ResponseEntity<BinarySearchResponse> findMedian(@Validated @RequestBody BinarySearchRequest.FindMedianInput request) {
        double median = service.findMedian(request.getNums1(), request.getNums2());
        return ResponseEntity.ok(new BinarySearchResponse(median));
    }

    @Operation(summary = "Find the minimum element in a rotated sorted array")
    @PostMapping("/find-min")
    public ResponseEntity<BinarySearchResponse> findMin(@Validated @RequestBody BinarySearchRequest.IntArrayInput request) {
        int result = service.findMin(request.getNums());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the minimum possible maximum pages for the Book Allocation Problem")
    @PostMapping("/find-pages")
    public ResponseEntity<BinarySearchResponse> findPages(@Validated @RequestBody BinarySearchRequest.FindPagesInput request) {
        int result = service.findPages(request.getNums(), request.getStudents());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the index of a peak element in the array (element greater than its neighbors)")
    @PostMapping("/find-peak-element")
    public ResponseEntity<BinarySearchResponse> findPeakElement(@Validated @RequestBody BinarySearchRequest.IntArrayInput request) {
        int result = service.findPeakElement(request.getNums());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the peak element in a 2D array (returns [row, col] of a peak)")
    @PostMapping("/find-peak-element-2d")
    public ResponseEntity<BinarySearchResponse> findPeakElement2D(@Validated @RequestBody BinarySearchRequest.IntMatrixInput request) {
        int[] indices = service.findPeakElement2D(request.getArr());
        return ResponseEntity.ok(new BinarySearchResponse(indices));
    }

    @Operation(summary = "Classic binary search: find the index of a target in a sorted array")
    @PostMapping("/search")
    public ResponseEntity<BinarySearchResponse> search(@Validated @RequestBody BinarySearchRequest.SearchInput request) {
        int result = service.search(request.getNums(), request.getTarget());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the index to insert a target in a sorted array (search insert position)")
    @PostMapping("/search-insert")
    public ResponseEntity<BinarySearchResponse> searchInsert(@Validated @RequestBody BinarySearchRequest.SearchInsertInput request) {
        int result = service.searchInsert(request.getNums(), request.getTarget());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the lower bound index for a value in a sorted array")
    @PostMapping("/lower-bound")
    public ResponseEntity<BinarySearchResponse> lowerBound(@Validated @RequestBody BinarySearchRequest.LowerBoundInput request) {
        int result = service.lowerBound(request.getNums(), request.getX());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the upper bound index for a value in a sorted array")
    @PostMapping("/upper-bound")
    public ResponseEntity<BinarySearchResponse> upperBound(@Validated @RequestBody BinarySearchRequest.UpperBoundInput request) {
        int result = service.upperBound(request.getNums(), request.getX());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Search for a target value in a 2D matrix (row-wise and column-wise sorted)")
    @PostMapping("/search-matrix")
    public ResponseEntity<BinarySearchResponse> searchMatrix(@Validated @RequestBody BinarySearchRequest.SearchMatrixInput request) {
        boolean found = service.searchMatrix(request.getMat(), request.getTarget());
        return ResponseEntity.ok(new BinarySearchResponse(found ? 1 : 0));
    }

    @Operation(summary = "Search for a target value in a 2D matrix II (row-wise and column-wise sorted, starts from top-right)")
    @PostMapping("/search-matrix-2d")
    public ResponseEntity<BinarySearchResponse> searchMatrix2D(@Validated @RequestBody BinarySearchRequest.SearchMatrix2DInput request) {
        boolean found = service.searchMatrix2D(request.getMatrix(), request.getTarget());
        return ResponseEntity.ok(new BinarySearchResponse(found ? 1 : 0));
    }

    @Operation(summary = "Find the single non-duplicate element in a sorted array where every other element appears twice")
    @PostMapping("/single-non-duplicate")
    public ResponseEntity<BinarySearchResponse> singleNonDuplicate(@Validated @RequestBody BinarySearchRequest.IntArrayInput request) {
        int result = service.singleNonDuplicate(request.getNums());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the smallest divisor such that the sum of divisions is less than or equal to the limit")
    @PostMapping("/smallest-divisor")
    public ResponseEntity<BinarySearchResponse> smallestDivisor(@Validated @RequestBody BinarySearchRequest.SmallestDivisorInput request) {
        int result = service.smallestDivisor(request.getNums(), request.getLimit());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the floor of the square root of a given number")
    @PostMapping("/floor-sqrt")
    public ResponseEntity<BinarySearchResponse> floorSqrt(@Validated @RequestBody BinarySearchRequest.FloorSqrtInput request) {
        long result = service.floorSqrt(request.getN());
        return ResponseEntity.ok(new BinarySearchResponse((int)result));
    }

    @Operation(summary = "Find the Nth root of a number M using binary search")
    @PostMapping("/nth-root")
    public ResponseEntity<BinarySearchResponse> nthRoot(@Validated @RequestBody BinarySearchRequest.NthRootInput request) {
        int result = service.nthRoot(request.getN(), request.getM());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Search for a target value in a rotated sorted array")
    @PostMapping("/search-in-rotated-array")
    public ResponseEntity<BinarySearchResponse> searchInRotatedArray(@Validated @RequestBody BinarySearchRequest.SearchInRotatedArrayInput request) {
        int result = service.searchInRotatedArray(request.getNums(), request.getTarget());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Search for a target value in a rotated sorted array (may contain duplicates)")
    @PostMapping("/search-in-rotated-array-ii")
    public ResponseEntity<BinarySearchResponse> searchInRotatedArrayII(@Validated @RequestBody BinarySearchRequest.SearchInRotatedArrayIIInput request) {
        boolean found = service.searchInRotatedArrayII(request.getArr(), request.getTarget());
        return ResponseEntity.ok(new BinarySearchResponse(found ? 1 : 0));
    }

    @Operation(summary = "Find the row with the maximum number of 1s in a binary matrix")
    @PostMapping("/row-with-max-1s")
    public ResponseEntity<BinarySearchResponse> rowWithMax1s(@Validated @RequestBody BinarySearchRequest.RowWithMax1sInput request) {
        int result = service.rowWithMax1s(request.getMat());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the earliest day to make m bouquets of k flowers each (Rose Garden problem)")
    @PostMapping("/rose-garden")
    public ResponseEntity<BinarySearchResponse> roseGarden(@Validated @RequestBody BinarySearchRequest.RoseGardenInput request) {
        int result = service.roseGarden(request.getNums(), request.getK(), request.getM());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the minimum rate to eat all bananas in h hours (Koko Eating Bananas problem)")
    @PostMapping("/minimum-rate-to-eat-bananas")
    public ResponseEntity<BinarySearchResponse> minimumRateToEatBananas(@Validated @RequestBody BinarySearchRequest.MinimumRateToEatBananasInput request) {
        int result = service.minimumRateToEatBananas(request.getNums(), request.getH());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Minimize the maximum distance between gas stations by adding k more stations")
    @PostMapping("/minimise-max-distance")
    public ResponseEntity<BinarySearchResponse> minimiseMaxDistance(@Validated @RequestBody BinarySearchRequest.MinimiseMaxDistanceInput request) {
        double result = service.minimiseMaxDistance(request.getArr(), request.getK());
        // Round to 6 decimal places for output
        double rounded = Math.round(result * 1e6) / 1e6;
        return ResponseEntity.ok(new BinarySearchResponse(rounded));
    }

    @Operation(summary = "Split the array into k subarrays to minimize the largest subarray sum")
    @PostMapping("/largest-subarray-sum-minimized")
    public ResponseEntity<BinarySearchResponse> largestSubarraySumMinimized(@Validated @RequestBody BinarySearchRequest.LargestSubarraySumMinimizedInput request) {
        int result = service.largestSubarraySumMinimized(request.getA(), request.getK());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the k-th element in the union of two sorted arrays")
    @PostMapping("/kth-element")
    public ResponseEntity<BinarySearchResponse> kthElement(@Validated @RequestBody BinarySearchRequest.KthElementInput request) {
        int result = service.kthElement(request.getA(), request.getB(), request.getK());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }

    @Operation(summary = "Find the first and last occurrence of a target in a sorted array")
    @PostMapping("/search-range")
    public ResponseEntity<BinarySearchResponse> searchRange(@Validated @RequestBody BinarySearchRequest.SearchRangeInput request) {
        int[] result = service.searchRange(request.getNums(), request.getTarget());
        return ResponseEntity.ok(new BinarySearchResponse(result));
    }
} 