package com.example.dsa.binarytree;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class BinaryTreeRequest {
    public static class TreeNodeInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
    }

    public static class TwoTreeInput {
        @NotNull
        @Schema(description = "First binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO p;
        @NotNull
        @Schema(description = "Second binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO q;
        public BinaryTreeResponse.TreeNodeDTO getP() { return p; }
        public void setP(BinaryTreeResponse.TreeNodeDTO p) { this.p = p; }
        public BinaryTreeResponse.TreeNodeDTO getQ() { return q; }
        public void setQ(BinaryTreeResponse.TreeNodeDTO q) { this.q = q; }
    }

    public static class LCAInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 3, \"left\": {\"data\": 5}, \"right\": {\"data\": 1}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "First node value", example = "5")
        private Integer p;
        @NotNull
        @Schema(description = "Second node value", example = "1")
        private Integer q;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getP() { return p; }
        public void setP(Integer p) { this.p = p; }
        public Integer getQ() { return q; }
        public void setQ(Integer q) { this.q = q; }
    }

    public static class BuildTreeInput {
        @NotNull
        @Schema(description = "Inorder traversal array", example = "[9,3,15,20,7]")
        private int[] inorder;
        @NotNull
        @Schema(description = "Postorder traversal array", example = "[9,15,7,20,3]")
        private int[] postorder;
        public int[] getInorder() { return inorder; }
        public void setInorder(int[] inorder) { this.inorder = inorder; }
        public int[] getPostorder() { return postorder; }
        public void setPostorder(int[] postorder) { this.postorder = postorder; }
    }

    public static class BoundaryTraversalInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
    }

    public static class BottomViewInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
    }

    public static class TopViewInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
    }

    public static class DistanceKInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 3, \"left\": {\"data\": 5}, \"right\": {\"data\": 1}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "Target node value", example = "5")
        private Integer target;
        @NotNull
        @Schema(description = "Distance k", example = "2")
        private Integer k;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getTarget() { return target; }
        public void setTarget(Integer target) { this.target = target; }
        public Integer getK() { return k; }
        public void setK(Integer k) { this.k = k; }
    }

    public static class SerializeInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
    }

    public static class DeserializeInput {
        @NotNull
        @Schema(description = "Serialized tree string", example = "1,2,3")
        private String data;
        public String getData() { return data; }
        public void setData(String data) { this.data = data; }
    }

    public static class TimeToBurnTreeInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        @NotNull
        @Schema(description = "Target node value to start burning from", example = "2")
        private Integer target;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
        public Integer getTarget() { return target; }
        public void setTarget(Integer target) { this.target = target; }
    }

    public static class WidthOfBinaryTreeInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 1, \"left\": {\"data\": 3}, \"right\": {\"data\": 2}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
    }

    public static class UniqueBinaryTreesInput {
        @NotNull
        @Schema(description = "Number of nodes", example = "3")
        private Integer n;
        public Integer getN() { return n; }
        public void setN(Integer n) { this.n = n; }
    }

    public static class TreeTraversalInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
    }

    public static class RecursiveInorderInput {
        @NotNull
        @Schema(description = "Root of the binary tree", example = "{\"data\": 1, \"left\": {\"data\": 2}, \"right\": {\"data\": 3}}")
        private BinaryTreeResponse.TreeNodeDTO root;
        public BinaryTreeResponse.TreeNodeDTO getRoot() { return root; }
        public void setRoot(BinaryTreeResponse.TreeNodeDTO root) { this.root = root; }
    }
} 