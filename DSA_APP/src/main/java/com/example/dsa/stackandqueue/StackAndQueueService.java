package com.example.dsa.stackandqueue;

import org.springframework.stereotype.Service;
import java.util.*;
import com.fasterxml.jackson.databind.*;

@Service
public class StackAndQueueService {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> st = new ArrayList<>();
        for (int a : asteroids) {
            if (a > 0) {
                st.add(a);
            } else {
                while (!st.isEmpty() && st.get(st.size() - 1) > 0 && st.get(st.size() - 1) < Math.abs(a)) {
                    st.remove(st.size() - 1);
                }
                if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(a)) {
                    st.remove(st.size() - 1);
                } else if (st.isEmpty() || st.get(st.size() - 1) < 0) {
                    st.add(a);
                }
            }
        }
        int[] result = new int[st.size()];
        for (int i = 0; i < st.size(); i++) result[i] = st.get(i);
        return result;
    }

    public int celebrity(int[][] M, int n) {
        int top = 0, down = n - 1;
        while (top < down) {
            if (M[top][down] == 1) {
                top++;
            } else if (M[down][top] == 1) {
                down--;
            } else {
                top++;
                down--;
            }
        }
        if (top > down) return -1;
        for (int i = 0; i < n; i++) {
            if (i == top) continue;
            if (M[top][i] == 1 && M[i][top] == 0) return -1;
        }
        return top;
    }

    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char ch = st.pop();
                if (!isMatched(ch, c)) return false;
            }
        }
        return st.isEmpty();
    }
    private boolean isMatched(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int largestArea = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int ind = st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                int nse = i;
                int area = heights[ind] * (nse - pse - 1);
                largestArea = Math.max(largestArea, area);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int nse = n;
            int ind = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            int area = heights[ind] * (nse - pse - 1);
            largestArea = Math.max(largestArea, area);
        }
        return largestArea;
    }

    public String lfuCache(StackAndQueueRequest.LFUCacheInput request) {
        // Simulate LFUCache operations from a JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> ops = mapper.readValue(request.getOperations(), List.class);
            LFUCacheSim cache = new LFUCacheSim(2); // Default capacity 2, can be extended
            List<String> results = new ArrayList<>();
            for (Map<String, Object> op : ops) {
                String type = (String) op.get("op");
                if ("put".equals(type)) {
                    cache.put((Integer) op.get("key"), (Integer) op.get("value"));
                    results.add("null");
                } else if ("get".equals(type)) {
                    results.add(String.valueOf(cache.get((Integer) op.get("key"))));
                }
            }
            return results.toString();
        } catch (Exception e) {
            return "Invalid operations format: " + e.getMessage();
        }
    }
    // Simple LFUCache simulation for REST
    static class LFUCacheSim {
        private Map<Integer, Node> keyNode;
        private Map<Integer, List> freqListMap;
        private int maxSizeCache;
        private int minFreq;
        private int curSize;
        public LFUCacheSim(int capacity) {
            maxSizeCache = capacity;
            minFreq = 0;
            curSize = 0;
            keyNode = new HashMap<>();
            freqListMap = new HashMap<>();
        }
        private void updateFreqListMap(Node node) {
            keyNode.remove(node.key);
            freqListMap.get(node.cnt).removeNode(node);
            if (node.cnt == minFreq && freqListMap.get(node.cnt).size == 0) {
                minFreq++;
            }
            List nextHigherFreqList = freqListMap.getOrDefault(node.cnt + 1, new List());
            node.cnt += 1;
            nextHigherFreqList.addFront(node);
            freqListMap.put(node.cnt, nextHigherFreqList);
            keyNode.put(node.key, node);
        }
        public int get(int key) {
            if (keyNode.containsKey(key)) {
                Node node = keyNode.get(key);
                int val = node.value;
                updateFreqListMap(node);
                return val;
            }
            return -1;
        }
        public void put(int key, int value) {
            if (maxSizeCache == 0) return;
            if (keyNode.containsKey(key)) {
                Node node = keyNode.get(key);
                node.value = value;
                updateFreqListMap(node);
            } else {
                if (curSize == maxSizeCache) {
                    List list = freqListMap.get(minFreq);
                    keyNode.remove(list.tail.prev.key);
                    freqListMap.get(minFreq).removeNode(list.tail.prev);
                    curSize--;
                }
                curSize++;
                minFreq = 1;
                List listFreq = freqListMap.getOrDefault(minFreq, new List());
                Node node = new Node(key, value);
                listFreq.addFront(node);
                keyNode.put(key, node);
                freqListMap.put(minFreq, listFreq);
            }
        }
        static class Node {
            int key, value, cnt;
            Node next, prev;
            Node(int _key, int _value) { key = _key; value = _value; cnt = 1; }
        }
        static class List {
            int size;
            Node head, tail;
            List() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }
            void addFront(Node node) {
                Node temp = head.next;
                node.next = temp;
                node.prev = head;
                head.next = node;
                temp.prev = node;
                size++;
            }
            void removeNode(Node delnode) {
                Node prevNode = delnode.prev;
                Node nextNode = delnode.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                size--;
            }
        }
    }

    public int[] stockSpan(int[] prices) {
        int n = prices.length;
        int[] PGE = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }
            PGE[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i - PGE[i];
        }
        return ans;
    }

    public long subArrayRanges(int[] arr) {
        return sumSubarrayMaxs(arr) - sumSubarrayMins(arr);
    }
    public long sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = left * (long) right;
            long val = freq * arr[i];
            sum += val;
        }
        return sum;
    }
    private long sumSubarrayMaxs(int[] arr) {
        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;
            long freq = left * (long) right;
            long val = freq * arr[i];
            sum += val;
        }
        return sum;
    }
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }
    private int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }
    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }
    private int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    public int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (leftMax > height[left]) {
                    total += leftMax - height[left];
                } else leftMax = height[left];
                left++;
            } else {
                if (rightMax > height[right]) {
                    total += rightMax - height[right];
                } else rightMax = height[right];
                right--;
            }
        }
        return total;
    }
} 