package com.example.dsa.hashing;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class HashingService {

    /**
     * Find longest consecutive sequence
     */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;
        Set<Integer> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        for (int it : st) {
            if (!st.contains(it - 1)) {
                int cnt = 1;
                int x = it;

                while (st.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    /**
     * Find subarrays with given sum
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentPrefixSum = 0, subarrayCount = 0;

        prefixSumMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            currentPrefixSum += nums[i];

            int sumToRemove = currentPrefixSum - k;
            subarrayCount += prefixSumMap.getOrDefault(sumToRemove, 0);

            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }
        return subarrayCount;
    }

    /**
     * Find longest subarray with given sum
     */
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentPrefixSum = 0, maxLength = 0;

        for (int i = 0; i < n; i++) {
            currentPrefixSum += nums[i];

            if (currentPrefixSum == k) {
                maxLength = i + 1;
            }

            if (prefixSumMap.containsKey(currentPrefixSum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(currentPrefixSum - k));
            }

            if (!prefixSumMap.containsKey(currentPrefixSum)) {
                prefixSumMap.put(currentPrefixSum, i);
            }
        }
        return maxLength;
    }

    /**
     * Find subarrays with XOR equal to K
     */
    public int subarraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> xorMap = new HashMap<>();
        int currentXor = 0, subarrayCount = 0;

        xorMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            currentXor ^= nums[i];

            int xorToRemove = currentXor ^ k;
            subarrayCount += xorMap.getOrDefault(xorToRemove, 0);

            xorMap.put(currentXor, xorMap.getOrDefault(currentXor, 0) + 1);
        }
        return subarrayCount;
    }
} 