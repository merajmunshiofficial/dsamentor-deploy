package com.example.dsa.maths;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maths")
@Tag(name = "Maths", description = "DSA Maths Problems")
public class MathsController {
    private final MathsService service;

    @Autowired
    public MathsController(MathsService service) {
        this.service = service;
    }

    @Operation(summary = "Get prime factors for a list of numbers")
    @PostMapping("/prime-factors")
    public ResponseEntity<MathsResponse> primeFactors(@Validated @RequestBody MathsRequest.PrimeFactorsInput request) {
        return ResponseEntity.ok(new MathsResponse(service.primeFactors(request.getNumbers())));
    }

    @Operation(summary = "Get all primes up to n")
    @PostMapping("/prime-till-n")
    public ResponseEntity<MathsResponse> primeTillN(@Validated @RequestBody MathsRequest.PrimeTillNInput request) {
        MathsResponse response = new MathsResponse();
        response.setPrimesTillN(service.primeTillN(request.getN()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get the count of primes in each range")
    @PostMapping("/primes-in-range")
    public ResponseEntity<MathsResponse> primesInRange(@Validated @RequestBody MathsRequest.PrimesInRangeInput request) {
        MathsResponse response = new MathsResponse();
        response.setPrimesInRangeCount(service.primesInRange(request.getRanges()));
        return ResponseEntity.ok(response);
    }
} 