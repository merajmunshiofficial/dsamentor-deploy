package com.example.dsa.heaps;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heaps")
@Tag(name = "Heaps", description = "DSA Heaps Problems")
public class HeapsController {

    private final HeapsService service;

    @Autowired
    public HeapsController(HeapsService service) {
        this.service = service;
    }

    @Operation(summary = "Convert array to heap")
    @PostMapping("/heap-converter")
    public ResponseEntity<HeapsResponse> heapConverter(@Validated @RequestBody HeapsRequest.HeapConverterInput request) {
        int[] result = service.minToMaxHeap(request.getArray());
        return ResponseEntity.ok(new HeapsResponse(result));
    }

    @Operation(summary = "Heap Sort an array")
    @PostMapping("/heap-sorter")
    public ResponseEntity<HeapsResponse> heapSorter(@Validated @RequestBody HeapsRequest.HeapSorterInput request) {
        int[] result = service.heapSort(request.getArray());
        return ResponseEntity.ok(new HeapsResponse(result));
    }

    @Operation(summary = "Find Kth Largest using Heap")
    @PostMapping("/kth-largest")
    public ResponseEntity<HeapsResponse> kthLargest(@Validated @RequestBody HeapsRequest.KthLargestInput request) {
        int result = service.kthLargestElement(request.getArray(), request.getK());
        return ResponseEntity.ok(new HeapsResponse(result));
    }

    @Operation(summary = "Find Kth Largest Element")
    @PostMapping("/kth-largest-element")
    public ResponseEntity<HeapsResponse> kthLargestElement(@Validated @RequestBody HeapsRequest.KthLargestElementInput request) {
        int result = service.kthLargestElement(request.getArray(), request.getK());
        return ResponseEntity.ok(new HeapsResponse(result));
    }

    @Operation(summary = "Max Heap Operations")
    @PostMapping("/max-heap")
    public ResponseEntity<HeapsResponse> maxHeap(@Validated @RequestBody HeapsRequest.MaxHeapInput request) {
        int[] arr = request.getArray();
        service.buildMaxHeap(arr);
        return ResponseEntity.ok(new HeapsResponse(arr));
    }

    @Operation(summary = "Min Heap Operations")
    @PostMapping("/min-heap")
    public ResponseEntity<HeapsResponse> minHeap(@Validated @RequestBody HeapsRequest.MinHeapInput request) {
        int[] result = service.buildMinHeap(request.getArray());
        return ResponseEntity.ok(new HeapsResponse(result));
    }

    @Operation(summary = "Adjust Min Heap")
    @PostMapping("/min-heap-adjuster")
    public ResponseEntity<HeapsResponse> minHeapAdjuster(@Validated @RequestBody HeapsRequest.MinHeapAdjusterInput request) {
        int[] result = service.adjustMinHeap(request.getArray(), request.getIndex(), request.getArray()[request.getIndex()] + 1);
        return ResponseEntity.ok(new HeapsResponse(result));
    }

    @Operation(summary = "Build Min Heap from Array")
    @PostMapping("/build-min-heap")
    public ResponseEntity<HeapsResponse> buildMinHeap(@Validated @RequestBody HeapsRequest.MinHeapInput request) {
        int[] result = service.buildMinHeap(request.getArray());
        return ResponseEntity.ok(new HeapsResponse(result));
    }

    @Operation(summary = "Adjust Min Heap Value at Index")
    @PostMapping("/adjust-min-heap")
    public ResponseEntity<HeapsResponse> adjustMinHeap(@Validated @RequestBody HeapsRequest.AdjustMinHeapInput request) {
        int[] result = service.adjustMinHeap(request.getArray(), request.getIndex(), request.getVal());
        return ResponseEntity.ok(new HeapsResponse(result));
    }

    @Operation(summary = "Validate Min Heap")
    @PostMapping("/min-heap-validator")
    public ResponseEntity<HeapsResponse> minHeapValidator(@Validated @RequestBody HeapsRequest.MinHeapValidatorInput request) {
        boolean result = service.isMinHeap(request.getArray());
        return ResponseEntity.ok(new HeapsResponse(result));
    }
}