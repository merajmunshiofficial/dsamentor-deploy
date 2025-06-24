package com.example.dsa.binarysearchtree;

import java.util.List;

public class BSTResponse {
    public static class TreeNodeDTO {
        private int data;
        private TreeNodeDTO left;
        private TreeNodeDTO right;
        public TreeNodeDTO() {}
        public TreeNodeDTO(int data) { this.data = data; }
        public int getData() { return data; }
        public void setData(int data) { this.data = data; }
        public TreeNodeDTO getLeft() { return left; }
        public void setLeft(TreeNodeDTO left) { this.left = left; }
        public TreeNodeDTO getRight() { return right; }
        public void setRight(TreeNodeDTO right) { this.right = right; }
    }
    private TreeNodeDTO root;
    private List<Integer> inorder;
    private Boolean isBST;
    private Boolean twoSumResult;
    private Integer lcaResult;
    private Integer largestBSTSize;
    
    public BSTResponse() {}
    public BSTResponse(TreeNodeDTO root) { this.root = root; }
    public BSTResponse(List<Integer> inorder) { this.inorder = inorder; }
    public BSTResponse(Boolean isBST) { this.isBST = isBST; }
    public BSTResponse(Boolean twoSumResult, boolean isTwoSum) { this.twoSumResult = twoSumResult; }
    public BSTResponse(Integer lcaResult, boolean isLCA) { this.lcaResult = lcaResult; }
    
    public TreeNodeDTO getRoot() { return root; }
    public void setRoot(TreeNodeDTO root) { this.root = root; }
    public List<Integer> getInorder() { return inorder; }
    public void setInorder(List<Integer> inorder) { this.inorder = inorder; }
    public Boolean getIsBST() { return isBST; }
    public void setIsBST(Boolean isBST) { this.isBST = isBST; }
    public Boolean getTwoSumResult() { return twoSumResult; }
    public void setTwoSumResult(Boolean twoSumResult) { this.twoSumResult = twoSumResult; }
    public Integer getLcaResult() { return lcaResult; }
    public void setLcaResult(Integer lcaResult) { this.lcaResult = lcaResult; }
    public Integer getLargestBSTSize() { return largestBSTSize; }
    public void setLargestBSTSize(Integer largestBSTSize) { this.largestBSTSize = largestBSTSize; }
} 