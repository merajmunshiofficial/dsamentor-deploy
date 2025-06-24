package com.example.dsa.tries;

import org.springframework.stereotype.Service;

@Service
public class TriesService {
    // For countDistinct
    static class Node26 {
        Node26[] links = new Node26[26];
        boolean containsKey(char ch) { return links[ch - 'a'] != null; }
        void put(char ch, Node26 node) { links[ch - 'a'] = node; }
        Node26 get(char ch) { return links[ch - 'a']; }
    }

    public int countDistinct(String s) {
        int c = 0;
        Node26 root = new Node26();
        for (int i = 0; i < s.length(); i++) {
            Node26 node = root;
            for (int j = i; j < s.length(); j++) {
                if (!node.containsKey(s.charAt(j))) {
                    c++;
                    node.put(s.charAt(j), new Node26());
                }
                node = node.get(s.charAt(j));
            }
        }
        return c + 1;
    }

    // For findMaximumXOR
    static class Node2 {
        Node2[] links = new Node2[2];
        boolean containsKey(int bit) { return links[bit] != null; }
        Node2 get(int bit) { return links[bit]; }
        void put(int bit, Node2 node) { links[bit] = node; }
    }
    static class Trie {
        private Node2 root;
        Trie() { root = new Node2(); }
        void insert(int num) {
            Node2 node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node2());
                }
                node = node.get(bit);
            }
        }
        int getMax(int num) {
            Node2 node = root;
            int maxNum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    maxNum |= (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            return maxNum;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) trie.insert(num);
        int maxi = 0;
        for (int num : nums) {
            maxi = Math.max(maxi, trie.getMax(num));
        }
        return maxi;
    }
} 