package com.example.dsa.string;

import org.springframework.stereotype.Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.*;

@Service
@Tag(name = "String Algorithms Service", description = "Service layer for classic string problems and pattern matching algorithms.")
public class StringService {
    // 1. Count and Say
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        int len = prev.length();
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) count++;
            else {
                ans.append(count).append(prev.charAt(i - 1));
                count = 1;
            }
        }
        ans.append(count).append(prev.charAt(len - 1));
        return ans.toString();
    }

    // 2. Parenthesis Balancer
    public int countRev(String s) {
        int n = s.length();
        if (n % 2 != 0) return -1;
        int open = 0, close = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') open++;
            else {
                if (open > 0) open--;
                else close++;
            }
        }
        return (open / 2) + (open % 2) + (close / 2) + (close % 2);
    }

    // 3. Reverse Words in String
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        int i = 0, j = 0, start, end;
        while (j < n) {
            while (j < n && sb.charAt(j) == ' ') j++;
            if (j == n) break;
            start = i;
            while (j < n && sb.charAt(j) != ' ') {
                if (i < sb.length()) sb.setCharAt(i++, sb.charAt(j++));
                else { sb.append(sb.charAt(j++)); i++; }
            }
            end = i - 1;
            reverseString(sb, start, end);
            if (j < n) {
                if (i < sb.length()) sb.setCharAt(i++, ' ');
                else { sb.append(' '); i++; }
            }
        }
        if (i > 0 && sb.charAt(i - 1) == ' ') i--;
        return sb.substring(0, i);
    }
    private void reverseString(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++; end--;
        }
    }

    // 4. KMP Search
    public List<Integer> kmpSearch(String pattern, String text) {
        String s = pattern + '$' + text;
        int[] lps = computeLPS(s);
        int n = text.length(), m = pattern.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = m + 1; i < s.length(); i++) {
            if (lps[i] == m) ans.add(i - 2 * m);
        }
        return ans;
    }
    private int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1; i++; j++;
            } else {
                while (j > 0 && s.charAt(i) != s.charAt(j)) j = lps[j - 1];
                if (s.charAt(i) == s.charAt(j)) { lps[i] = j + 1; j++; }
                i++;
            }
        }
        return lps;
    }

    // 5. Rabin-Karp Search (naive, as in original)
    public List<Integer> rabinKarpSearch(String pattern, String text) {
        int n = pattern.length(), m = text.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= m - n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) { flag = false; break; }
            }
            if (flag) ans.add(i);
        }
        return ans;
    }

    // 6. Z-Algorithm Search
    public List<Integer> zAlgorithmSearch(String text, String pattern) {
        String s = pattern + '$' + text;
        int[] z = computeZarray(s);
        int n = text.length(), m = pattern.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = m + 1; i < s.length(); i++) {
            if (z[i] == m) ans.add(i - (m + 1));
        }
        return ans;
    }
    private int[] computeZarray(String s) {
        int n = s.length();
        int[] z = new int[n];
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            if (i > right) {
                while (i + z[i] < n && s.charAt(i + z[i]) == s.charAt(z[i])) z[i]++;
                left = i; right = i + z[i] - 1;
            } else {
                if (i + z[i - left] <= right) z[i] = z[i - left];
                else {
                    z[i] = right - i + 1;
                    while (i + z[i] < n && s.charAt(i + z[i]) == s.charAt(z[i])) z[i]++;
                    left = i; right = i + z[i] - 1;
                }
            }
        }
        return z;
    }

    // 7. Longest Happy Prefix
    public String longestHappyPrefix(String s) {
        int[] lps = computeLPS(s);
        return s.substring(0, lps[s.length() - 1]);
    }

    // 8. Shortest Palindrome by Prepending
    public String shortestPalindrome(String s) {
        StringBuilder revs = new StringBuilder(s).reverse();
        String str = s + "$" + revs;
        int[] lps = computeLPS(str);
        int ans = s.length() - lps[lps.length - 1];
        String toAdd = revs.substring(0, ans);
        return toAdd + s;
    }
} 