package com.example.dsa.binarysearchtree;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class BSTRequest {
    public static class BstFromPreorderInput {
        @NotNull
        @Schema(description = "Preorder traversal list", example = "[8,5,1,7,10,12]")
        private List<Integer> preorder;
        public List<Integer> getPreorder() { return preorder; }
        public void setPreorder(List<Integer> preorder) { this.preorder = preorder; }
    }

    public static class DeleteNodeInput {
        @NotNull
        @Schema(description = "Root of the BST", example = "{\"data\": 5, \"left\": {\"data\": 3}, \"right\": {\"data\": 8}}")
        private BSTResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "Key to delete", example = "3")
        private Integer key;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getKey() { return key; }
        public void setKey(Integer key) { this.key = key; }
    }

    public static class FloorCeilInput {
        @NotNull
        @Schema(description = "Root of the BST", example = "{\"data\": 8, \"left\": {\"data\": 4}, \"right\": {\"data\": 12}}")
        private BSTResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "Key to find floor and ceil for", example = "11")
        private Integer key;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getKey() { return key; }
        public void setKey(Integer key) { this.key = key; }
    }

    public static class InsertIntoBSTInput {
        @NotNull
        @Schema(description = "Root of the BST", example = "{\"data\": 4, \"left\": {\"data\": 2}, \"right\": {\"data\": 7}}")
        private BSTResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "Value to insert", example = "5")
        private Integer val;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getVal() { return val; }
        public void setVal(Integer val) { this.val = val; }
    }

    public static class IsBSTInput {
        @NotNull
        @Schema(description = "Root of the binary tree to check", example = "{\"data\": 7, \"left\": {\"data\": 5}, \"right\": {\"data\": 10}}")
        private BSTResponse.TreeNodeDTO root;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
    }

    public static class KthSmallestLargestInput {
        @NotNull
        @Schema(description = "Root of the BST", example = "{\"data\": 3, \"left\": {\"data\": 1}, \"right\": {\"data\": 4}}")
        private BSTResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "K value for k-th smallest and largest", example = "1")
        private Integer k;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getK() { return k; }
        public void setK(Integer k) { this.k = k; }
    }

    public static class LargestBSTInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 2, \"left\": {\"data\": 1}, \"right\": {\"data\": 3}}")
        private BSTResponse.TreeNodeDTO root;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
    }

    public static class SearchBSTInput {
        @NotNull
        @Schema(description = "Root of the BST", example = "{\"data\": 4, \"left\": {\"data\": 2}, \"right\": {\"data\": 7}}")
        private BSTResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "Value to search for", example = "2")
        private Integer val;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getVal() { return val; }
        public void setVal(Integer val) { this.val = val; }
    }

    public static class SuccPredBSTInput {
        @NotNull
        @Schema(description = "Root of the BST", example = "{\"data\": 5, \"left\": {\"data\": 2}, \"right\": {\"data\": 10}}")
        private BSTResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "Key to find predecessor and successor for", example = "10")
        private Integer key;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getKey() { return key; }
        public void setKey(Integer key) { this.key = key; }
    }

    public static class TwoSumBSTInput {
        @NotNull
        @Schema(description = "Root of the BST", example = "{\"data\": 5, \"left\": {\"data\": 3}, \"right\": {\"data\": 6}}")
        private BSTResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "Target sum to find", example = "9")
        private Integer k;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getK() { return k; }
        public void setK(Integer k) { this.k = k; }
    }

    public static class LCAInput {
        @NotNull
        @Schema(description = "Root of the BST", example = "{\"data\": 3, \"left\": {\"data\": 5}, \"right\": {\"data\": 1}}")
        private BSTResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "First node value", example = "5")
        private Integer p;
        @NotNull
        @Schema(description = "Second node value", example = "1")
        private Integer q;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getP() { return p; }
        public void setP(Integer p) { this.p = p; }
        public Integer getQ() { return q; }
        public void setQ(Integer q) { this.q = q; }
    }

    public static class RecoverTreeInput {
        @NotNull
        @Schema(description = "Root of the BST with swapped nodes", example = "{\"data\": 1, \"left\": {\"data\": 3, \"right\": {\"data\": 2}}}")
        private BSTResponse.TreeNodeDTO root;
        public BSTResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BSTResponse.TreeNodeDTO root) { this.root = root; }
    }
} 