package com.example.dsa.tries;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tries")
@Tag(name = "Tries", description = "DSA Tries Problems")
public class TriesController {

    private final TriesService service;

    @Autowired
    public TriesController(TriesService service) {
        this.service = service;
    }

    @Operation(summary = "Count Distinct Substrings")
    @PostMapping("/count-distinct")
    public ResponseEntity<TriesResponse> countDistinct(@Validated @RequestBody TriesRequest.CountDistinctInput request) {
        int result = service.countDistinct(request.getS());
        return ResponseEntity.ok(new TriesResponse(result));
    }

    @Operation(summary = "Find Maximum XOR of Two Numbers in an Array")
    @PostMapping("/find-maximum-xor")
    public ResponseEntity<TriesResponse> findMaximumXOR(@Validated @RequestBody TriesRequest.FindMaximumXORInput request) {
        int result = service.findMaximumXOR(request.getNums());
        return ResponseEntity.ok(new TriesResponse(result));
    }
} 