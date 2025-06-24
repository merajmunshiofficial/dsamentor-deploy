package com.example.dsa.dynamicprogramming;

public class DynamicProgrammingResponse {
    private Integer climbStairs;
    private Integer knapsack01;
    private Integer frogJump;
    private Integer frogJumpK;
    private Integer houseRobber;
    private Integer longestCommonSubsequence;
    private Integer longestCommonSubstring;
    private Integer editDistance;
    private Integer distinctSubsequences;
    private Integer minimumCoins;
    private Integer unboundedKnapsack;
    private Integer rodCutting;
    private Integer coinChange;
    private Integer targetSum;
    private Boolean partitionEqualSubsetSum;
    private Integer perfectSum;

    // Additional missing problems
    private Integer cherryPickup;
    private Integer ninjaTraining;
    private Integer longestPalindromicSubsequence;
    private Integer uniquePaths;
    private Integer uniquePathsWithObstacles;
    private Integer minFallingPathSum;
    private Integer minTriangleSum;
    private Integer maxCoins;
    private Integer matrixChainMultiplication;
    private Integer minCost;
    private Integer minCut;
    private Integer minDifference;
    private Integer minInsertions;
    private Integer minOperations;
    private Integer nonAdjacent;
    private Boolean wildcard;
    private Integer countPartitions;
    private Boolean equalPartition;
    private Boolean isSubsetSum;
    private Integer count;

    public DynamicProgrammingResponse() {}

    public DynamicProgrammingResponse(Integer climbStairs) {
        this.climbStairs = climbStairs;
    }

    public DynamicProgrammingResponse(Integer knapsack01, boolean isKnapsack) {
        this.knapsack01 = knapsack01;
    }

    public DynamicProgrammingResponse(Integer frogJumpK, int dummy) {
        this.frogJumpK = frogJumpK;
    }

    public DynamicProgrammingResponse(Integer houseRobber, double dummy) {
        this.houseRobber = houseRobber;
    }

    public DynamicProgrammingResponse(Integer lcs, long dummy) {
        this.longestCommonSubsequence = lcs;
    }

    public DynamicProgrammingResponse(Integer lcs, char dummy) {
        this.longestCommonSubstring = lcs;
    }

    public DynamicProgrammingResponse(Integer editDistance, float dummy) {
        this.editDistance = editDistance;
    }

    public DynamicProgrammingResponse(Integer distinctSubsequences, byte dummy) {
        this.distinctSubsequences = distinctSubsequences;
    }

    public DynamicProgrammingResponse(Integer minimumCoins, short dummy) {
        this.minimumCoins = minimumCoins;
    }

    public DynamicProgrammingResponse(Integer unboundedKnapsack, Integer dummy) {
        this.unboundedKnapsack = unboundedKnapsack;
    }

    public DynamicProgrammingResponse(Integer rodCutting, String dummy) {
        this.rodCutting = rodCutting;
    }

    public DynamicProgrammingResponse(Integer coinChange, Boolean dummy) {
        this.coinChange = coinChange;
    }

    public DynamicProgrammingResponse(Integer targetSum, Long dummy) {
        this.targetSum = targetSum;
    }

    public DynamicProgrammingResponse(Boolean partitionEqualSubsetSum) {
        this.partitionEqualSubsetSum = partitionEqualSubsetSum;
    }

    public DynamicProgrammingResponse(Integer perfectSum, Double dummy) {
        this.perfectSum = perfectSum;
    }

    // Getters and Setters
    public Integer getClimbStairs() { return climbStairs; }
    public void setClimbStairs(Integer climbStairs) { this.climbStairs = climbStairs; }

    public Integer getKnapsack01() { return knapsack01; }
    public void setKnapsack01(Integer knapsack01) { this.knapsack01 = knapsack01; }

    public Integer getFrogJump() { return frogJump; }
    public void setFrogJump(Integer frogJump) { this.frogJump = frogJump; }

    public Integer getFrogJumpK() { return frogJumpK; }
    public void setFrogJumpK(Integer frogJumpK) { this.frogJumpK = frogJumpK; }

    public Integer getHouseRobber() { return houseRobber; }
    public void setHouseRobber(Integer houseRobber) { this.houseRobber = houseRobber; }

    public Integer getLongestCommonSubsequence() { return longestCommonSubsequence; }
    public void setLongestCommonSubsequence(Integer longestCommonSubsequence) { this.longestCommonSubsequence = longestCommonSubsequence; }

    public Integer getLongestCommonSubstring() { return longestCommonSubstring; }
    public void setLongestCommonSubstring(Integer longestCommonSubstring) { this.longestCommonSubstring = longestCommonSubstring; }

    public Integer getEditDistance() { return editDistance; }
    public void setEditDistance(Integer editDistance) { this.editDistance = editDistance; }

