package com.example.dsa.maths;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MathsService {
    private static final int MAX_N = 100000;
    private int[] SPF = new int[MAX_N + 1];
    private boolean sieveDone = false;

    private void sieve() {
        if (sieveDone) return;
        Arrays.fill(SPF, 1);
        for (int i = 2; i <= MAX_N; i++) {
            if (SPF[i] == 1) {
                for (int j = i; j <= MAX_N; j += i) {
                    if (SPF[j] == 1) {
                        SPF[j] = i;
                    }
                }
            }
        }
        sieveDone = true;
    }

    private List<Integer> primeFact(int n) {
        List<Integer> ans = new ArrayList<>();
        while (n != 1) {
            ans.add(SPF[n]);
            n = n / SPF[n];
        }
        return ans;
    }

    public List<List<Integer>> primeFactors(List<Integer> numbers) {
        sieve();
        List<List<Integer>> ans = new ArrayList<>();
        for (int n : numbers) {
            ans.add(primeFact(n));
        }
        return ans;
    }

    public List<Integer> primeTillN(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        List<Integer> ans = new ArrayList<>();
        for (long i = 2; i <= n; i++) {
            if (isPrime[(int) i]) {
                ans.add((int) i);
                for (long val = i * i; val <= n; val += i) {
                    isPrime[(int) val] = false;
                }
            }
        }
        return ans;
    }

    public List<Integer> primesInRange(List<int[]> ranges) {
        if (ranges == null || ranges.isEmpty()) {
            return new ArrayList<>();
        }
        int maxVal = 0;
        for (int[] query : ranges) {
            maxVal = Math.max(maxVal, query[1]);
        }
        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= maxVal; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxVal; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int[] primeCount = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            primeCount[i] = primeCount[i - 1];
            if (isPrime[i]) {
                primeCount[i]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int[] query : ranges) {
            int start = query[0];
            int end = query[1];
            if (start == 0) {
                result.add(primeCount[end]);
            } else {
                result.add(primeCount[end] - primeCount[start - 1]);
            }
        }
        return result;
    }
} 