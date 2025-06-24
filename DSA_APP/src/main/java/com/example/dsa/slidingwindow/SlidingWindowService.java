package com.example.dsa.slidingwindow;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SlidingWindowService {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxFreq = 0;
        int l = 0, r = 0;
        int[] hash = new int[26];

        while (r < s.length()) {
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
            
            if ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public int kDistinctChar(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        int l = 0, r = 0;
        
        while(r < n){
            char charR = s.charAt(r);
            mpp.put(charR, mpp.getOrDefault(charR, 0) + 1);
            
            if(mpp.size() > k){
                char charL = s.charAt(l);
                mpp.put(charL, mpp.get(charL) - 1);
                if(mpp.get(charL) == 0){
                    mpp.remove(charL);
                }
                l++;
            }
            
            if(mpp.size() <= k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            
            r++;
        }
        return maxLen;
    }

    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();
        int HashLen = 256;
        int[] hash = new int[HashLen];
        Arrays.fill(hash, -1);

        int l = 0, r = 0, maxLen = 0;
        while (r < n) {
            if (hash[s.charAt(r)] != -1) {
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }
            
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int zeros = 0, maxLen = 0;
        
        while (r < n) {
            if(nums[r] == 0) zeros++;
            
            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            if(zeros <= k){
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }

    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0, maxSum = 0;

        // Calculate the initial sum of the first k cards
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
            maxSum = lSum;
        }

        // Initialize rightIndex to iterate array from last
        int rightIndex = cardPoints.length - 1;
        
        for (int i = k - 1; i >= 0; i--) {
            // Remove the score of the ith card from left sum
            lSum -= cardPoints[i];   
            
            // Add the score of the card from the right to the right sum
            rSum += cardPoints[rightIndex];  
            
            // Move to the next card from the right
            rightIndex--; 

            // Update maxSum with the maximum sum found so far
            maxSum = Math.max(maxSum, lSum + rSum);
        }

        return maxSum;
    }

    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int[] hash = new int[256];
        
        // Count the frequencies of characters in t
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
            
        int count = 0;
        int l = 0, r = 0;
        
        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
                
            while (count == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }

    public int numberOfOddSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
    
    private int helper(int[] nums, int goal) {
        if (goal < 0) return 0;
        
        int l = 0, r = 0; 
        int sum = 0;      
        int count = 0;   
        
        while (r < nums.length) {
            sum += nums[r] % 2; 
            
            while (sum > goal) {
                sum -= nums[l] % 2;  
                l++;            
            }
            
            count += (r - l + 1);
            r++; 
        }
        
        return count;
    }

    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            lastSeen[s.charAt(i) - 'a'] = i;
            
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }
        
        return count;
    }
} 