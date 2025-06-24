package com.example.dsa.binarytree;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BinaryTreeService {
    private static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int val) { data = val; }
    }

    // Convert DTO to TreeNode
    private TreeNode fromDTO(BinaryTreeResponse.TreeNodeDTO dto) {
        if (dto == null) return null;
        TreeNode node = new TreeNode(dto.getData());
        node.left = fromDTO(dto.getLeft());
        node.right = fromDTO(dto.getRight());
        return node;
    }

    // Convert TreeNode to DTO
    private BinaryTreeResponse.TreeNodeDTO toDTO(TreeNode node) {
        if (node == null) return null;
        BinaryTreeResponse.TreeNodeDTO dto = new BinaryTreeResponse.TreeNodeDTO(node.data);
        dto.setLeft(toDTO(node.left));
        dto.setRight(toDTO(node.right));
        return dto;
    }

    // 1. Inorder Traversal
    public List<Integer> inorderTraversal(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.data);
        inorderHelper(node.right, result);
    }

    // 2. Preorder Traversal
    public List<Integer> preorderTraversal(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.data);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    // 3. Postorder Traversal
    public List<Integer> postorderTraversal(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.data);
    }

    // 4. Level Order Traversal
    public List<List<Integer>> levelOrderTraversal(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.data);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    // 5. Maximum Depth of Binary Tree
    public int maxDepth(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        return maxDepthHelper(root);
    }

    private int maxDepthHelper(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepthHelper(node.left), maxDepthHelper(node.right)) + 1;
    }

    // 6. Check if Binary Tree is Balanced
    public boolean isBalanced(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        return isBalancedHelper(root) != -1;
    }

    private int isBalancedHelper(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = isBalancedHelper(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = isBalancedHelper(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 7. Check if Two Trees are Same
    public boolean isSameTree(BinaryTreeResponse.TreeNodeDTO pDto, BinaryTreeResponse.TreeNodeDTO qDto) {
        TreeNode p = fromDTO(pDto);
        TreeNode q = fromDTO(qDto);
        return isSameTreeHelper(p, q);
    }

    private boolean isSameTreeHelper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.data == q.data && 
               isSameTreeHelper(p.left, q.left) && 
               isSameTreeHelper(p.right, q.right);
    }

    // 8. Check if Binary Tree is Symmetric
    public boolean isSymmetric(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.data == right.data && 
               isSymmetricHelper(left.left, right.right) && 
               isSymmetricHelper(left.right, right.left);
    }

    // 9. Lowest Common Ancestor
    public int lowestCommonAncestor(BinaryTreeResponse.TreeNodeDTO rootDto, int p, int q) {
        TreeNode root = fromDTO(rootDto);
        TreeNode result = lcaHelper(root, p, q);
        return result != null ? result.data : -1;
    }

    private TreeNode lcaHelper(TreeNode node, int p, int q) {
        if (node == null || node.data == p || node.data == q) {
            return node;
        }
        
        TreeNode left = lcaHelper(node.left, p, q);
        TreeNode right = lcaHelper(node.right, p, q);
        
        if (left != null && right != null) {
            return node;
        }
        
        return left != null ? left : right;
    }

    // 10. Diameter of Binary Tree
    public int diameterOfBinaryTree(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        int[] diameter = {0};
        diameterHelper(root, diameter);
        return diameter[0];
    }

    private int diameterHelper(TreeNode node, int[] diameter) {
        if (node == null) return 0;
        
        int leftHeight = diameterHelper(node.left, diameter);
        int rightHeight = diameterHelper(node.right, diameter);
        
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 11. Maximum Path Sum
    public int findMaxPathSum(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        int[] maxSum = {Integer.MIN_VALUE};
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }

    private int maxPathSumHelper(TreeNode node, int[] maxSum) {
        if (node == null) return 0;
        
        int leftSum = Math.max(0, maxPathSumHelper(node.left, maxSum));
        int rightSum = Math.max(0, maxPathSumHelper(node.right, maxSum));
        
        maxSum[0] = Math.max(maxSum[0], node.data + leftSum + rightSum);
        
        return node.data + Math.max(leftSum, rightSum);
    }

    // 12. Right Side View
    public List<Integer> rightSideView(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (i == levelSize - 1) {
                    result.add(node.data);
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    // 13. All Root to Leaf Paths
    public List<String> allRootToLeafPaths(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        
        rootToLeafHelper(root, "", result);
        return result;
    }

    private void rootToLeafHelper(TreeNode node, String path, List<String> result) {
        if (node == null) return;
        
        String currentPath = path.isEmpty() ? String.valueOf(node.data) : path + "->" + node.data;
        
        if (node.left == null && node.right == null) {
            result.add(currentPath);
            return;
        }
        
        rootToLeafHelper(node.left, currentPath, result);
        rootToLeafHelper(node.right, currentPath, result);
    }

    // 14. Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (leftToRight) {
                    level.add(node.data);
                } else {
                    level.add(0, node.data);
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }

    // 15. Build Tree from Inorder and Postorder
    public BinaryTreeResponse.TreeNodeDTO buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        TreeNode root = buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, inorderMap);
        return toDTO(root);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || postStart > postEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = inorderMap.get(root.data);
        int leftSubtreeSize = rootIndex - inStart;
        
        root.left = buildTreeHelper(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSubtreeSize - 1, inorderMap);
        root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inEnd, postStart + leftSubtreeSize, postEnd - 1, inorderMap);
        
        return root;
    }

    // 16. Boundary Traversal
    public List<Integer> boundaryTraversal(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        result.add(root.data);
        
        // Add left boundary (excluding leaf)
        addLeftBoundary(root.left, result);
        
        // Add leaves
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        
        // Add right boundary (excluding leaf)
        addRightBoundary(root.right, result);
        
        return result;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> result) {
        if (node == null || (node.left == null && node.right == null)) return;
        result.add(node.data);
        if (node.left != null) {
            addLeftBoundary(node.left, result);
        } else {
            addLeftBoundary(node.right, result);
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> result) {
        if (node == null || (node.left == null && node.right == null)) return;
        if (node.right != null) {
            addRightBoundary(node.right, result);
        } else {
            addRightBoundary(node.left, result);
        }
        result.add(node.data);
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(node.data);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    // 17. Bottom View
    public List<Integer> bottomView(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int hd = pair.horizontalDistance;
            
            map.put(hd, node.data);
            
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }
        
        for (int val : map.values()) {
            result.add(val);
        }
        return result;
    }

    private static class Pair {
        TreeNode node;
        int horizontalDistance;
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.horizontalDistance = hd;
        }
    }

    // 18. Top View
    public List<Integer> topView(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int hd = pair.horizontalDistance;
            
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }
            
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }
        
        for (int val : map.values()) {
            result.add(val);
        }
        return result;
    }

    // 19. Distance K from Target
    public List<Integer> distanceK(BinaryTreeResponse.TreeNodeDTO rootDto, int target, int k) {
        TreeNode root = fromDTO(rootDto);
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);
        
        TreeNode targetNode = findTargetNode(root, target);
        if (targetNode == null) return result;
        
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(targetNode);
        visited.add(targetNode);
        
        int distance = 0;
        while (!queue.isEmpty() && distance <= k) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (distance == k) {
                    result.add(node.data);
                }
                
                // Add left child
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }
                
                // Add right child
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }
                
                // Add parent
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            distance++;
        }
        
        return result;
    }

    private void buildParentMap(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        
        if (node.left != null) {
            parentMap.put(node.left, node);
            buildParentMap(node.left, parentMap);
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
            buildParentMap(node.right, parentMap);
        }
    }

    private TreeNode findTargetNode(TreeNode node, int target) {
        if (node == null) return null;
        if (node.data == target) return node;
        
        TreeNode left = findTargetNode(node.left, target);
        if (left != null) return left;
        
        return findTargetNode(node.right, target);
    }

    // 20. Serialize and Deserialize Binary Tree
    public String serialize(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        if (root == null) return "null";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.data).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        
        // Remove trailing commas and nulls
        String result = sb.toString();
        while (result.endsWith("null,")) {
            result = result.substring(0, result.length() - 5);
        }
        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        
        return result;
    }

    public BinaryTreeResponse.TreeNodeDTO deserialize(String data) {
        if (data.equals("null") || data.isEmpty()) return null;
        
        String[] values = data.split(",");
        if (values.length == 0) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();
            
            // Left child
            if (i < values.length && !values[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;
            
            // Right child
            if (i < values.length && !values[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }
        
        return toDTO(root);
    }

    // 21. Time to Burn Tree
    public int timeToBurnTree(BinaryTreeResponse.TreeNodeDTO rootDto, int target) {
        TreeNode root = fromDTO(rootDto);
        if (root == null) return 0;
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);
        
        TreeNode targetNode = findTargetNode(root, target);
        if (targetNode == null) return 0;
        
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(targetNode);
        visited.add(targetNode);
        
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // Check left child
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                    burned = true;
                }
                
                // Check right child
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                    burned = true;
                }
                
                // Check parent
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                    burned = true;
                }
            }
            
            if (burned) time++;
        }
        
        return time;
    }

    // 22. Width of Binary Tree
    public int widthOfBinaryTree(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        if (root == null) return 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().horizontalDistance;
            int max = queue.peek().horizontalDistance;
            
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int hd = pair.horizontalDistance;
                
                min = Math.min(min, hd);
                max = Math.max(max, hd);
                
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * hd + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * hd + 2));
                }
            }
            
            maxWidth = Math.max(maxWidth, max - min + 1);
        }
        
        return maxWidth;
    }

    // 23. Unique Binary Search Trees Count
    public int uniqueBinaryTrees(int n) {
        if (n <= 1) return 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        
        return dp[n];
    }

    // 24. Tree Traversal (All three traversals)
    public Map<String, List<Integer>> treeTraversal(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        Map<String, List<Integer>> result = new HashMap<>();
        
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        
        inorderHelper(root, inorder);
        preorderHelper(root, preorder);
        postorderHelper(root, postorder);
        
        result.put("inorder", inorder);
        result.put("preorder", preorder);
        result.put("postorder", postorder);
        
        return result;
    }

    // 25. Recursive Inorder Traversal
    public List<Integer> recursiveInorder(BinaryTreeResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        List<Integer> result = new ArrayList<>();
        recursiveInorderHelper(root, result);
        return result;
    }

    private void recursiveInorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        recursiveInorderHelper(node.left, result);
        result.add(node.data);
        recursiveInorderHelper(node.right, result);
    }
} 