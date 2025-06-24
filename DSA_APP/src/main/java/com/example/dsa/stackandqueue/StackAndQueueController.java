package com.example.dsa.stackandqueue;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stack-and-queue")
@Tag(name = "Stack and Queue", description = "DSA Stack and Queue Problems")
public class StackAndQueueController {

    private final StackAndQueueService service;

    @Autowired
    public StackAndQueueController(StackAndQueueService service) {
        this.service = service;
    }

    @Operation(summary = "Asteroid Collision")
    @PostMapping("/asteroid-collision")
    public ResponseEntity<StackAndQueueResponse> asteroidCollision(@Validated @RequestBody StackAndQueueRequest.AsteroidCollisionInput request) {
        int[] result = service.asteroidCollision(request.getAsteroids());
        return ResponseEntity.ok(new StackAndQueueResponse(result));
    }

    @Operation(summary = "Celebrity Problem")
    @PostMapping("/celebrity")
    public ResponseEntity<StackAndQueueResponse> celebrity(@Validated @RequestBody StackAndQueueRequest.CelebrityInput request) {
        int result = service.celebrity(request.getMatrix(), request.getN());
        return ResponseEntity.ok(new StackAndQueueResponse(result));
    }

    @Operation(summary = "Valid Parentheses")
    @PostMapping("/is-valid")
    public ResponseEntity<StackAndQueueResponse> isValidApi(@Validated @RequestBody StackAndQueueRequest.IsValidInput request) {
        boolean result = service.isValid(request.getS());
        return ResponseEntity.ok(new StackAndQueueResponse(result));
    }

    @Operation(summary = "Largest Rectangle in Histogram")
    @PostMapping("/largest-rectangle-area")
    public ResponseEntity<StackAndQueueResponse> largestRectangleArea(@Validated @RequestBody StackAndQueueRequest.LargestRectangleAreaInput request) {
        int result = service.largestRectangleArea(request.getHeights());
        return ResponseEntity.ok(new StackAndQueueResponse(result));
    }

    @Operation(summary = "LFU Cache Operations")
    @PostMapping("/lfu-cache")
    public ResponseEntity<StackAndQueueResponse> lfuCache(@Validated @RequestBody StackAndQueueRequest.LFUCacheInput request) {
        // Placeholder: actual implementation may require a more complex response
        String result = service.lfuCache(request);
        return ResponseEntity.ok(new StackAndQueueResponse(result));
    }

    @Operation(summary = "Stock Span Problem")
    @PostMapping("/stock-span")
    public ResponseEntity<StackAndQueueResponse> stockSpan(@Validated @RequestBody StackAndQueueRequest.StockSpanInput request) {
        int[] result = service.stockSpan(request.getPrices());
        return ResponseEntity.ok(new StackAndQueueResponse(result));
    }

    @Operation(summary = "Sum of Subarray Ranges")
    @PostMapping("/subarray-ranges")
    public ResponseEntity<StackAndQueueResponse> subArrayRangesApi(@Validated @RequestBody StackAndQueueRequest.SubArrayRangesInput request) {
        long result = service.subArrayRanges(request.getNums());
        return ResponseEntity.ok(new StackAndQueueResponse(result));
    }

    @Operation(summary = "Sum of Subarray Minimums")
    @PostMapping("/sum-subarray-mins")
    public ResponseEntity<StackAndQueueResponse> sumSubarrayMinsApi(@Validated @RequestBody StackAndQueueRequest.SumSubarrayMinsInput request) {
        long result = service.sumSubarrayMins(request.getArr());
        return ResponseEntity.ok(new StackAndQueueResponse(result));
    }

    @Operation(summary = "Trapping Rain Water")
    @PostMapping("/trap")
    public ResponseEntity<StackAndQueueResponse> trapApi(@Validated @RequestBody StackAndQueueRequest.TrapInput request) {
        int result = service.trap(request.getHeight());
        return ResponseEntity.ok(new StackAndQueueResponse(result));
    }
}