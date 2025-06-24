export const problemMetadata = {
  arrays: [
    {
      name: "Second Highest Occurrence",
      endpoint: "/api/arrays/second-highest-occurrence",
      methodName: "findSecondMostFrequentElement",
      serviceFile: "ArrayService.java",
      defaultInput: { nums: [1, 2, 2, 3, 3, 3] },
      description: "Find the second most frequent element in the array.",
      approach: "Use HashMap to count frequencies, then find max and second max.",
      code: `public int findSecondMostFrequentElement(int[] nums) { /* ... */ }`
    }
    // Add more problems as needed
  ],
  // Add more topics (e.g., dynamicprogramming, graph, etc.)
}; 