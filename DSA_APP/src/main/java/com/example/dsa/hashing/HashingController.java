package com.example.dsa.hashing;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hashing")
@Tag(name = "Hashing", description = "DSA Hashing Problems")
public class HashingController {
    private final HashingService service;

    @Autowired
    public HashingController(HashingService service) {
        this.service = service;
    }

    @Operation(summary = "Find longest consecutive sequence")
    @PostMapping("/longest-consecutive")
    public ResponseEntity<HashingResponse> longestConsecutive(@Validated @RequestBody HashingRequest.LongestConsecutiveInput request) {
        int result = service.longestConsecutive(request.getNums());
        HashingResponse response = new HashingResponse();
        response.setLongestConsecutive(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find subarrays with given sum")
    @PostMapping("/subarray-sum")
    public ResponseEntity<HashingResponse> subarraySum(@Validated @RequestBody HashingRequest.SubarraySumInput request) {
        int result = service.subarraySum(request.getNums(), request.getK());
        HashingResponse response = new HashingResponse();
        response.setSubarraySum(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find longest subarray with given sum")
    @PostMapping("/longest-subarray")
    public ResponseEntity<HashingResponse> longestSubarray(@Validated @RequestBody HashingRequest.LongestSubarrayInput request) {
        int result = service.longestSubarray(request.getNums(), request.getK());
        HashingResponse response = new HashingResponse();
        response.setLongestSubarray(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find subarrays with XOR equal to K")
    @PostMapping("/subarrays-with-xor-k")
    public ResponseEntity<HashingResponse> subarraysWithXorK(@Validated @RequestBody HashingRequest.SubarraysWithXorKInput request) {
        int result = service.subarraysWithXorK(request.getNums(), request.getK());
        HashingResponse response = new HashingResponse();
        response.setSubarraysWithXorK(result);
        return ResponseEntity.ok(response);
    }
} 