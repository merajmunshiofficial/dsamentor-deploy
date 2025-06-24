package com.example.dsa.maths;
import java.util.List;

public class MathsRequest {
    public static class PrimeFactorsInput {
        private List<Integer> numbers;
        public PrimeFactorsInput() {}
        public PrimeFactorsInput(List<Integer> numbers) { this.numbers = numbers; }
        public List<Integer> getNumbers() { return numbers; }
        public void setNumbers(List<Integer> numbers) { this.numbers = numbers; }
    }
    public static class PrimeTillNInput {
        private int n;
        public PrimeTillNInput() {}
        public PrimeTillNInput(int n) { this.n = n; }
        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
    }
    public static class PrimesInRangeInput {
        private List<int[]> ranges;
        public PrimesInRangeInput() {}
        public PrimesInRangeInput(List<int[]> ranges) { this.ranges = ranges; }
        public List<int[]> getRanges() { return ranges; }
        public void setRanges(List<int[]> ranges) { this.ranges = ranges; }
    }
} 