package com.example.dsa.dynamicprogramming;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class DynamicProgrammingService {

    /**
     * Count total ways to reach nth stair
     */
    public int climbStairs(int n) {
        // Declare dp array of size n+1
        int[] dp = new int[n + 1];

        // Insert the values of base conditions
        dp[0] = 1;
        dp[1] = 1;

        // Iterate and update every index of dp array
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the answer
        return dp[n];
    }

    /**
     * Solve 0/1 Knapsack problem
     */
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        // Initialize DP table with -1
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return knapsack01Helper(wt, val, n - 1, W, dp);
    }

    private int knapsack01Helper(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // Base case: If there are no items left or the knapsack has no capacity, return 0
        if (ind < 0 || W == 0) {
            return 0;
        }

        // If the result for this state is already calculated, return it
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        // Calculate the maximum value by either excluding the current item or including it
        int notTaken = knapsack01Helper(wt, val, ind - 1, W, dp);
        int taken = 0;

        // Check if the current item can be included without exceeding the knapsack's capacity
        if (wt[ind] <= W) {
            taken = val[ind] + knapsack01Helper(wt, val, ind - 1, W - wt[ind], dp);
        }

        // Store the result in the DP table and return
        dp[ind][W] = Math.max(notTaken, taken);
        return dp[ind][W];
    }

    /**
     * Find minimum energy for frog jump
     */
    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // Start solving from the last stair
        return frogJumpHelper(n - 1, heights, dp);
    }

    private int frogJumpHelper(int ind, int[] heights, int[] dp) {
        // Base case
        if (ind == 0) return 0;
        // Memoized result
        if (dp[ind] != -1) return dp[ind];

        int jumpOne = frogJumpHelper(ind - 1, heights, dp) + Math.abs(heights[ind] - heights[ind - 1]);
        int jumpTwo = Integer.MAX_VALUE;
        if (ind > 1)
            jumpTwo = frogJumpHelper(ind - 2, heights, dp) + Math.abs(heights[ind] - heights[ind - 2]);
        // Store and return result
        return dp[ind] = Math.min(jumpOne, jumpTwo);
    }

    /**
     * Find minimum energy for frog jump with k steps
     */
    public int frogJumpK(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpKHelper(n - 1, heights, k, dp);
    }

    private int frogJumpKHelper(int ind, int[] heights, int k, int[] dp) {
        if (ind == 0) return 0;
        if (dp[ind] != -1) return dp[ind];

        int minEnergy = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int energy = frogJumpKHelper(ind - j, heights, k, dp) + Math.abs(heights[ind] - heights[ind - j]);
                minEnergy = Math.min(minEnergy, energy);
            }
        }
        return dp[ind] = minEnergy;
    }

    /**
     * House robber problem - maximum money without adjacent houses
     */
    public int houseRobber(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return houseRobberHelper(n - 1, nums, dp);
    }

    private int houseRobberHelper(int ind, int[] nums, int[] dp) {
        if (ind < 0) return 0;
        if (dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + houseRobberHelper(ind - 2, nums, dp);
        int notPick = houseRobberHelper(ind - 1, nums, dp);
        return dp[ind] = Math.max(pick, notPick);
    }

    /**
     * Longest Common Subsequence
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcsHelper(n - 1, m - 1, text1, text2, dp);
    }

    private int lcsHelper(int ind1, int ind2, String text1, String text2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) return 0;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcsHelper(ind1 - 1, ind2 - 1, text1, text2, dp);
        }
        return dp[ind1][ind2] = Math.max(lcsHelper(ind1 - 1, ind2, text1, text2, dp),
                                        lcsHelper(ind1, ind2 - 1, text1, text2, dp));
    }

    /**
     * Longest Common Substring
     */
    public int longestCommonSubstring(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }

    /**
     * Edit Distance between two strings
     */
    public int editDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return editDistanceHelper(n - 1, m - 1, word1, word2, dp);
    }

    private int editDistanceHelper(int ind1, int ind2, String word1, String word2, int[][] dp) {
        if (ind1 < 0) return ind2 + 1;
        if (ind2 < 0) return ind1 + 1;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if (word1.charAt(ind1) == word2.charAt(ind2)) {
            return dp[ind1][ind2] = editDistanceHelper(ind1 - 1, ind2 - 1, word1, word2, dp);
        }
        return dp[ind1][ind2] = 1 + Math.min(editDistanceHelper(ind1 - 1, ind2, word1, word2, dp),
                                            Math.min(editDistanceHelper(ind1, ind2 - 1, word1, word2, dp),
                                                    editDistanceHelper(ind1 - 1, ind2 - 1, word1, word2, dp)));
    }

    /**
     * Count distinct subsequences
     */
    public int distinctSubsequences(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return distinctSubsequencesHelper(n - 1, m - 1, s, t, dp);
    }

    private int distinctSubsequencesHelper(int ind1, int ind2, String s, String t, int[][] dp) {
        if (ind2 < 0) return 1;
        if (ind1 < 0) return 0;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if (s.charAt(ind1) == t.charAt(ind2)) {
            return dp[ind1][ind2] = distinctSubsequencesHelper(ind1 - 1, ind2 - 1, s, t, dp) +
                                   distinctSubsequencesHelper(ind1 - 1, ind2, s, t, dp);
        }
        return dp[ind1][ind2] = distinctSubsequencesHelper(ind1 - 1, ind2, s, t, dp);
    }

    /**
     * Minimum coins to make amount
     */
    public int minimumCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * Unbounded Knapsack problem
     */
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int j = wt[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }
        return dp[W];
    }

    /**
     * Rod cutting problem
     */
    public int rodCutting(int[] price, int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }
        return dp[n];
    }

    /**
     * Coin change problem - count ways
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    /**
     * Target sum problem
     */
    public int targetSum(int n, int target, int[] nums) {
        int totSum = 0;
        for (int num : nums) {
            totSum += num;
        }

        if (totSum - target < 0 || (totSum - target) % 2 == 1) return 0;

        int s2 = (totSum - target) / 2;
        int[][] dp = new int[n][s2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return targetSumHelper(n - 1, s2, nums, dp);
    }

    private int targetSumHelper(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }
        if (dp[ind][target] != -1) return dp[ind][target];

        int notTaken = targetSumHelper(ind - 1, target, arr, dp);
        int taken = 0;
        if (arr[ind] <= target) {
            taken = targetSumHelper(ind - 1, target - arr[ind], arr, dp);
        }
        return dp[ind][target] = notTaken + taken;
    }

    /**
     * Partition equal subset sum
     */
    public boolean partitionEqualSubsetSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    /**
     * Perfect sum problem
     */
    public int perfectSum(int n, int sum, int[] arr) {
        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return perfectSumHelper(n - 1, sum, arr, dp);
    }

    private int perfectSumHelper(int ind, int sum, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (sum == 0 && arr[0] == 0) return 2;
            if (sum == 0 || sum == arr[0]) return 1;
            return 0;
        }
        if (dp[ind][sum] != -1) return dp[ind][sum];

        int notTaken = perfectSumHelper(ind - 1, sum, arr, dp);
        int taken = 0;
        if (arr[ind] <= sum) {
            taken = perfectSumHelper(ind - 1, sum - arr[ind], arr, dp);
        }
        return dp[ind][sum] = notTaken + taken;
    }

    // Additional missing problems
    /**
     * Cherry pickup problem - maximum cherries collected
     */
    public int cherryPickup(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][][] dp = new int[n][m][m];
        
        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return cherryPickupHelper(0, 0, m - 1, n, m, matrix, dp);
    }

    private int cherryPickupHelper(int i, int j1, int j2, int n, int m, int[][] matrix, int[][][] dp) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return (int)(-1e9);
        
        if (i == n - 1) {
            if (j1 == j2) return matrix[i][j1];
            else return matrix[i][j1] + matrix[i][j2];
        }
        
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int maxi = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans;
                if (j1 == j2)
                    ans = matrix[i][j1] + cherryPickupHelper(i + 1, j1 + di, j2 + dj, n, m, matrix, dp);
                else
                    ans = matrix[i][j1] + matrix[i][j2] + cherryPickupHelper(i + 1, j1 + di, j2 + dj, n, m, matrix, dp);
                maxi = Math.max(maxi, ans);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    /**
     * Ninja training problem - maximum points
     */
    public int ninjaTraining(int[][] points) {
        int days = points.length;
        int[][] dp = new int[days][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        return ninjaTrainingHelper(days - 1, 3, points, dp);
    }

    private int ninjaTrainingHelper(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) return dp[day][last];
        
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi;
        }
        
        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int activity = points[day][i] + ninjaTrainingHelper(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity);
            }
        }
        return dp[day][last] = maxi;
    }

    /**
     * Longest palindromic subsequence
     */
    public int longestPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return lpsHelper(0, n - 1, s, dp);
    }

    private int lpsHelper(int i, int j, String s, int[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + lpsHelper(i + 1, j - 1, s, dp);
        }
        return dp[i][j] = Math.max(lpsHelper(i + 1, j, s, dp), lpsHelper(i, j - 1, s, dp));
    }

    /**
     * Unique paths in grid
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return uniquePathsHelper(m - 1, n - 1, dp);
    }

    private int uniquePathsHelper(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = uniquePathsHelper(i - 1, j, dp) + uniquePathsHelper(i, j - 1, dp);
    }

    /**
     * Unique paths with obstacles
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return uniquePathsWithObstaclesHelper(m - 1, n - 1, obstacleGrid, dp);
    }

    private int uniquePathsWithObstaclesHelper(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = uniquePathsWithObstaclesHelper(i - 1, j, obstacleGrid, dp) + 
                         uniquePathsWithObstaclesHelper(i, j - 1, obstacleGrid, dp);
    }

    /**
     * Minimum falling path sum
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, minFallingPathSumHelper(n - 1, j, matrix, dp));
        }
        return minSum;
    }

    private int minFallingPathSumHelper(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[0].length) return (int)(1e9);
        if (i == 0) return matrix[0][j];
        if (dp[i][j] != -1) return dp[i][j];
        
        int up = matrix[i][j] + minFallingPathSumHelper(i - 1, j, matrix, dp);
        int leftDiagonal = matrix[i][j] + minFallingPathSumHelper(i - 1, j - 1, matrix, dp);
        int rightDiagonal = matrix[i][j] + minFallingPathSumHelper(i - 1, j + 1, matrix, dp);
        
        return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    /**
     * Minimum triangle sum
     */
    public int minTriangleSum(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minTriangleSumHelper(0, 0, triangle, dp);
    }

    private int minTriangleSumHelper(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if (i == triangle.size() - 1) return triangle.get(i).get(j);
        if (dp[i][j] != -1) return dp[i][j];
        
        int down = triangle.get(i).get(j) + minTriangleSumHelper(i + 1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + minTriangleSumHelper(i + 1, j + 1, triangle, dp);
        
        return dp[i][j] = Math.min(down, diagonal);
    }

    /**
     * Maximum coins from balloons
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return maxCoinsHelper(1, n, newNums, dp);
    }

    private int maxCoinsHelper(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = nums[i - 1] * nums[ind] * nums[j + 1] + 
                      maxCoinsHelper(i, ind - 1, nums, dp) + 
                      maxCoinsHelper(ind + 1, j, nums, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }

    /**
     * Matrix chain multiplication
     */
    public int matrixChainMultiplication(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return matrixChainMultiplicationHelper(1, n - 1, arr, dp);
    }

    private int matrixChainMultiplicationHelper(int i, int j, int[] arr, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + 
                       matrixChainMultiplicationHelper(i, k, arr, dp) + 
                       matrixChainMultiplicationHelper(k + 1, j, arr, dp);
            mini = Math.min(mini, steps);
        }
        return dp[i][j] = mini;
    }

    /**
     * Minimum cost to cut stick
     */
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        newCuts[c + 1] = n;
        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts[i];
        }
        Arrays.sort(newCuts);
        
        int[][] dp = new int[c + 2][c + 2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minCostHelper(1, c, newCuts, dp);
    }

    private int minCostHelper(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = cuts[j + 1] - cuts[i - 1] + 
                      minCostHelper(i, ind - 1, cuts, dp) + 
                      minCostHelper(ind + 1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }

    /**
     * Minimum cuts to make palindrome
     */
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCutHelper(0, n, s, dp);
    }

    private int minCutHelper(int i, int n, String s, int[] dp) {
        if (i == n) return 0;
        if (dp[i] != -1) return dp[i];
        
        int minCost = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + minCutHelper(j + 1, n, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * Minimum difference partition
     */
    public int minDifference(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for (int num : nums) totSum += num;
        
        boolean[][] dp = new boolean[n][totSum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= totSum) dp[0][nums[0]] = true;
        
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totSum; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (nums[ind] <= target) taken = dp[ind - 1][target - nums[ind]];
                dp[ind][target] = notTaken || taken;
            }
        }
        
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    /**
     * Minimum insertions to make palindrome
     */
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minInsertionsHelper(0, n - 1, s, dp);
    }

    private int minInsertionsHelper(int i, int j, String s, int[][] dp) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = minInsertionsHelper(i + 1, j - 1, s, dp);
        }
        return dp[i][j] = 1 + Math.min(minInsertionsHelper(i + 1, j, s, dp), 
                                      minInsertionsHelper(i, j - 1, s, dp));
    }

    /**
     * Minimum operations to make array equal
     */
    public int minOperations(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % n != 0) return -1;
        int target = sum / n;
        
        int operations = 0;
        for (int num : nums) {
            operations += Math.abs(num - target);
        }
        return operations / 2;
    }

    /**
     * Non-adjacent elements maximum sum
     */
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return nonAdjacentHelper(n - 1, nums, dp);
    }

    private int nonAdjacentHelper(int ind, int[] nums, int[] dp) {
        if (ind < 0) return 0;
        if (dp[ind] != -1) return dp[ind];
        
        int pick = nums[ind] + nonAdjacentHelper(ind - 2, nums, dp);
        int notPick = nonAdjacentHelper(ind - 1, nums, dp);
        return dp[ind] = Math.max(pick, notPick);
    }

    /**
     * Wildcard pattern matching
     */
    public boolean wildcard(String pattern, String str) {
        int n = pattern.length();
        int m = str.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return wildcardHelper(n - 1, m - 1, pattern, str, dp) == 1;
    }

    private int wildcardHelper(int i, int j, String pattern, String str, int[][] dp) {
        if (i < 0 && j < 0) return 1;
        if (i < 0 && j >= 0) return 0;
        if (j < 0 && i >= 0) {
            for (int ii = 0; ii <= i; ii++) {
                if (pattern.charAt(ii) != '*') return 0;
            }
            return 1;
        }
        if (dp[i][j] != -1) return dp[i][j];
        
        if (pattern.charAt(i) == str.charAt(j) || pattern.charAt(i) == '?') {
            return dp[i][j] = wildcardHelper(i - 1, j - 1, pattern, str, dp);
        }
        if (pattern.charAt(i) == '*') {
            return dp[i][j] = wildcardHelper(i - 1, j, pattern, str, dp) | 
                             wildcardHelper(i, j - 1, pattern, str, dp);
        }
        return dp[i][j] = 0;
    }

    /**
     * Count partitions with given difference
     */
    public int countPartitions(int n, int d, int[] arr) {
        int totSum = 0;
        for (int num : arr) totSum += num;
        
        if (totSum - d < 0 || (totSum - d) % 2 == 1) return 0;
        int s2 = (totSum - d) / 2;
        
        int[][] dp = new int[n][s2 + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return countPartitionsHelper(n - 1, s2, arr, dp);
    }

    private int countPartitionsHelper(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }
        if (dp[ind][target] != -1) return dp[ind][target];
        
        int notTaken = countPartitionsHelper(ind - 1, target, arr, dp);
        int taken = 0;
        if (arr[ind] <= target) {
            taken = countPartitionsHelper(ind - 1, target - arr[ind], arr, dp);
        }
        return dp[ind][target] = notTaken + taken;
    }

    /**
     * Equal partition sum
     */
    public boolean equalPartition(int n, int[] arr) {
        int totSum = 0;
        for (int num : arr) totSum += num;
        
        if (totSum % 2 == 1) return false;
        int target = totSum / 2;
        
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (arr[0] <= target) dp[0][arr[0]] = true;
        
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 1; cap <= target; cap++) {
                boolean notTaken = dp[ind - 1][cap];
                boolean taken = false;
                if (arr[ind] <= cap) taken = dp[ind - 1][cap - arr[ind]];
                dp[ind][cap] = notTaken || taken;
            }
        }
        return dp[n - 1][target];
    }

    /**
     * Is subset sum
     */
    public boolean isSubsetSum(int n, int[] arr, int sum) {
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (arr[0] <= sum) dp[0][arr[0]] = true;
        
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= sum; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) taken = dp[ind - 1][target - arr[ind]];
                dp[ind][target] = notTaken || taken;
            }
        }
        return dp[n - 1][sum];
    }

    /**
     * Count ways to reach nth stair
     */
    public int count(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countHelper(n, dp);
    }

    private int countHelper(int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        
        return dp[n] = countHelper(n - 1, dp) + countHelper(n - 2, dp);
    }
} 