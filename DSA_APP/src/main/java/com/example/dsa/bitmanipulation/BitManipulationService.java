package com.example.dsa.bitmanipulation;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class BitManipulationService {

    /**
     * Divide two integers without using multiplication or division
     */
    public int divide(int dividend, int divisor) {
        // Base case
        if(dividend == divisor) return 1;
        
        // Variable to store the sign of result
        boolean isPositive = true;
        
        // Updating the sign of quotient
        if(dividend >= 0 && divisor < 0) 
            isPositive = false;
        else if(dividend < 0 && divisor > 0)
            isPositive = false;
            
        // Storing absolute dividend & divisor
        int n = Math.abs(dividend);
        int d = Math.abs(divisor);
        
        // Variable to store the answer
        int ans = 0;
        
        // Looping while dividend is greater than equal to divisor
        while(n >= d) {
            int count = 0;
            
            // Finding the required largest power of 2
            while(n >= (d << (count+1))) {
                count++;
            }
            
            // Updating the answer & dividend
            ans += (1 << count);
            n -= d*(1 << count);
        }
        
        // Handling overflowing condition
        if(ans > Integer.MAX_VALUE && isPositive) 
            return Integer.MAX_VALUE;
        if(ans > Integer.MAX_VALUE && !isPositive)
            return Integer.MIN_VALUE;
        
        // Returning the quotient with proper sign
        return isPositive ? ans : -1*ans;
    }

    /**
     * Find the single number that appears once in an array where all others appear twice
     */
    public int singleNumber(int[] nums) {
        // Variable to store XOR of all numbers in array
        int XOR = 0;
        
        // Iterate on the array to find XOR of all elements
        for (int i = 0; i < nums.length; i++) {
            XOR ^= nums[i];    
        }
        
        // XOR stores the required answer
        return XOR;        
    }

    /**
     * Find the single number that appears once in an array where all others appear three times
     */
    public int singleNumberII(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i] & ~twos);
            twos = (twos ^ nums[i] & ~ones);
        }
        return ones;
    }

    /**
     * Find two single numbers that appear once in an array where all others appear twice
     */
    public int[] singleNumberIII(int[] nums) {
        // Variable to store size of array
        int n = nums.length;
        
        // Variable to store XOR of all elements
        long XOR = 0;
        
        // Traverse the array
        for(int i=0; i < n; i++) {
            // Update the XOR
            XOR = XOR ^ nums[i];
        }
        
        // Variable to get the rightmost set bit in overall XOR
        int rightmost = (int)(XOR & (XOR - 1)) ^ (int)XOR;
        
        // Variables to stores XOR of elements in bucket 1 and 2
        int XOR1 = 0, XOR2 = 0;
        
        // Traverse the array
        for(int i=0; i < n; i++) {
            // Divide the numbers among bucket 1 and 2 based on rightmost set bit
            if((nums[i] & rightmost) != 0) {
                XOR1 = XOR1 ^ nums[i];
            }
            else {
                XOR2 = XOR2 ^ nums[i];
            }
        }
        
        // Return the result in sorted order
        if(XOR1 < XOR2) return new int[]{XOR1, XOR2};
        return new int[]{XOR2, XOR1};
    }

    /**
     * Generate all possible subsets (power set) of an array
     */
    public List<List<Integer>> powerSet(int[] nums) {
        // Variable to store size of array
        int n = nums.length;
        
        // To store the answer
        List<List<Integer>> ans = new ArrayList<>();
        
        // Variable to store the count of total subsets
        int count = (1 << n);
        
        // Traverse for every value
        for (int val = 0; val < count; val++) {
            
            // To store the current subset
            List<Integer> subset = new ArrayList<>();
            
            // Traverse on n bits
            for (int i = 0; i < n; i++) {
                if ((val & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            
            // Add the current subset to final answer
            ans.add(subset);
        }
        
        // Return stored answer
        return ans;
    }

    /**
     * Find XOR of numbers from L to R
     */
    public int findRangeXOR(int l, int r) {
        return XORtillN(l - 1) ^ XORtillN(r);
    }

    /**
     * Helper method to find XOR of numbers from 1 to n
     */
    private int XORtillN(int n) {
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n + 1;
        if(n % 4 == 3) return 0;
        return n;
    }

    /**
     * Find minimum number of bit flips to convert start to goal
     */
    public int minBitsFlip(int start, int goal) {
        // Variable to store bits that are different in both numbers
        int num = start ^ goal;
        
        // Variable to count number of set bits
        int count = 0;

        for (int i = 0; i < 32; i++) {
            // Update count if the rightmost bit is set
            count += (num & 1); 
            
            // Shift the number every time by 1 place
            num = num >> 1;
        }
        return count;
    }
} 