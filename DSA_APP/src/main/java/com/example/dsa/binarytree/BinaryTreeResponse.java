package com.example.dsa.binarytree;

import java.util.List;
import java.util.Map;

public class BinaryTreeResponse {
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
    private List<Integer> traversal;
    private List<List<Integer>> levelOrder;
    private List<String> paths;
    private Boolean isBalanced;
    private Boolean isSameTree;
    private Boolean isSymmetric;
    private Integer maxDepth;
    private Integer diameter;
    private Integer maxPathSum;
    private Integer lcaResult;
    private List<String> allRootToLeafPaths;
    private List<List<Integer>> zigzagLevelOrder;
    private BinaryTreeResponse.TreeNodeDTO builtTree;
    private List<Integer> boundaryTraversal;
    private List<Integer> bottomView;
    private List<Integer> topView;
    private List<Integer> distanceK;
    private String serializedTree;
    private BinaryTreeResponse.TreeNodeDTO deserializedTree;
    private Integer timeToBurn;
    private Integer widthOfBinaryTree;
    private Integer uniqueBinaryTreesCount;
    private Map<String, List<Integer>> treeTraversalResult;
    private List<Integer> recursiveInorderResult;
    private List<Integer> rightSideView;
    
    public BinaryTreeResponse() {}
    public BinaryTreeResponse(TreeNodeDTO root) { this.root = root; }
    public BinaryTreeResponse(Boolean isBalanced) { this.isBalanced = isBalanced; }
    // Remove ambiguous overloaded constructors and use static factory methods instead

