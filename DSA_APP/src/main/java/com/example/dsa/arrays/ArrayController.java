package com.example.dsa.arrays;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/arrays")
@Tag(name = "Arrays", description = "DSA Array Problems")
public class ArrayController {
    private final ArrayService service;

    @Autowired
    public ArrayController(ArrayService service) {
        this.service = service;
    }

    @Operation(summary = "Find maximum consecutive 1s in a binary array")
    @PostMapping("/find-max-consecutive-ones")
    public ResponseEntity<ArrayResponse> findMaxConsecutiveOnes(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.findMaxConsecutiveOnes(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the single number in an array where every other element appears twice")
    @PostMapping("/single-number")
    public ResponseEntity<ArrayResponse> singleNumber(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.singleNumber(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the largest element in an array")
    @PostMapping("/largest-element")
    public ResponseEntity<ArrayResponse> largestElement(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.largestElement(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the second largest element in an array")
    @PostMapping("/second-largest-element")
    public ResponseEntity<ArrayResponse> secondLargestElement(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.secondLargestElement(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find all unique quadruplets that sum up to the target")
    @PostMapping("/four-sum")
    public ResponseEntity<ArrayResponse> fourSum(@Validated @RequestBody ArrayRequest.IntArrayAndTargetInput request) {
        List<List<Integer>> result = service.fourSum(request.getNums(), request.getTarget());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the missing and repeating numbers in an array of size n containing numbers from 1 to n")
    @PostMapping("/find-missing-repeating-numbers")
    public ResponseEntity<ArrayResponse> findMissingRepeatingNumbers(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int[] result = service.findMissingRepeatingNumbers(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Move all zeroes in the array to the end while maintaining the order of non-zero elements")
    @PostMapping("/move-zeroes")
    public ResponseEntity<ArrayResponse> moveZeroes(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int[] result = service.moveZeroes(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Remove duplicates from a sorted array and return the number of unique elements")
    @PostMapping("/remove-duplicates")
    public ResponseEntity<ArrayResponse> removeDuplicates(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.removeDuplicates(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Rotate the array to the left by k positions")
    @PostMapping("/rotate-array")
    public ResponseEntity<ArrayResponse> rotateArray(@Validated @RequestBody ArrayRequest.RotateArrayInput request) {
        int[] result = service.rotateArray(request.getNums(), request.getK());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the index of the target in the array using linear search")
    @PostMapping("/linear-search")
    public ResponseEntity<ArrayResponse> linearSearch(@Validated @RequestBody ArrayRequest.IntArrayAndTargetInput request) {
        int result = service.linearSearch(request.getNums(), request.getTarget());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find all elements that appear more than n/3 times in the array")
    @PostMapping("/majority-element-two")
    public ResponseEntity<ArrayResponse> majorityElementTwo(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int[] result = service.majorityElementTwo(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Rotate the array to the left by one position")
    @PostMapping("/rotate-array-by-one")
    public ResponseEntity<ArrayResponse> rotateArrayByOne(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int[] result = service.rotateArrayByOne(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Sort an array containing only 0s, 1s, and 2s (Dutch National Flag problem)")
    @PostMapping("/sort-zero-one-two")
    public ResponseEntity<ArrayResponse> sortZeroOneTwo(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int[] result = service.sortZeroOneTwo(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the maximum sum of a contiguous subarray (Kadane's Algorithm)")
    @PostMapping("/max-subarray")
    public ResponseEntity<ArrayResponse> maxSubArray(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.maxSubArray(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find all leaders in the array (elements greater than all elements to their right)")
    @PostMapping("/leaders")
    public ResponseEntity<ArrayResponse> leaders(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int[] result = service.leaders(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the intersection of two arrays (unique elements present in both)")
    @PostMapping("/intersection-array")
    public ResponseEntity<ArrayResponse> intersectionArray(@Validated @RequestBody ArrayRequest.IntersectionArrayInput request) {
        int[] result = service.intersectionArray(request.getNums1(), request.getNums2());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the union of two arrays (all unique elements from both arrays)")
    @PostMapping("/union-array")
    public ResponseEntity<ArrayResponse> unionArray(@Validated @RequestBody ArrayRequest.IntersectionArrayInput request) {
        int[] result = service.unionArray(request.getNums1(), request.getNums2());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Generate Pascal's Triangle up to n rows")
    @PostMapping("/generate-pascal-triangle")
    public ResponseEntity<ArrayResponse> generatePascalTriangle(@Validated @RequestBody ArrayRequest.PascalTriangleInput request) {
        List<List<Integer>> result = service.generatePascalTriangle(request.getN());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the number of inversions in the array (number of pairs (i, j) such that i < j and nums[i] > nums[j])")
    @PostMapping("/number-of-inversions")
    public ResponseEntity<ArrayResponse> numberOfInversions(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.numberOfInversions(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the maximum product of a contiguous subarray")
    @PostMapping("/max-product")
    public ResponseEntity<ArrayResponse> maxProduct(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.maxProduct(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Return all elements of a 2D matrix in spiral order")
    @PostMapping("/spiral-order")
    public ResponseEntity<ArrayResponse> spiralOrder(@Validated @RequestBody ArrayRequest.MatrixInput request) {
        int[] result = service.spiralOrder(request.getMatrix());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find indices of the two numbers such that they add up to a specific target")
    @PostMapping("/two-sum")
    public ResponseEntity<ArrayResponse> twoSum(@Validated @RequestBody ArrayRequest.IntArrayAndTargetInput request) {
        int[] result = service.twoSum(request.getNums(), request.getTarget());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Rearrange the array so that positive and negative numbers alternate, maintaining their order")
    @PostMapping("/rearrange-array")
    public ResponseEntity<ArrayResponse> rearrangeArray(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int[] result = service.rearrangeArray(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Count the number of reverse pairs in the array (i < j and nums[i] > 2 * nums[j])")
    @PostMapping("/reverse-pairs")
    public ResponseEntity<ArrayResponse> reversePairs(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.reversePairs(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Rotate a 2D matrix by 90 degrees clockwise")
    @PostMapping("/rotate-matrix")
    public ResponseEntity<ArrayResponse> rotateMatrix(@Validated @RequestBody ArrayRequest.MatrixInput request) {
        int[][] result = service.rotateMatrix(request.getMatrix());
        // Flatten the 2D array for response
        int n = result.length, m = result[0].length;
        int[] flat = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flat[i * m + j] = result[i][j];
            }
        }
        return ResponseEntity.ok(new ArrayResponse(flat));
    }

    @Operation(summary = "Merge two sorted arrays into one sorted array")
    @PostMapping("/merge-two-sorted-array")
    public ResponseEntity<ArrayResponse> mergeTwoSortedArray(@Validated @RequestBody ArrayRequest.IntersectionArrayInput request) {
        int[] result = service.mergeTwoSortedArray(request.getNums1(), request.getNums2());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the majority element in the array (appears more than n/2 times)")
    @PostMapping("/majority-element")
    public ResponseEntity<ArrayResponse> majorityElement(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.majorityElement(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find the missing number in the array (0 to n)")
    @PostMapping("/missing-number")
    public ResponseEntity<ArrayResponse> missingNumber(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        int result = service.missingNumber(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }

    @Operation(summary = "Find all unique triplets in the array which gives the sum of zero (3Sum problem)")
    @PostMapping("/three-sum")
    public ResponseEntity<ArrayResponse> threeSum(@Validated @RequestBody ArrayRequest.IntArrayInput request) {
        List<List<Integer>> result = service.threeSum(request.getNums());
        return ResponseEntity.ok(new ArrayResponse(result));
    }
}