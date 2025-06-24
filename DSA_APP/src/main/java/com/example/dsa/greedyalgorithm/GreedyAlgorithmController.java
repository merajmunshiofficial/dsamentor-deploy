package com.example.dsa.greedyalgorithm;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/greedy-algorithm")
@Tag(name = "Greedy Algorithm", description = "DSA Greedy Algorithm Problems")
public class GreedyAlgorithmController {
    private final GreedyAlgorithmService service;

    @Autowired
    public GreedyAlgorithmController(GreedyAlgorithmService service) {
        this.service = service;
    }

    @Operation(summary = "Find maximum number of meetings that can be held")
    @PostMapping("/max-meetings")
    public ResponseEntity<GreedyAlgorithmResponse> maxMeetings(@Validated @RequestBody GreedyAlgorithmRequest.MaxMeetingsInput request) {
        int result = service.maxMeetings(request.getStart(), request.getEnd());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setMaxMeetings(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find maximum non-overlapping intervals")
    @PostMapping("/max-non-overlapping-intervals")
    public ResponseEntity<GreedyAlgorithmResponse> maxNonOverlappingIntervals(@Validated @RequestBody GreedyAlgorithmRequest.MaxNonOverlappingIntervalsInput request) {
        int result = service.maxNonOverlappingIntervals(request.getIntervals());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setMaxNonOverlappingIntervals(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Insert new interval into sorted intervals")
    @PostMapping("/insert-new-interval")
    public ResponseEntity<GreedyAlgorithmResponse> insertNewInterval(@Validated @RequestBody GreedyAlgorithmRequest.InsertNewIntervalInput request) {
        List<List<Integer>> result = service.insertNewInterval(request.getIntervals(), request.getNewInterval());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setInsertNewInterval(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if lemonade change is possible")
    @PostMapping("/lemonade-change")
    public ResponseEntity<GreedyAlgorithmResponse> lemonadeChange(@Validated @RequestBody GreedyAlgorithmRequest.LemonadeChangeInput request) {
        boolean result = service.lemonadeChange(request.getBills());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setLemonadeChange(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Job scheduling with deadlines and profits")
    @PostMapping("/job-scheduling")
    public ResponseEntity<GreedyAlgorithmResponse> jobScheduling(@Validated @RequestBody GreedyAlgorithmRequest.JobSchedulingInput request) {
        int result = service.jobScheduling(request.getJobs());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setJobScheduling(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find minimum number of platforms required")
    @PostMapping("/find-platform")
    public ResponseEntity<GreedyAlgorithmResponse> findPlatform(@Validated @RequestBody GreedyAlgorithmRequest.FindPlatformInput request) {
        int result = service.findPlatform(request.getArr(), request.getDep(), request.getN());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setFindPlatform(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find maximum cookies for students")
    @PostMapping("/find-maximum-cookie-students")
    public ResponseEntity<GreedyAlgorithmResponse> findMaximumCookieStudents(@Validated @RequestBody GreedyAlgorithmRequest.FindMaximumCookieStudentsInput request) {
        int result = service.findMaximumCookieStudents(request.getG(), request.getS());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setFindMaximumCookieStudents(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if can jump to the last index")
    @PostMapping("/can-jump")
    public ResponseEntity<GreedyAlgorithmResponse> canJump(@Validated @RequestBody GreedyAlgorithmRequest.CanJumpInput request) {
        boolean result = service.canJump(request.getNums());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setCanJump(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Distribute candies to children")
    @PostMapping("/candy")
    public ResponseEntity<GreedyAlgorithmResponse> candy(@Validated @RequestBody GreedyAlgorithmRequest.CandyInput request) {
        int result = service.candy(request.getRatings());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setCandy(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if parentheses are valid")
    @PostMapping("/is-valid")
    public ResponseEntity<GreedyAlgorithmResponse> isValid(@Validated @RequestBody GreedyAlgorithmRequest.IsValidInput request) {
        boolean result = service.isValid(request.getS());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setIsValid(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Solve greedy problem")
    @PostMapping("/solve")
    public ResponseEntity<GreedyAlgorithmResponse> solve(@Validated @RequestBody GreedyAlgorithmRequest.SolveInput request) {
        int result = service.solve(request.getN(), request.getArr());
        GreedyAlgorithmResponse response = new GreedyAlgorithmResponse();
        response.setSolve(result);
        return ResponseEntity.ok(response);
    }
} 