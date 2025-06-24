package com.example.dsa.bitmanipulation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bit-manipulation")
@Tag(name = "Bit Manipulation", description = "DSA Bit Manipulation Problems")
public class BitManipulationController {
    private final BitManipulationService service;

    @Autowired
    public BitManipulationController(BitManipulationService service) {
        this.service = service;
    }

    @Operation(summary = "Divide two integers without using multiplication or division")
    @PostMapping("/divide")
    public ResponseEntity<BitManipulationResponse> divide(@Validated @RequestBody BitManipulationRequest.DivideInput request) {
        int result = service.divide(request.getDividend(), request.getDivisor());
        BitManipulationResponse response = new BitManipulationResponse();
        response.setDivideResult(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the single number that appears once in an array where all others appear twice")
    @PostMapping("/single-number")
    public ResponseEntity<BitManipulationResponse> singleNumber(@Validated @RequestBody BitManipulationRequest.SingleNumberInput request) {
        int result = service.singleNumber(request.getNums());
        BitManipulationResponse response = new BitManipulationResponse();
        response.setSingleNumber(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the single number that appears once in an array where all others appear three times")
    @PostMapping("/single-number-ii")
    public ResponseEntity<BitManipulationResponse> singleNumberII(@Validated @RequestBody BitManipulationRequest.SingleNumberInput request) {
        int result = service.singleNumberII(request.getNums());
        BitManipulationResponse response = new BitManipulationResponse();
        response.setSingleNumberII(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find two single numbers that appear once in an array where all others appear twice")
    @PostMapping("/single-number-iii")
    public ResponseEntity<BitManipulationResponse> singleNumberIII(@Validated @RequestBody BitManipulationRequest.SingleNumberInput request) {
        int[] result = service.singleNumberIII(request.getNums());
        BitManipulationResponse response = new BitManipulationResponse();
        response.setSingleNumberIII(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Generate all possible subsets (power set) of an array")
    @PostMapping("/power-set")
    public ResponseEntity<BitManipulationResponse> powerSet(@Validated @RequestBody BitManipulationRequest.PowerSetInput request) {
        List<List<Integer>> result = service.powerSet(request.getNums());
        BitManipulationResponse response = new BitManipulationResponse();
        response.setPowerSet(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find XOR of numbers from L to R")
    @PostMapping("/find-range-xor")
    public ResponseEntity<BitManipulationResponse> findRangeXOR(@Validated @RequestBody BitManipulationRequest.FindRangeXORInput request) {
        int result = service.findRangeXOR(request.getL(), request.getR());
        BitManipulationResponse response = new BitManipulationResponse();
        response.setFindRangeXOR(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find minimum number of bit flips to convert start to goal")
    @PostMapping("/min-bits-flip")
    public ResponseEntity<BitManipulationResponse> minBitsFlip(@Validated @RequestBody BitManipulationRequest.MinBitsFlipInput request) {
        int result = service.minBitsFlip(request.getStart(), request.getGoal());
        BitManipulationResponse response = new BitManipulationResponse();
        response.setMinBitsFlip(result);
        return ResponseEntity.ok(response);
    }
} 