    public Integer getDistinctSubsequences() { return distinctSubsequences; }
    public void setDistinctSubsequences(Integer distinctSubsequences) { this.distinctSubsequences = distinctSubsequences; }

    public Integer getMinimumCoins() { return minimumCoins; }
    public void setMinimumCoins(Integer minimumCoins) { this.minimumCoins = minimumCoins; }

    public Integer getUnboundedKnapsack() { return unboundedKnapsack; }
    public void setUnboundedKnapsack(Integer unboundedKnapsack) { this.unboundedKnapsack = unboundedKnapsack; }

    public Integer getRodCutting() { return rodCutting; }
    public void setRodCutting(Integer rodCutting) { this.rodCutting = rodCutting; }

    public Integer getCoinChange() { return coinChange; }
    public void setCoinChange(Integer coinChange) { this.coinChange = coinChange; }

    public Integer getTargetSum() { return targetSum; }
    public void setTargetSum(Integer targetSum) { this.targetSum = targetSum; }

    public Boolean getPartitionEqualSubsetSum() { return partitionEqualSubsetSum; }
    public void setPartitionEqualSubsetSum(Boolean partitionEqualSubsetSum) { this.partitionEqualSubsetSum = partitionEqualSubsetSum; }

    public Integer getPerfectSum() { return perfectSum; }
    public void setPerfectSum(Integer perfectSum) { this.perfectSum = perfectSum; }

    // Additional missing problems
    public Integer getCherryPickup() { return cherryPickup; }
    public void setCherryPickup(Integer cherryPickup) { this.cherryPickup = cherryPickup; }

    public Integer getNinjaTraining() { return ninjaTraining; }
    public void setNinjaTraining(Integer ninjaTraining) { this.ninjaTraining = ninjaTraining; }

    public Integer getLongestPalindromicSubsequence() { return longestPalindromicSubsequence; }
    public void setLongestPalindromicSubsequence(Integer longestPalindromicSubsequence) { this.longestPalindromicSubsequence = longestPalindromicSubsequence; }

    public Integer getUniquePaths() { return uniquePaths; }
    public void setUniquePaths(Integer uniquePaths) { this.uniquePaths = uniquePaths; }

    public Integer getUniquePathsWithObstacles() { return uniquePathsWithObstacles; }
    public void setUniquePathsWithObstacles(Integer uniquePathsWithObstacles) { this.uniquePathsWithObstacles = uniquePathsWithObstacles; }

    public Integer getMinFallingPathSum() { return minFallingPathSum; }
    public void setMinFallingPathSum(Integer minFallingPathSum) { this.minFallingPathSum = minFallingPathSum; }

    public Integer getMinTriangleSum() { return minTriangleSum; }
    public void setMinTriangleSum(Integer minTriangleSum) { this.minTriangleSum = minTriangleSum; }

    public Integer getMaxCoins() { return maxCoins; }
    public void setMaxCoins(Integer maxCoins) { this.maxCoins = maxCoins; }

    public Integer getMatrixChainMultiplication() { return matrixChainMultiplication; }
    public void setMatrixChainMultiplication(Integer matrixChainMultiplication) { this.matrixChainMultiplication = matrixChainMultiplication; }

    public Integer getMinCost() { return minCost; }
    public void setMinCost(Integer minCost) { this.minCost = minCost; }

    public Integer getMinCut() { return minCut; }
    public void setMinCut(Integer minCut) { this.minCut = minCut; }

    public Integer getMinDifference() { return minDifference; }
    public void setMinDifference(Integer minDifference) { this.minDifference = minDifference; }

    public Integer getMinInsertions() { return minInsertions; }
    public void setMinInsertions(Integer minInsertions) { this.minInsertions = minInsertions; }

    public Integer getMinOperations() { return minOperations; }
    public void setMinOperations(Integer minOperations) { this.minOperations = minOperations; }

    public Integer getNonAdjacent() { return nonAdjacent; }
    public void setNonAdjacent(Integer nonAdjacent) { this.nonAdjacent = nonAdjacent; }

    public Boolean getWildcard() { return wildcard; }
    public void setWildcard(Boolean wildcard) { this.wildcard = wildcard; }

    public Integer getCountPartitions() { return countPartitions; }
    public void setCountPartitions(Integer countPartitions) { this.countPartitions = countPartitions; }

    public Boolean getEqualPartition() { return equalPartition; }
    public void setEqualPartition(Boolean equalPartition) { this.equalPartition = equalPartition; }

    public Boolean getIsSubsetSum() { return isSubsetSum; }
    public void setIsSubsetSum(Boolean isSubsetSum) { this.isSubsetSum = isSubsetSum; }

    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }
}