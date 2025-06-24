package com.example.dsa.binarysearchtree;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BSTService {
    private static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int val) { data = val; }
    }

    public BSTResponse.TreeNodeDTO bstFromPreorder(List<Integer> preorder) {
        TreeNode root = bstFromPreorderHelper(preorder, Integer.MAX_VALUE, new int[]{0});
        return toDTO(root);
    }

    private TreeNode bstFromPreorderHelper(List<Integer> preorder, int bound, int[] index) {
        if (index[0] == preorder.size() || preorder.get(index[0]) > bound) return null;
        TreeNode root = new TreeNode(preorder.get(index[0]++));
        root.left = bstFromPreorderHelper(preorder, root.data, index);
        root.right = bstFromPreorderHelper(preorder, bound, index);
        return root;
    }

    private BSTResponse.TreeNodeDTO toDTO(TreeNode node) {
        if (node == null) return null;
        BSTResponse.TreeNodeDTO dto = new BSTResponse.TreeNodeDTO(node.data);
        dto.setLeft(toDTO(node.left));
        dto.setRight(toDTO(node.right));
        return dto;
    }

    public List<Integer> bstIteratorInorder(List<Integer> preorder) {
        TreeNode root = bstFromPreorderHelper(preorder, Integer.MAX_VALUE, new int[]{0});
        List<Integer> inorder = new java.util.ArrayList<>();
        inorderTraversal(root, inorder);
        return inorder;
    }

    private void inorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorderTraversal(node.left, res);
        res.add(node.data);
        inorderTraversal(node.right, res);
    }

    public BSTResponse.TreeNodeDTO deleteNode(BSTResponse.TreeNodeDTO rootDto, int key) {
        TreeNode root = fromDTO(rootDto);
        TreeNode newRoot = deleteNodeInternal(root, key);
        return toDTO(newRoot);
    }

    private TreeNode deleteNodeInternal(TreeNode root, int key) {
        if (root == null) return null;
        if (root.data == key) {
            return connector(root);
        }
        TreeNode node = root;
        while (node != null) {
            if (node.data > key) {
                if (node.left != null && node.left.data == key) {
                    node.left = connector(node.left);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right != null && node.right.data == key) {
                    node.right = connector(node.right);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }

    private TreeNode connector(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode leftChild = root.left;
        TreeNode leftmostChildInRightSubtree = root.right;
        while (leftmostChildInRightSubtree.left != null) {
            leftmostChildInRightSubtree = leftmostChildInRightSubtree.left;
        }
        leftmostChildInRightSubtree.left = leftChild;
        return root.right;
    }

    private TreeNode fromDTO(BSTResponse.TreeNodeDTO dto) {
        if (dto == null) return null;
        TreeNode node = new TreeNode(dto.getData());
        node.left = fromDTO(dto.getLeft());
        node.right = fromDTO(dto.getRight());
        return node;
    }

    public List<Integer> floorCeilOfBST(BSTResponse.TreeNodeDTO rootDto, int key) {
        TreeNode root = fromDTO(rootDto);
        int floor = -1, ceil = -1;
        TreeNode current = root;
        while (current != null) {
            if (current.data == key) {
                floor = current.data;
                break;
            } else if (current.data < key) {
                floor = current.data;
                current = current.right;
            } else {
                current = current.left;
            }
        }
        current = root;
        while (current != null) {
            if (current.data == key) {
                ceil = current.data;
                break;
            } else if (current.data > key) {
                ceil = current.data;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return java.util.Arrays.asList(floor, ceil);
    }

    public BSTResponse.TreeNodeDTO insertIntoBST(BSTResponse.TreeNodeDTO rootDto, int val) {
        TreeNode root = fromDTO(rootDto);
        TreeNode newRoot = insertIntoBSTInternal(root, val);
        return toDTO(newRoot);
    }

    private TreeNode insertIntoBSTInternal(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode current = root;
        while (true) {
            if (val < current.data) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
        return root;
    }

    public boolean isBST(BSTResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBST(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validateBST(node.left, min, node.data) && validateBST(node.right, node.data, max);
    }

    public List<Integer> kthSmallestLargest(BSTResponse.TreeNodeDTO rootDto, int k) {
        TreeNode root = fromDTO(rootDto);
        return java.util.Arrays.asList(kthSmallest(root, k), kthLargest(root, k));
    }

    private int kthSmallest(TreeNode root, int k) {
        int[] count = {k};
        int[] result = {-1};
        inorderKth(root, count, result);
        return result[0];
    }

    private void inorderKth(TreeNode node, int[] count, int[] result) {
        if (node == null) return;
        inorderKth(node.left, count, result);
        if (--count[0] == 0) {
            result[0] = node.data;
            return;
        }
        inorderKth(node.right, count, result);
    }

    private int kthLargest(TreeNode root, int k) {
        int[] count = {k};
        int[] result = {-1};
        reverseInorderKth(root, count, result);
        return result[0];
    }

    private void reverseInorderKth(TreeNode node, int[] count, int[] result) {
        if (node == null) return;
        reverseInorderKth(node.right, count, result);
        if (--count[0] == 0) {
            result[0] = node.data;
            return;
        }
        reverseInorderKth(node.left, count, result);
    }

    public int largestBST(BSTResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        return largestBSTSubtreeHelper(root).maxSize;
    }

    private static class NodeValue {
        int minNode, maxNode, maxSize;
        NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    private NodeValue largestBSTSubtreeHelper(TreeNode node) {
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = largestBSTSubtreeHelper(node.left);
        NodeValue right = largestBSTSubtreeHelper(node.right);
        if (left.maxNode < node.data && node.data < right.minNode) {
            return new NodeValue(
                Math.min(node.data, left.minNode),
                Math.max(node.data, right.maxNode),
                left.maxSize + right.maxSize + 1
            );
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public BSTResponse.TreeNodeDTO searchBST(BSTResponse.TreeNodeDTO rootDto, int val) {
        TreeNode root = fromDTO(rootDto);
        TreeNode result = searchBSTInternal(root, val);
        return toDTO(result);
    }

    private TreeNode searchBSTInternal(TreeNode root, int val) {
        while (root != null && root.data != val) {
            root = (root.data > val) ? root.left : root.right;
        }
        return root;
    }

    public List<Integer> succPredBST(BSTResponse.TreeNodeDTO rootDto, int key) {
        TreeNode root = fromDTO(rootDto);
        int[] predecessor = {-1};
        int[] successor = {Integer.MAX_VALUE};
        traverseSuccPred(root, key, predecessor, successor);
        return java.util.Arrays.asList(
            predecessor[0] == -1 ? -1 : predecessor[0], 
            successor[0] == Integer.MAX_VALUE ? -1 : successor[0]
        );
    }

    private void traverseSuccPred(TreeNode node, int key, int[] predecessor, int[] successor) {
        if (node == null) return;
        
        if (node.data < key) {
            predecessor[0] = Math.max(predecessor[0], node.data);
            traverseSuccPred(node.right, key, predecessor, successor);
        } else if (node.data > key) {
            successor[0] = Math.min(successor[0], node.data);
            traverseSuccPred(node.left, key, predecessor, successor);
        } else {
            if (node.left != null) {
                TreeNode temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                predecessor[0] = temp.data;
            }
            
            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                successor[0] = temp.data;
            }
        }
    }

    public boolean twoSumBST(BSTResponse.TreeNodeDTO rootDto, int k) {
        TreeNode root = fromDTO(rootDto);
        if (root == null) return false;
        
        java.util.Stack<TreeNode> leftStack = new java.util.Stack<>();
        java.util.Stack<TreeNode> rightStack = new java.util.Stack<>();
        
        pushAllLeft(root, leftStack);
        pushAllRight(root, rightStack);
        
        TreeNode left = getNextLeft(leftStack);
        TreeNode right = getNextRight(rightStack);
        
        while (left != null && right != null && left.data < right.data) {
            int sum = left.data + right.data;
            if (sum == k) return true;
            else if (sum < k) left = getNextLeft(leftStack);
            else right = getNextRight(rightStack);
        }
        return false;
    }

    private void pushAllLeft(TreeNode node, java.util.Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private void pushAllRight(TreeNode node, java.util.Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    private TreeNode getNextLeft(java.util.Stack<TreeNode> stack) {
        if (stack.isEmpty()) return null;
        TreeNode node = stack.pop();
        pushAllLeft(node.right, stack);
        return node;
    }

    private TreeNode getNextRight(java.util.Stack<TreeNode> stack) {
        if (stack.isEmpty()) return null;
        TreeNode node = stack.pop();
        pushAllRight(node.left, stack);
        return node;
    }

    public int lca(BSTResponse.TreeNodeDTO rootDto, int p, int q) {
        TreeNode root = fromDTO(rootDto);
        TreeNode result = lcaInternal(root, p, q);
        return result != null ? result.data : -1;
    }

    private TreeNode lcaInternal(TreeNode root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }
        
        TreeNode left = lcaInternal(root.left, p, q);
        TreeNode right = lcaInternal(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }

    public BSTResponse.TreeNodeDTO recoverTree(BSTResponse.TreeNodeDTO rootDto) {
        TreeNode root = fromDTO(rootDto);
        TreeNode[] first = {null};
        TreeNode[] middle = {null};
        TreeNode[] last = {null};
        TreeNode[] prev = {null};
        
        inorderRecover(root, first, middle, last, prev);
        
        if (first[0] != null && last[0] != null) {
            int temp = first[0].data;
            first[0].data = last[0].data;
            last[0].data = temp;
        } else if (first[0] != null && middle[0] != null) {
            int temp = first[0].data;
            first[0].data = middle[0].data;
            middle[0].data = temp;
        }
        
        return toDTO(root);
    }

    private void inorderRecover(TreeNode node, TreeNode[] first, TreeNode[] middle, TreeNode[] last, TreeNode[] prev) {
        if (node == null) return;
        
        inorderRecover(node.left, first, middle, last, prev);
        
        if (prev[0] != null && prev[0].data > node.data) {
            if (first[0] == null) {
                first[0] = prev[0];
                middle[0] = node;
            } else {
                last[0] = node;
            }
        }
        
        prev[0] = node;
        
        inorderRecover(node.right, first, middle, last, prev);
    }
} 