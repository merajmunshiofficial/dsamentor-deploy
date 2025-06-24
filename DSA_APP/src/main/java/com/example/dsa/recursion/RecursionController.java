package com.example.dsa.recursion;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recursion")
@Tag(name = "Recursion", description = "DSA Recursion Problems")
public class RecursionController {
    private final RecursionService service;

    @Autowired
    public RecursionController(RecursionService service) {
        this.service = service;
    }

    @Operation(summary = "Check if any subsequence sums to target")
    @PostMapping("/check-subsequence-sum")
    public ResponseEntity<RecursionResponse> checkSubsequenceSum(@Validated @RequestBody RecursionRequest.CheckSubsequenceSumInput request) {
        return ResponseEntity.ok(new RecursionResponse(service.checkSubsequenceSum(request.getNums(), request.getTarget())));
    }

    @Operation(summary = "Find all unique combinations that sum to target")
    @PostMapping("/combination-sum")
    public ResponseEntity<RecursionResponse> combinationSum(@Validated @RequestBody RecursionRequest.CombinationSumInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setCombinations(service.combinationSum(request.getCandidates(), request.getTarget()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find all unique combinations that sum to target (with duplicates)")
    @PostMapping("/combination-sum-2")
    public ResponseEntity<RecursionResponse> combinationSum2(@Validated @RequestBody RecursionRequest.CombinationSum2Input request) {
        RecursionResponse response = new RecursionResponse();
        response.setCombinations(service.combinationSum2(request.getCandidates(), request.getTarget()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find all combinations of k numbers from 1-9 that sum to n")
    @PostMapping("/combination-sum-3")
    public ResponseEntity<RecursionResponse> combinationSum3(@Validated @RequestBody RecursionRequest.CombinationSum3Input request) {
        RecursionResponse response = new RecursionResponse();
        response.setCombinations(service.combinationSum3(request.getK(), request.getN()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Count subsequences that sum to target")
    @PostMapping("/count-subsequence-with-target-sum")
    public ResponseEntity<RecursionResponse> countSubsequenceWithTargetSum(@Validated @RequestBody RecursionRequest.CountSubsequenceWithTargetSumInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setCount(service.countSubsequenceWithTargetSum(request.getNums(), request.getTarget()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if word exists in 2D board")
    @PostMapping("/exist")
    public ResponseEntity<RecursionResponse> exist(@Validated @RequestBody RecursionRequest.ExistInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setWordExists(service.exist(request.getBoard(), request.getWord()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find all paths from top-left to bottom-right in grid")
    @PostMapping("/find-path")
    public ResponseEntity<RecursionResponse> findPath(@Validated @RequestBody RecursionRequest.FindPathInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setPaths(service.findPath(request.getGrid()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Generate all valid combinations of n pairs of parentheses")
    @PostMapping("/generate-parenthesis")
    public ResponseEntity<RecursionResponse> generateParenthesis(@Validated @RequestBody RecursionRequest.GenerateParenthesisInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setParentheses(service.generateParenthesis(request.getN()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if graph can be colored with m colors")
    @PostMapping("/graph-coloring")
    public ResponseEntity<RecursionResponse> graphColoring(@Validated @RequestBody RecursionRequest.GraphColoringInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setCanColor(service.graphColoring(request.getEdges(), request.getM(), request.getN()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find all palindrome partitions of a string")
    @PostMapping("/is-palindrome")
    public ResponseEntity<RecursionResponse> isPalindrome(@Validated @RequestBody RecursionRequest.IsPalindromeInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setPartitions(service.partition(request.getS()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Generate all letter combinations for a digit string")
    @PostMapping("/letter-combinations")
    public ResponseEntity<RecursionResponse> letterCombinations(@Validated @RequestBody RecursionRequest.LetterCombinationsInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setLetterCombinations(service.letterCombinations(request.getDigits()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Calculate x raised to the power n")
    @PostMapping("/my-pow")
    public ResponseEntity<RecursionResponse> myPow(@Validated @RequestBody RecursionRequest.MyPowInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setResult(service.myPow(request.getX(), request.getN()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Generate all possible subsets (power set)")
    @PostMapping("/power-set")
    public ResponseEntity<RecursionResponse> powerSet(@Validated @RequestBody RecursionRequest.PowerSetInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setPowerSet(service.powerSet(request.getNums()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Solve N-Queens problem")
    @PostMapping("/solve-n-queens")
    public ResponseEntity<RecursionResponse> solveNQueens(@Validated @RequestBody RecursionRequest.SolveNQueensInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setNQueensSolutions(service.solveNQueens(request.getN()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Solve Sudoku puzzle")
    @PostMapping("/solve-sudoku")
    public ResponseEntity<RecursionResponse> solveSudoku(@Validated @RequestBody RecursionRequest.SolveSudokuInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setSolvedBoard(service.solveSudoku(request.getBoard()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Generate all possible subsets (with duplicates)")
    @PostMapping("/subsets-with-dup")
    public ResponseEntity<RecursionResponse> subsetsWithDup(@Validated @RequestBody RecursionRequest.SubsetsWithDupInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setSubsetsWithDup(service.subsetsWithDup(request.getNums()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Generate all subset sums")
    @PostMapping("/subset-sums")
    public ResponseEntity<RecursionResponse> subsetSums(@Validated @RequestBody RecursionRequest.SubsetSumsInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setSubsetSums(service.subsetSums(request.getNums()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Palindrome partitioning of a string")
    @PostMapping("/partition")
    public ResponseEntity<RecursionResponse> partition(@Validated @RequestBody RecursionRequest.IsPalindromeInput request) {
        RecursionResponse response = new RecursionResponse();
        response.setPartitions(service.partition(request.getS()));
        return ResponseEntity.ok(response);
    }
}