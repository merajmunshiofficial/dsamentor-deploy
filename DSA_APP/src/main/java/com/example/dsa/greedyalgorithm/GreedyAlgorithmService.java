package com.example.dsa.greedyalgorithm;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GreedyAlgorithmService {

    /**
     * Find maximum number of meetings that can be held
     */
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        List<int[]> meetings = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], end[i]});
        }

        Collections.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));

        int limit = meetings.get(0)[1];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (meetings.get(i)[0] > limit) {
                limit = meetings.get(i)[1];
                count++;
            }
        }
        return count;
    }

    /**
     * Find maximum non-overlapping intervals
     */
    public int maxNonOverlappingIntervals(List<List<Integer>> intervals) {
        if (intervals.isEmpty()) return 0;
        
        intervals.sort((a, b) -> Integer.compare(a.get(1), b.get(1)));
        
        int count = 1;
        int end = intervals.get(0).get(1);
        
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).get(0) >= end) {
                count++;
                end = intervals.get(i).get(1);
            }
        }
        return count;
    }

    /**
     * Insert new interval into sorted intervals
     */
    public List<List<Integer>> insertNewInterval(List<List<Integer>> intervals, List<Integer> newInterval) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (List<Integer> interval : intervals) {
            if (interval.get(1) < newInterval.get(0)) {
                result.add(interval);
            } else if (interval.get(0) > newInterval.get(1)) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                newInterval.set(0, Math.min(newInterval.get(0), interval.get(0)));
                newInterval.set(1, Math.max(newInterval.get(1), interval.get(1)));
            }
        }
        result.add(newInterval);
        return result;
    }

    /**
     * Check if lemonade change is possible
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Job scheduling with deadlines and profits
     */
    public int jobScheduling(List<List<Integer>> jobs) {
        jobs.sort((a, b) -> Integer.compare(b.get(2), a.get(2))); // Sort by profit descending
        
        int maxDeadline = 0;
        for (List<Integer> job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.get(1));
        }
        
        boolean[] slot = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        
        for (List<Integer> job : jobs) {
            int deadline = job.get(1);
            int profit = job.get(2);
            
            for (int i = deadline; i > 0; i--) {
                if (!slot[i]) {
                    slot[i] = true;
                    totalProfit += profit;
                    break;
                }
            }
        }
        return totalProfit;
    }

    /**
     * Find minimum number of platforms required
     */
    public int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platforms = 1;
        int maxPlatforms = 1;
        int i = 1, j = 0;
        
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }
        return maxPlatforms;
    }

    /**
     * Find maximum cookies for students
     */
    public int findMaximumCookieStudents(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0, j = 0;
        int count = 0;
        
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    /**
     * Check if can jump to the last index
     */
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }

    /**
     * Distribute candies to children
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

    /**
     * Check if parentheses are valid
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Solve greedy problem
     */
    public int solve(int n, int[] arr) {
        // This is a generic solve method - implementation depends on specific problem
        // For now, returning a simple greedy solution
        if (n == 0) return 0;
        
        Arrays.sort(arr);
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            result += arr[i] * (i + 1);
        }
        return result;
    }
} 