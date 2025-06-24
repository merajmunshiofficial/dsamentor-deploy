package com.example.dsa.dynamicprogramming;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dynamic-programming")
@Tag(name = "Dynamic Programming", description = "DSA Dynamic Programming Problems")
public class DynamicProgrammingController {
    private final DynamicProgrammingService service;

    @Autowired
    public DynamicProgrammingController(DynamicProgrammingService service) {
        this.service = service;
    }

    @Operation(summary = "Count total ways to reach nth stair")
    @PostMapping("/climb-stairs")
    public ResponseEntity<DynamicProgrammingResponse> climbStairs(@Validated @RequestBody DynamicProgrammingRequest.ClimbStairsInput request) {
        int result = service.climbStairs(request.getN());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setClimbStairs(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Solve 0/1 Knapsack problem")
    @PostMapping("/knapsack-01")
    public ResponseEntity<DynamicProgrammingResponse> knapsack01(@Validated @RequestBody DynamicProgrammingRequest.Knapsack01Input request) {
        int result = service.knapsack01(request.getWt(), request.getVal(), request.getN(), request.getW());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setKnapsack01(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find minimum energy for frog jump")
    @PostMapping("/frog-jump")
    public ResponseEntity<DynamicProgrammingResponse> frogJump(@Validated @RequestBody DynamicProgrammingRequest.FrogJumpInput request) {
        int result = service.frogJump(request.getHeights());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setFrogJump(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find minimum energy for frog jump with k steps")
    @PostMapping("/frog-jump-k")
    public ResponseEntity<DynamicProgrammingResponse> frogJumpK(@Validated @RequestBody DynamicProgrammingRequest.FrogJumpKInput request) {
        int result = service.frogJumpK(request.getHeights(), request.getK());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setFrogJumpK(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "House robber problem - maximum money without adjacent houses")
    @PostMapping("/house-robber")
    public ResponseEntity<DynamicProgrammingResponse> houseRobber(@Validated @RequestBody DynamicProgrammingRequest.HouseRobberInput request) {
        int result = service.houseRobber(request.getNums());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setHouseRobber(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Longest Common Subsequence")
    @PostMapping("/longest-common-subsequence")
    public ResponseEntity<DynamicProgrammingResponse> longestCommonSubsequence(@Validated @RequestBody DynamicProgrammingRequest.LCSInput request) {
        int result = service.longestCommonSubsequence(request.getText1(), request.getText2());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setLongestCommonSubsequence(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Longest Common Substring")
    @PostMapping("/longest-common-substring")
    public ResponseEntity<DynamicProgrammingResponse> longestCommonSubstring(@Validated @RequestBody DynamicProgrammingRequest.LCSInput request) {
        int result = service.longestCommonSubstring(request.getText1(), request.getText2());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setLongestCommonSubstring(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Edit Distance between two strings")
    @PostMapping("/edit-distance")
    public ResponseEntity<DynamicProgrammingResponse> editDistance(@Validated @RequestBody DynamicProgrammingRequest.EditDistanceInput request) {
        int result = service.editDistance(request.getWord1(), request.getWord2());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setEditDistance(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Count distinct subsequences")
    @PostMapping("/distinct-subsequences")
    public ResponseEntity<DynamicProgrammingResponse> distinctSubsequences(@Validated @RequestBody DynamicProgrammingRequest.DistinctSubsequencesInput request) {
        int result = service.distinctSubsequences(request.getS(), request.getT());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setDistinctSubsequences(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Minimum coins to make amount")
    @PostMapping("/minimum-coins")
    public ResponseEntity<DynamicProgrammingResponse> minimumCoins(@Validated @RequestBody DynamicProgrammingRequest.MinimumCoinsInput request) {
        int result = service.minimumCoins(request.getCoins(), request.getAmount());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMinimumCoins(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Unbounded Knapsack problem")
    @PostMapping("/unbounded-knapsack")
    public ResponseEntity<DynamicProgrammingResponse> unboundedKnapsack(@Validated @RequestBody DynamicProgrammingRequest.Knapsack01Input request) {
        int result = service.unboundedKnapsack(request.getWt(), request.getVal(), request.getN(), request.getW());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setUnboundedKnapsack(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Rod cutting problem")
    @PostMapping("/rod-cutting")
    public ResponseEntity<DynamicProgrammingResponse> rodCutting(@Validated @RequestBody DynamicProgrammingRequest.RodCuttingInput request) {
        int result = service.rodCutting(request.getPrice(), request.getN());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setRodCutting(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Coin change problem - count ways")
    @PostMapping("/coin-change")
    public ResponseEntity<DynamicProgrammingResponse> coinChange(@Validated @RequestBody DynamicProgrammingRequest.MinimumCoinsInput request) {
        int result = service.coinChange(request.getCoins(), request.getAmount());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setCoinChange(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Target sum problem")
    @PostMapping("/target-sum")
    public ResponseEntity<DynamicProgrammingResponse> targetSum(@Validated @RequestBody DynamicProgrammingRequest.TargetSumInput request) {
        int result = service.targetSum(request.getN(), request.getTarget(), request.getNums());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setTargetSum(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Partition equal subset sum")
    @PostMapping("/partition-equal-subset-sum")
    public ResponseEntity<DynamicProgrammingResponse> partitionEqualSubsetSum(@Validated @RequestBody DynamicProgrammingRequest.PartitionEqualSubsetSumInput request) {
        boolean result = service.partitionEqualSubsetSum(request.getNums());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setPartitionEqualSubsetSum(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Perfect sum problem")
    @PostMapping("/perfect-sum")
    public ResponseEntity<DynamicProgrammingResponse> perfectSum(@Validated @RequestBody DynamicProgrammingRequest.PerfectSumInput request) {
        int result = service.perfectSum(request.getN(), request.getSum(), request.getArr());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setPerfectSum(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cherry pickup problem - maximum cherries collected")
    @PostMapping("/cherry-pickup")
    public ResponseEntity<DynamicProgrammingResponse> cherryPickup(@Validated @RequestBody DynamicProgrammingRequest.CherryPickupInput request) {
        int result = service.cherryPickup(request.getMatrix());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setCherryPickup(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Ninja training problem - maximum points")
    @PostMapping("/ninja-training")
    public ResponseEntity<DynamicProgrammingResponse> ninjaTraining(@Validated @RequestBody DynamicProgrammingRequest.NinjaTrainingInput request) {
        int result = service.ninjaTraining(request.getPoints());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setNinjaTraining(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Longest palindromic subsequence")
    @PostMapping("/longest-palindromic-subsequence")
    public ResponseEntity<DynamicProgrammingResponse> longestPalindromicSubsequence(@Validated @RequestBody DynamicProgrammingRequest.LongestPalindromicSubsequenceInput request) {
        int result = service.longestPalindromicSubsequence(request.getS());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setLongestPalindromicSubsequence(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Unique paths in grid")
    @PostMapping("/unique-paths")
    public ResponseEntity<DynamicProgrammingResponse> uniquePaths(@Validated @RequestBody DynamicProgrammingRequest.UniquePathsInput request) {
        int result = service.uniquePaths(request.getM(), request.getN());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setUniquePaths(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Unique paths with obstacles")
    @PostMapping("/unique-paths-with-obstacles")
    public ResponseEntity<DynamicProgrammingResponse> uniquePathsWithObstacles(@Validated @RequestBody DynamicProgrammingRequest.UniquePathsWithObstaclesInput request) {
        int result = service.uniquePathsWithObstacles(request.getObstacleGrid());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setUniquePathsWithObstacles(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Minimum falling path sum")
    @PostMapping("/min-falling-path-sum")
    public ResponseEntity<DynamicProgrammingResponse> minFallingPathSum(@Validated @RequestBody DynamicProgrammingRequest.MinFallingPathSumInput request) {
        int result = service.minFallingPathSum(request.getMatrix());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMinFallingPathSum(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Minimum triangle sum")
    @PostMapping("/min-triangle-sum")
    public ResponseEntity<DynamicProgrammingResponse> minTriangleSum(@Validated @RequestBody DynamicProgrammingRequest.MinTriangleSumInput request) {
        int result = service.minTriangleSum(request.getTriangle());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMinTriangleSum(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Maximum coins from balloons")
    @PostMapping("/max-coins")
    public ResponseEntity<DynamicProgrammingResponse> maxCoins(@Validated @RequestBody DynamicProgrammingRequest.MaxCoinsInput request) {
        int result = service.maxCoins(request.getNums());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMaxCoins(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Matrix chain multiplication")
    @PostMapping("/matrix-chain-multiplication")
    public ResponseEntity<DynamicProgrammingResponse> matrixChainMultiplication(@Validated @RequestBody DynamicProgrammingRequest.MatrixChainMultiplicationInput request) {
        int result = service.matrixChainMultiplication(request.getArr());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMatrixChainMultiplication(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Minimum cost to cut stick")
    @PostMapping("/min-cost")
    public ResponseEntity<DynamicProgrammingResponse> minCost(@Validated @RequestBody DynamicProgrammingRequest.MinCostInput request) {
        int result = service.minCost(request.getN(), request.getCuts());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMinCost(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Minimum cuts to make palindrome")
    @PostMapping("/min-cut")
    public ResponseEntity<DynamicProgrammingResponse> minCut(@Validated @RequestBody DynamicProgrammingRequest.MinCutInput request) {
        int result = service.minCut(request.getS());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMinCut(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Minimum difference partition")
    @PostMapping("/min-difference")
    public ResponseEntity<DynamicProgrammingResponse> minDifference(@Validated @RequestBody DynamicProgrammingRequest.MinDifferenceInput request) {
        int result = service.minDifference(request.getNums());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMinDifference(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Minimum insertions to make palindrome")
    @PostMapping("/min-insertions")
    public ResponseEntity<DynamicProgrammingResponse> minInsertions(@Validated @RequestBody DynamicProgrammingRequest.MinInsertionsInput request) {
        int result = service.minInsertions(request.getS());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMinInsertions(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Minimum operations to make array equal")
    @PostMapping("/min-operations")
    public ResponseEntity<DynamicProgrammingResponse> minOperations(@Validated @RequestBody DynamicProgrammingRequest.MinOperationsInput request) {
        int result = service.minOperations(request.getNums());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setMinOperations(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Non-adjacent elements maximum sum")
    @PostMapping("/non-adjacent")
    public ResponseEntity<DynamicProgrammingResponse> nonAdjacent(@Validated @RequestBody DynamicProgrammingRequest.NonAdjacentInput request) {
        int result = service.nonAdjacent(request.getNums());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setNonAdjacent(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Wildcard pattern matching")
    @PostMapping("/wildcard")
    public ResponseEntity<DynamicProgrammingResponse> wildcard(@Validated @RequestBody DynamicProgrammingRequest.WildcardInput request) {
        boolean result = service.wildcard(request.getPattern(), request.getStr());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setWildcard(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Count partitions with given difference")
    @PostMapping("/count-partitions")
    public ResponseEntity<DynamicProgrammingResponse> countPartitions(@Validated @RequestBody DynamicProgrammingRequest.CountPartitionsInput request) {
        int result = service.countPartitions(request.getN(), request.getD(), request.getArr());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setCountPartitions(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Equal partition sum")
    @PostMapping("/equal-partition")
    public ResponseEntity<DynamicProgrammingResponse> equalPartition(@Validated @RequestBody DynamicProgrammingRequest.EqualPartitionInput request) {
        boolean result = service.equalPartition(request.getN(), request.getArr());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setEqualPartition(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Is subset sum")
    @PostMapping("/is-subset-sum")
    public ResponseEntity<DynamicProgrammingResponse> isSubsetSum(@Validated @RequestBody DynamicProgrammingRequest.IsSubsetSumInput request) {
        boolean result = service.isSubsetSum(request.getN(), request.getArr(), request.getSum());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setIsSubsetSum(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Count ways to reach nth stair")
    @PostMapping("/count")
    public ResponseEntity<DynamicProgrammingResponse> count(@Validated @RequestBody DynamicProgrammingRequest.CountInput request) {
        int result = service.count(request.getN());
        DynamicProgrammingResponse response = new DynamicProgrammingResponse();
        response.setCount(result);
        return ResponseEntity.ok(response);
    }
} 