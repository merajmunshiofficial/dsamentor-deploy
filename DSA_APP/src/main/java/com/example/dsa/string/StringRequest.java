package com.example.dsa.string;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class StringRequest {
    public static class CountAndSayInput {
        @NotNull
        @Schema(description = "n-th term to generate", example = "4")
        private Integer n;
        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
        @com.fasterxml.jackson.annotation.JsonProperty("N")
        public void setNUpper(Integer n) { this.n = n; }
        @com.fasterxml.jackson.annotation.JsonProperty("n")
        public void setNLower(Integer n) { this.n = n; }
    }

    public static class CountRevInput {
        @NotNull
        @Schema(description = "Parenthesis string", example = "(()))(")
        private String s;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
        @com.fasterxml.jackson.annotation.JsonProperty("S")
        public void setSUpper(String s) { this.s = s; }
        @com.fasterxml.jackson.annotation.JsonProperty("s")
        public void setSLower(String s) { this.s = s; }
    }

    public static class ReverseWordsInput {
        @NotNull
        @Schema(description = "Input string", example = "  hello world  ")
        private String s;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
        @com.fasterxml.jackson.annotation.JsonProperty("S")
        public void setSUpper(String s) { this.s = s; }
        @com.fasterxml.jackson.annotation.JsonProperty("s")
        public void setSLower(String s) { this.s = s; }
    }

    public static class KmpSearchInput {
        @NotNull
        @Schema(description = "Pattern to search", example = "abc")
        private String pattern;
        @NotNull
        @Schema(description = "Text to search in", example = "ababcabcababc")
        private String text;
        public String getPattern() { return pattern; }
        public void setPattern(String pattern) { this.pattern = pattern; }
        @com.fasterxml.jackson.annotation.JsonProperty("Pattern")
        public void setPatternUpper(String pattern) { this.pattern = pattern; }
        @com.fasterxml.jackson.annotation.JsonProperty("pattern")
        public void setPatternLower(String pattern) { this.pattern = pattern; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        @com.fasterxml.jackson.annotation.JsonProperty("Text")
        public void setTextUpper(String text) { this.text = text; }
        @com.fasterxml.jackson.annotation.JsonProperty("text")
        public void setTextLower(String text) { this.text = text; }
    }

    public static class RabinKarpInput {
        @NotNull
        @Schema(description = "Pattern to search", example = "abc")
        private String pattern;
        @NotNull
        @Schema(description = "Text to search in", example = "ababcabcababc")
        private String text;
        public String getPattern() { return pattern; }
        public void setPattern(String pattern) { this.pattern = pattern; }
        @com.fasterxml.jackson.annotation.JsonProperty("Pattern")
        public void setPatternUpper(String pattern) { this.pattern = pattern; }
        @com.fasterxml.jackson.annotation.JsonProperty("pattern")
        public void setPatternLower(String pattern) { this.pattern = pattern; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        @com.fasterxml.jackson.annotation.JsonProperty("Text")
        public void setTextUpper(String text) { this.text = text; }
        @com.fasterxml.jackson.annotation.JsonProperty("text")
        public void setTextLower(String text) { this.text = text; }
    }

    public static class ZAlgorithmInput {
        @NotNull
        @Schema(description = "Pattern to search", example = "xyz")
        private String pattern;
        @NotNull
        @Schema(description = "Text to search in", example = "xyzabxyzabxyz")
        private String text;
        public String getPattern() { return pattern; }
        public void setPattern(String pattern) { this.pattern = pattern; }
        @com.fasterxml.jackson.annotation.JsonProperty("Pattern")
        public void setPatternUpper(String pattern) { this.pattern = pattern; }
        @com.fasterxml.jackson.annotation.JsonProperty("pattern")
        public void setPatternLower(String pattern) { this.pattern = pattern; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        @com.fasterxml.jackson.annotation.JsonProperty("Text")
        public void setTextUpper(String text) { this.text = text; }
        @com.fasterxml.jackson.annotation.JsonProperty("text")
        public void setTextLower(String text) { this.text = text; }
    }

    public static class LongestHappyPrefixInput {
        @NotNull
        @Schema(description = "Input string", example = "ababab")
        private String s;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
        @com.fasterxml.jackson.annotation.JsonProperty("S")
        public void setSUpper(String s) { this.s = s; }
        @com.fasterxml.jackson.annotation.JsonProperty("s")
        public void setSLower(String s) { this.s = s; }
    }

    public static class ShortestPalindromeInput {
        @NotNull
        @Schema(description = "Input string", example = "aacecaaa")
        private String s;
        public String getS() { return s; }
        public void setS(String s) { this.s = s; }
        @com.fasterxml.jackson.annotation.JsonProperty("S")
        public void setSUpper(String s) { this.s = s; }
        @com.fasterxml.jackson.annotation.JsonProperty("s")
        public void setSLower(String s) { this.s = s; }
    }
}