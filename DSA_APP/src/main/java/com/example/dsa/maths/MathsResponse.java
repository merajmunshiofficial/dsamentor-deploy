package com.example.dsa.maths;
import java.util.List;

public class MathsResponse {
    private List<List<Integer>> primeFactors;
    private List<Integer> primesTillN;
    private List<Integer> primesInRangeCount;
    public MathsResponse() {}
    public MathsResponse(List<List<Integer>> primeFactors) { this.primeFactors = primeFactors; }
    public List<List<Integer>> getPrimeFactors() { return primeFactors; }
    public void setPrimeFactors(List<List<Integer>> primeFactors) { this.primeFactors = primeFactors; }
    public List<Integer> getPrimesTillN() { return primesTillN; }
    public void setPrimesTillN(List<Integer> primesTillN) { this.primesTillN = primesTillN; }
    public List<Integer> getPrimesInRangeCount() { return primesInRangeCount; }
    public void setPrimesInRangeCount(List<Integer> primesInRangeCount) { this.primesInRangeCount = primesInRangeCount; }
} 