package com.example.dsa.slidingwindow;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sliding-window")
@Tag(name = "Sliding Window", description = "DSA Sliding Window Problems")
public class SlidingWindowController {
    private final SlidingWindowService service;

    @Autowired
    public SlidingWindowController(SlidingWindowService service) {
        this.service = service;
    }

    @Operation(summary = "Longest Repeating Character Replacement")
    @PostMapping("/character-replacement")
    public ResponseEntity<SlidingWindowResponse> characterReplacement(@Validated @RequestBody SlidingWindowRequest.CharacterReplacementInput request) {
        int result = service.characterReplacement(request.getS(), request.getK());
        return ResponseEntity.ok(new SlidingWindowResponse(result));
    }

    @Operation(summary = "Longest Substring with K Distinct Characters")
    @PostMapping("/k-distinct-char")
    public ResponseEntity<SlidingWindowResponse> kDistinctChar(@Validated @RequestBody SlidingWindowRequest.KDistinctCharInput request) {
        int result = service.kDistinctChar(request.getS(), request.getK());
        return ResponseEntity.ok(new SlidingWindowResponse(result));
    }

    @Operation(summary = "Longest Substring Without Repeating Characters")
    @PostMapping("/longest-non-repeating-substring")
    public ResponseEntity<SlidingWindowResponse> longestNonRepeatingSubstring(@Validated @RequestBody SlidingWindowRequest.LongestNonRepeatingSubstringInput request) {
        int result = service.longestNonRepeatingSubstring(request.getS());
        return ResponseEntity.ok(new SlidingWindowResponse(result));
    }

    @Operation(summary = "Max Consecutive Ones III")
    @PostMapping("/longest-ones")
    public ResponseEntity<SlidingWindowResponse> longestOnes(@Validated @RequestBody SlidingWindowRequest.LongestOnesInput request) {
        int result = service.longestOnes(request.getNums(), request.getK());
        return ResponseEntity.ok(new SlidingWindowResponse(result));
    }

    @Operation(summary = "Maximum Points You Can Obtain from Cards")
    @PostMapping("/max-score")
    public ResponseEntity<SlidingWindowResponse> maxScore(@Validated @RequestBody SlidingWindowRequest.MaxScoreInput request) {
        int result = service.maxScore(request.getCardPoints(), request.getK());
        return ResponseEntity.ok(new SlidingWindowResponse(result));
    }

    @Operation(summary = "Minimum Window Substring")
    @PostMapping("/min-window")
    public ResponseEntity<SlidingWindowResponse> minWindow(@Validated @RequestBody SlidingWindowRequest.MinWindowInput request) {
        String result = service.minWindow(request.getS(), request.getT());
        return ResponseEntity.ok(new SlidingWindowResponse(result));
    }

    @Operation(summary = "Number of Sub-arrays with Odd Sum")
    @PostMapping("/number-of-odd-subarrays")
    public ResponseEntity<SlidingWindowResponse> numberOfOddSubarrays(@Validated @RequestBody SlidingWindowRequest.NumberOfOddSubarraysInput request) {
        int result = service.numberOfOddSubarrays(request.getNums(), request.getK());
        return ResponseEntity.ok(new SlidingWindowResponse(result));
    }

    @Operation(summary = "Find number of substrings containing all characters 'a', 'b', 'c'")
    @PostMapping("/number-of-substrings")
    public ResponseEntity<SlidingWindowResponse> numberOfSubstrings(@Validated @RequestBody SlidingWindowRequest.NumberOfSubstringsInput request) {
        return ResponseEntity.ok(new SlidingWindowResponse(service.numberOfSubstrings(request.getS())));
    }
} 