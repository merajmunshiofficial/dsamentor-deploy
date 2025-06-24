package com.example.dsa.recursion;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RecursionService {
    public boolean checkSubsequenceSum(int[] nums, int target) {
        return solve(0, nums.length, nums, target);
    }

    private boolean solve(int i, int n, int[] arr, int k) {
        if (k == 0) return true;
        if (k < 0) return false;
        if (i == n) return k == 0;
        return solve(i + 1, n, arr, k - arr[i]) || solve(i + 1, n, arr, k);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        func(candidates, candidates.length - 1, target, new ArrayList<>(), ans);
        return ans;
    }

    private void func(int[] v, int i, int sum, List<Integer> v2, List<List<Integer>> ans) {
        if (sum == 0) {
            ans.add(new ArrayList<>(v2));
            return;
        }
        if (sum < 0 || i < 0) {
            return;
        }
        func(v, i - 1, sum, v2, ans);
        v2.add(v[i]);
        func(v, i, sum - v[i], v2, ans);
        v2.remove(v2.size() - 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        func2(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private void func2(int[] v, int i, int sum, List<Integer> v2, List<List<Integer>> ans) {
        if (sum == 0) {
            ans.add(new ArrayList<>(v2));
            return;
        }
        if (sum < 0 || i >= v.length) {
            return;
        }
        for (int j = i; j < v.length; j++) {
            if (j > i && v[j] == v[j - 1]) {
                continue;
            }
            v2.add(v[j]);
            func2(v, j + 1, sum - v[j], v2, ans);
            v2.remove(v2.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        func3(n, 1, new ArrayList<>(), k, ans);
        return ans;
    }

    private void func3(int sum, int last, List<Integer> nums, int k, List<List<Integer>> ans) {
        if (sum == 0 && nums.size() == k) {
            ans.add(new ArrayList<>(nums));
            return;
        }
        if (sum <= 0 || nums.size() > k) return;

        for (int i = last; i <= 9; i++) {
            if (i <= sum) {
                nums.add(i);
                func3(sum - i, i + 1, nums, k, ans);
                nums.remove(nums.size() - 1);
            } else {
                break;
            }
        }
    }

    public int countSubsequenceWithTargetSum(int[] nums, int target) {
        return func4(0, target, nums);
    }

    private int func4(int ind, int sum, int[] nums) {
        if (ind == nums.length) {
            if (sum == 0) return 1;
            else return 0;
        }
        return func4(ind + 1, sum - nums[ind], nums) + func4(ind + 1, sum, nums);
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (func5(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean func5(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(k) != board[i][j]) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean ans = func5(board, i + 1, j, word, k + 1) ||
                      func5(board, i - 1, j, word, k + 1) ||
                      func5(board, i, j + 1, word, k + 1) ||
                      func5(board, i, j - 1, word, k + 1);

        board[i][j] = temp;
        return ans;
    }

    public List<String> findPath(int[][] grid) {
        int n = grid.length;
        List<String> result = new ArrayList<>();
        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0) {
            return result;
        }
        path(grid, 0, 0, "", n, result);
        Collections.sort(result);
        return result;
    }

    private void path(int[][] m, int x, int y, String dir, int n, List<String> result) {
        if (x == n - 1 && y == n - 1) {
            result.add(dir);
            return;
        }
        if (m[x][y] == 0) return;
        
        m[x][y] = 0;
        
        if (x < n - 1) path(m, x + 1, y, dir + 'D', n, result);
        if (y < n - 1) path(m, x, y + 1, dir + 'R', n, result);
        if (x > 0) path(m, x - 1, y, dir + 'U', n, result);
        if (y > 0) path(m, x, y - 1, dir + 'L', n, result);
        
        m[x][y] = 1;
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }

    private void generate(int open, int close, int n, String current, List<String> result) {
        if (open == close && open + close == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) {
            generate(open + 1, close, n, current + '(', result);
        }
        if (close < open) {
            generate(open, close + 1, n, current + ')', result);
        }
    }

    public boolean graphColoring(int[][] edges, int m, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] colors = new int[n];
        return solve6(0, m, n, colors, adj);
    }

    private boolean solve6(int node, int m, int n, int[] colors, List<List<Integer>> adj) {
        if (n == node) return true;
        for (int i = 1; i <= m; i++) {
            if (isSafe(i, node, colors, adj)) {
                colors[node] = i;
                if (solve6(node + 1, m, n, colors, adj)) return true;
                colors[node] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int col, int node, int[] colors, List<List<Integer>> adj) {
        for (int neighbor : adj.get(node)) {
            if (colors[neighbor] == col) return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, path, res);
        return res;
    }

    private void dfs(int index, String s, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                dfs(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        helper(digits, ans, 0, "");
        return ans;
    }

    private void helper(String digits, List<String> ans, int index, String current) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }
        String s = map[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            helper(digits, ans, index + 1, current + s.charAt(i));
        }
    }

    private final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / power(x, -1L * n);
        }
        return power(x, n);
    }

    private double power(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n % 2 == 0) {
            return power(x * x, n / 2);
        }
        return x * power(x, n - 1);
    }

    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, nums.length, nums, current, ans);
        return ans;
    }

    private void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        if (index == n) {
            ans.add(new ArrayList<>(current));
            return;
        }
        backtrack(index + 1, n, nums, current, ans);
        current.add(nums[index]);
        backtrack(index + 1, n, nums, current, ans);
        current.remove(current.size() - 1);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueensHelper(0, board, result);
        return result;
    }

    private void solveNQueensHelper(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] rowArray : board) {
                solution.add(new String(rowArray));
            }
            result.add(solution);
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (isNQueensSafe(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueensHelper(row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean isNQueensSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }

    public char[][] solveSudoku(char[][] board) {
        solve(board);
        return board;
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isSudokuSafe(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSudokuSafe(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;
            if (board[row][i] == c)
                return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void subsetsWithDupHelper(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            subsetsWithDupHelper(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        func(0, 0, nums, ans);
        return ans;
    }

    private void func(int ind, int sum, int[] nums, List<Integer> ans) {
        if (ind == nums.length) {
            ans.add(sum);
            return;
        }
        func(ind + 1, sum + nums[ind], nums, ans);
        func(ind + 1, sum, nums, ans);
    }
} 