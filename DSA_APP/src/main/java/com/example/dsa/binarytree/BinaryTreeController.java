package com.example.dsa.binarytree;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/binary-tree")
@Tag(name = "Binary Tree", description = "DSA Binary Tree Problems")
public class BinaryTreeController {
    private final BinaryTreeService service;

    @Autowired
    public BinaryTreeController(BinaryTreeService service) {
        this.service = service;
    }

    @Operation(summary = "Perform inorder traversal of the binary tree")
    @PostMapping("/inorder-traversal")
    public ResponseEntity<BinaryTreeResponse> inorderTraversal(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        List<Integer> result = service.inorderTraversal(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setTraversal(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Perform preorder traversal of the binary tree")
    @PostMapping("/preorder-traversal")
    public ResponseEntity<BinaryTreeResponse> preorderTraversal(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        List<Integer> result = service.preorderTraversal(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setTraversal(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Perform postorder traversal of the binary tree")
    @PostMapping("/postorder-traversal")
    public ResponseEntity<BinaryTreeResponse> postorderTraversal(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        List<Integer> result = service.postorderTraversal(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setTraversal(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Perform level order traversal of the binary tree")
    @PostMapping("/level-order-traversal")
    public ResponseEntity<BinaryTreeResponse> levelOrderTraversal(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        List<List<Integer>> result = service.levelOrderTraversal(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setLevelOrder(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the maximum depth of the binary tree")
    @PostMapping("/max-depth")
    public ResponseEntity<BinaryTreeResponse> maxDepth(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        int result = service.maxDepth(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setMaxDepth(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if the binary tree is balanced")
    @PostMapping("/is-balanced")
    public ResponseEntity<BinaryTreeResponse> isBalanced(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        boolean result = service.isBalanced(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setIsBalanced(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if two binary trees are the same")
    @PostMapping("/is-same-tree")
    public ResponseEntity<BinaryTreeResponse> isSameTree(@Validated @RequestBody BinaryTreeRequest.TwoTreeInput request) {
        boolean result = service.isSameTree(request.getP(), request.getQ());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setIsSameTree(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if the binary tree is symmetric")
    @PostMapping("/is-symmetric")
    public ResponseEntity<BinaryTreeResponse> isSymmetric(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        boolean result = service.isSymmetric(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setIsSymmetric(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the lowest common ancestor of two nodes")
    @PostMapping("/lowest-common-ancestor")
    public ResponseEntity<BinaryTreeResponse> lowestCommonAncestor(@Validated @RequestBody BinaryTreeRequest.LCAInput request) {
        int result = service.lowestCommonAncestor(request.getRoot(), request.getP(), request.getQ());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setLcaResult(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the diameter of the binary tree")
    @PostMapping("/diameter")
    public ResponseEntity<BinaryTreeResponse> diameterOfBinaryTree(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        int result = service.diameterOfBinaryTree(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setDiameter(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the maximum path sum in the binary tree")
    @PostMapping("/max-path-sum")
    public ResponseEntity<BinaryTreeResponse> findMaxPathSum(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        int result = service.findMaxPathSum(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setMaxPathSum(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get the right side view of the binary tree")
    @PostMapping("/right-side-view")
    public ResponseEntity<BinaryTreeResponse> rightSideView(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        List<Integer> result = service.rightSideView(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setRightSideView(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all root to leaf paths in the binary tree")
    @PostMapping("/all-root-to-leaf-paths")
    public ResponseEntity<BinaryTreeResponse> allRootToLeafPaths(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        List<String> result = service.allRootToLeafPaths(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setAllRootToLeafPaths(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Perform zigzag level order traversal of the binary tree")
    @PostMapping("/zigzag-level-order")
    public ResponseEntity<BinaryTreeResponse> zigzagLevelOrder(@Validated @RequestBody BinaryTreeRequest.TreeNodeInput request) {
        List<List<Integer>> result = service.zigzagLevelOrder(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setZigzagLevelOrder(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Build binary tree from inorder and postorder traversal")
    @PostMapping("/build-tree")
    public ResponseEntity<BinaryTreeResponse> buildTree(@Validated @RequestBody BinaryTreeRequest.BuildTreeInput request) {
        BinaryTreeResponse.TreeNodeDTO result = service.buildTree(request.getInorder(), request.getPostorder());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setBuiltTree(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Perform boundary traversal of the binary tree")
    @PostMapping("/boundary-traversal")
    public ResponseEntity<BinaryTreeResponse> boundaryTraversal(@Validated @RequestBody BinaryTreeRequest.BoundaryTraversalInput request) {
        List<Integer> result = service.boundaryTraversal(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setBoundaryTraversal(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get the bottom view of the binary tree")
    @PostMapping("/bottom-view")
    public ResponseEntity<BinaryTreeResponse> bottomView(@Validated @RequestBody BinaryTreeRequest.BottomViewInput request) {
        List<Integer> result = service.bottomView(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setBottomView(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get the top view of the binary tree")
    @PostMapping("/top-view")
    public ResponseEntity<BinaryTreeResponse> topView(@Validated @RequestBody BinaryTreeRequest.TopViewInput request) {
        List<Integer> result = service.topView(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setTopView(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find all nodes at distance k from the target node")
    @PostMapping("/distance-k")
    public ResponseEntity<BinaryTreeResponse> distanceK(@Validated @RequestBody BinaryTreeRequest.DistanceKInput request) {
        List<Integer> result = service.distanceK(request.getRoot(), request.getTarget(), request.getK());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setDistanceK(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Serialize the binary tree to a string")
    @PostMapping("/serialize")
    public ResponseEntity<BinaryTreeResponse> serialize(@Validated @RequestBody BinaryTreeRequest.SerializeInput request) {
        String result = service.serialize(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setSerializedTree(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Deserialize a string back to a binary tree")
    @PostMapping("/deserialize")
    public ResponseEntity<BinaryTreeResponse> deserialize(@Validated @RequestBody BinaryTreeRequest.DeserializeInput request) {
        BinaryTreeResponse.TreeNodeDTO result = service.deserialize(request.getData());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setDeserializedTree(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Calculate time to burn the entire tree starting from target node")
    @PostMapping("/time-to-burn-tree")
    public ResponseEntity<BinaryTreeResponse> timeToBurnTree(@Validated @RequestBody BinaryTreeRequest.TimeToBurnTreeInput request) {
        int result = service.timeToBurnTree(request.getRoot(), request.getTarget());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setTimeToBurn(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the maximum width of the binary tree")
    @PostMapping("/width-of-binary-tree")
    public ResponseEntity<BinaryTreeResponse> widthOfBinaryTree(@Validated @RequestBody BinaryTreeRequest.WidthOfBinaryTreeInput request) {
        int result = service.widthOfBinaryTree(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setWidthOfBinaryTree(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Count the number of unique binary search trees with n nodes")
    @PostMapping("/unique-binary-trees")
    public ResponseEntity<BinaryTreeResponse> uniqueBinaryTrees(@Validated @RequestBody BinaryTreeRequest.UniqueBinaryTreesInput request) {
        int result = service.uniqueBinaryTrees(request.getN());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setUniqueBinaryTreesCount(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Perform all three tree traversals (inorder, preorder, postorder)")
    @PostMapping("/tree-traversal")
    public ResponseEntity<BinaryTreeResponse> treeTraversal(@Validated @RequestBody BinaryTreeRequest.TreeTraversalInput request) {
        Map<String, List<Integer>> result = service.treeTraversal(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setTreeTraversalResult(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Perform recursive inorder traversal of the binary tree")
    @PostMapping("/recursive-inorder")
    public ResponseEntity<BinaryTreeResponse> recursiveInorder(@Validated @RequestBody BinaryTreeRequest.RecursiveInorderInput request) {
        List<Integer> result = service.recursiveInorder(request.getRoot());
        BinaryTreeResponse response = new BinaryTreeResponse();
        response.setRecursiveInorderResult(result);
        return ResponseEntity.ok(response);
    }
}