    public static BinaryTreeResponse forMaxDepth(Integer maxDepth) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setMaxDepth(maxDepth);
        return response;
    }

    public static BinaryTreeResponse forDiameter(Integer diameter) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setDiameter(diameter);
        return response;
    }

    public static BinaryTreeResponse forMaxPathSum(Integer maxPathSum) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setMaxPathSum(maxPathSum);
        return response;
    }

    public static BinaryTreeResponse forLcaResult(Integer lcaResult) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setLcaResult(lcaResult);
        return response;
    }

    public static BinaryTreeResponse forAllRootToLeafPaths(List<String> allRootToLeafPaths) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setAllRootToLeafPaths(allRootToLeafPaths);
        return response;
    }

    public static BinaryTreeResponse forZigzagLevelOrder(List<List<Integer>> zigzagLevelOrder) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setZigzagLevelOrder(zigzagLevelOrder);
        return response;
    }

    public static BinaryTreeResponse forBuiltTree(BinaryTreeResponse.TreeNodeDTO builtTree) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setBuiltTree(builtTree);
        return response;
    }

    public static BinaryTreeResponse forBoundaryTraversal(List<Integer> boundaryTraversal) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setBoundaryTraversal(boundaryTraversal);
        return response;
    }

    public static BinaryTreeResponse forBottomView(List<Integer> bottomView) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setBottomView(bottomView);
        return response;
    }

    public static BinaryTreeResponse forTopView(List<Integer> topView) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setTopView(topView);
        return response;
    }

    public static BinaryTreeResponse forDistanceK(List<Integer> distanceK) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setDistanceK(distanceK);
        return response;
    }

    public static BinaryTreeResponse forSerializedTree(String serializedTree) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setSerializedTree(serializedTree);
        return response;
    }

    public static BinaryTreeResponse forDeserializedTree(BinaryTreeResponse.TreeNodeDTO deserializedTree) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setDeserializedTree(deserializedTree);
        return response;
    }

    public static BinaryTreeResponse forTimeToBurn(int timeToBurn) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setTimeToBurn(timeToBurn);
        return response;
    }

    public static BinaryTreeResponse forWidthOfBinaryTree(int widthOfBinaryTree) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setWidthOfBinaryTree(widthOfBinaryTree);
        return response;
    }

    public static BinaryTreeResponse forUniqueBinaryTreesCount(int uniqueBinaryTreesCount) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setUniqueBinaryTreesCount(uniqueBinaryTreesCount);
        return response;
    }

    public static BinaryTreeResponse forTreeTraversalResult(Map<String, List<Integer>> treeTraversalResult) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setTreeTraversalResult(treeTraversalResult);
        return response;
    }

    public static BinaryTreeResponse forRecursiveInorderResult(List<Integer> recursiveInorderResult) {
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setRecursiveInorderResult(recursiveInorderResult);
        return response;
    }
    
    public TreeNodeDTO getRoot() { return root; }
    public void setRoot(TreeNodeDTO root) { this.root = root; }
    public List<Integer> getTraversal() { return traversal; }
    public void setTraversal(List<Integer> traversal) { this.traversal = traversal; }
    public List<List<Integer>> getLevelOrder() { return levelOrder; }
    public void setLevelOrder(List<List<Integer>> levelOrder) { this.levelOrder = levelOrder; }
    public List<String> getPaths() { return paths; }
    public void setPaths(List<String> paths) { this.paths = paths; }
    public Boolean getIsBalanced() { return isBalanced; }
    public void setIsBalanced(Boolean isBalanced) { this.isBalanced = isBalanced; }
    public Boolean getIsSameTree() { return isSameTree; }
    public void setIsSameTree(Boolean isSameTree) { this.isSameTree = isSameTree; }
    public Boolean getIsSymmetric() { return isSymmetric; }
    public void setIsSymmetric(Boolean isSymmetric) { this.isSymmetric = isSymmetric; }
    public Integer getMaxDepth() { return maxDepth; }
    public void setMaxDepth(Integer maxDepth) { this.maxDepth = maxDepth; }
    public Integer getDiameter() { return diameter; }
    public void setDiameter(Integer diameter) { this.diameter = diameter; }
    public Integer getMaxPathSum() { return maxPathSum; }
    public void setMaxPathSum(Integer maxPathSum) { this.maxPathSum = maxPathSum; }
    public Integer getLcaResult() { return lcaResult; }
    public void setLcaResult(Integer lcaResult) { this.lcaResult = lcaResult; }
    public List<String> getAllRootToLeafPaths() { return allRootToLeafPaths; }
    public void setAllRootToLeafPaths(List<String> allRootToLeafPaths) { this.allRootToLeafPaths = allRootToLeafPaths; }
    public List<List<Integer>> getZigzagLevelOrder() { return zigzagLevelOrder; }
    public void setZigzagLevelOrder(List<List<Integer>> zigzagLevelOrder) { this.zigzagLevelOrder = zigzagLevelOrder; }
    public BinaryTreeResponse.TreeNodeDTO getBuiltTree() { return builtTree; }
    public void setBuiltTree(BinaryTreeResponse.TreeNodeDTO builtTree) { this.builtTree = builtTree; }
    public List<Integer> getBoundaryTraversal() { return boundaryTraversal; }
    public void setBoundaryTraversal(List<Integer> boundaryTraversal) { this.boundaryTraversal = boundaryTraversal; }
    public List<Integer> getBottomView() { return bottomView; }
    public void setBottomView(List<Integer> bottomView) { this.bottomView = bottomView; }
    public List<Integer> getTopView() { return topView; }
    public void setTopView(List<Integer> topView) { this.topView = topView; }
    public List<Integer> getDistanceK() { return distanceK; }
    public void setDistanceK(List<Integer> distanceK) { this.distanceK = distanceK; }
    public String getSerializedTree() { return serializedTree; }
    public void setSerializedTree(String serializedTree) { this.serializedTree = serializedTree; }
    public BinaryTreeResponse.TreeNodeDTO getDeserializedTree() { return deserializedTree; }
    public void setDeserializedTree(BinaryTreeResponse.TreeNodeDTO deserializedTree) { this.deserializedTree = deserializedTree; }
    public Integer getTimeToBurn() { return timeToBurn; }
    public void setTimeToBurn(Integer timeToBurn) { this.timeToBurn = timeToBurn; }
    public Integer getWidthOfBinaryTree() { return widthOfBinaryTree; }
    public void setWidthOfBinaryTree(Integer widthOfBinaryTree) { this.widthOfBinaryTree = widthOfBinaryTree; }
    public Integer getUniqueBinaryTreesCount() { return uniqueBinaryTreesCount; }
    public void setUniqueBinaryTreesCount(Integer uniqueBinaryTreesCount) { this.uniqueBinaryTreesCount = uniqueBinaryTreesCount; }
    public Map<String, List<Integer>> getTreeTraversalResult() { return treeTraversalResult; }
    public void setTreeTraversalResult(Map<String, List<Integer>> treeTraversalResult) { this.treeTraversalResult = treeTraversalResult; }
    public List<Integer> getRecursiveInorderResult() { return recursiveInorderResult; }
    public void setRecursiveInorderResult(List<Integer> recursiveInorderResult) { this.recursiveInorderResult = recursiveInorderResult; }
    public List<Integer> getRightSideView() { return rightSideView; }
    public void setRightSideView(List<Integer> rightSideView) { this.rightSideView = rightSideView; }
}