package com.example.dsa.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/string")
@Tag(name = "String Algorithms", description = "Endpoints for classic string problems and pattern matching algorithms.")
public class StringController {
    private final StringService stringService;

    @Autowired
    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @PostMapping({"/countAndSay", "/count-and-say"})
    @Operation(summary = "Count and Say Sequence", description = "Generate the n-th term of the count-and-say sequence.")
    public StringResponse countAndSay(@Valid @RequestBody StringRequest.CountAndSayInput req) {
        String result = stringService.countAndSay(req.getN());
        return StringResponse.builder().resultString(result).build();
    }

    @PostMapping({"/countRev", "/count-rev"})
    @Operation(summary = "Minimum Parenthesis Reversals", description = "Find the minimum number of reversals to balance a parenthesis string.")
    public StringResponse countRev(@Valid @RequestBody StringRequest.CountRevInput req) {
        int result = stringService.countRev(req.getS());
        return StringResponse.builder().resultInt(result).build();
    }

    @PostMapping({"/reverseWords", "/reverse-words"})
    @Operation(summary = "Reverse Words in String", description = "Reverse the order of words in a string, trimming spaces.")
    public StringResponse reverseWords(@Valid @RequestBody StringRequest.ReverseWordsInput req) {
        String result = stringService.reverseWords(req.getS());
        return StringResponse.builder().resultString(result).build();
    }

    @PostMapping({"/kmpSearch", "/kmp-search"})
    @Operation(summary = "KMP Pattern Search", description = "Find all indices of a pattern in text using the KMP algorithm.")
    public StringResponse kmpSearch(@Valid @RequestBody StringRequest.KmpSearchInput req) {
        var result = stringService.kmpSearch(req.getPattern(), req.getText());
        return StringResponse.builder().resultList(result).build();
    }

    @PostMapping({"/rabinKarpSearch", "/rabin-karp-search"})
    @Operation(summary = "Rabin-Karp Pattern Search", description = "Find all indices of a pattern in text using the Rabin-Karp algorithm.")
    public StringResponse rabinKarpSearch(@Valid @RequestBody StringRequest.RabinKarpInput req) {
        var result = stringService.rabinKarpSearch(req.getPattern(), req.getText());
        return StringResponse.builder().resultList(result).build();
    }

    @PostMapping({"/zAlgorithmSearch", "/z-algorithm-search"})
    @Operation(summary = "Z-Algorithm Pattern Search", description = "Find all indices of a pattern in text using the Z-algorithm.")
    public StringResponse zAlgorithmSearch(@Valid @RequestBody StringRequest.ZAlgorithmInput req) {
        var result = stringService.zAlgorithmSearch(req.getText(), req.getPattern());
        return StringResponse.builder().resultList(result).build();
    }

    @PostMapping({"/longestHappyPrefix", "/longest-happy-prefix"})
    @Operation(summary = "Longest Happy Prefix", description = "Find the longest happy prefix (LPS) of a string.")
    public StringResponse longestHappyPrefix(@Valid @RequestBody StringRequest.LongestHappyPrefixInput req) {
        String result = stringService.longestHappyPrefix(req.getS());
        return StringResponse.builder().resultString(result).build();
    }

    @PostMapping({"/shortestPalindrome", "/shortest-palindrome"})
    @Operation(summary = "Shortest Palindrome by Prepending", description = "Find the shortest palindrome by prepending characters to the string.")
    public StringResponse shortestPalindrome(@Valid @RequestBody StringRequest.ShortestPalindromeInput req) {
        String result = stringService.shortestPalindrome(req.getS());
        return StringResponse.builder().resultString(result).build();
    }
}