package com.example.dsa.binarysearchtree;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bst")
@Tag(name = "Binary Search Tree", description = "DSA Binary Search Tree Problems")
public class BSTController {
    private final BSTService service;

    @Autowired
    public BSTController(BSTService service) {
        this.service = service;
    }

    @Operation(summary = "Construct a BST from preorder traversal and return as nested object")
    @PostMapping("/bst-from-preorder")
    public ResponseEntity<BSTResponse> bstFromPreorder(@Validated @RequestBody BSTRequest.BstFromPreorderInput request) {
        BSTResponse.TreeNodeDTO root = service.bstFromPreorder(request.getPreorder());
        return ResponseEntity.ok(new BSTResponse(root));
    }

    @Operation(summary = "Return the in-order traversal of BST constructed from preorder (BST Iterator)")
    @PostMapping("/bst-iterator-inorder")
    public ResponseEntity<BSTResponse> bstIteratorInorder(@Validated @RequestBody BSTRequest.BstFromPreorderInput request) {
        return ResponseEntity.ok(new BSTResponse(service.bstIteratorInorder(request.getPreorder())));
    }

    @Operation(summary = "Delete a node with a given key from the BST and return the new tree")
    @PostMapping("/delete-node")
    public ResponseEntity<BSTResponse> deleteNode(@Validated @RequestBody BSTRequest.DeleteNodeInput request) {
        BSTResponse.TreeNodeDTO newRoot = service.deleteNode(request.getRoot(), request.getKey());
        return ResponseEntity.ok(new BSTResponse(newRoot));
    }

    @Operation(summary = "Find the floor and ceil of a key in the BST")
    @PostMapping("/floor-ceil")
    public ResponseEntity<BSTResponse> floorCeilOfBST(@Validated @RequestBody BSTRequest.FloorCeilInput request) {
        return ResponseEntity.ok(new BSTResponse(service.floorCeilOfBST(request.getRoot(), request.getKey())));
    }

    @Operation(summary = "Insert a value into the BST and return the new tree")
    @PostMapping("/insert-into-bst")
    public ResponseEntity<BSTResponse> insertIntoBST(@Validated @RequestBody BSTRequest.InsertIntoBSTInput request) {
        BSTResponse.TreeNodeDTO newRoot = service.insertIntoBST(request.getRoot(), request.getVal());
        return ResponseEntity.ok(new BSTResponse(newRoot));
    }

    @Operation(summary = "Check if the given tree is a valid BST")
    @PostMapping("/is-bst")
    public ResponseEntity<BSTResponse> isBST(@Validated @RequestBody BSTRequest.IsBSTInput request) {
        boolean result = service.isBST(request.getRoot());
        return ResponseEntity.ok(new BSTResponse(result));
    }

    @Operation(summary = "Find the k-th smallest and k-th largest elements in the BST")
    @PostMapping("/kth-smallest-largest")
    public ResponseEntity<BSTResponse> kthSmallestLargest(@Validated @RequestBody BSTRequest.KthSmallestLargestInput request) {
        return ResponseEntity.ok(new BSTResponse(service.kthSmallestLargest(request.getRoot(), request.getK())));
    }

    @Operation(summary = "Find the size of the largest BST subtree in the binary tree")
    @PostMapping("/largest-bst")
    public ResponseEntity<BSTResponse> largestBST(@Validated @RequestBody BSTRequest.LargestBSTInput request) {
        int result = service.largestBST(request.getRoot());
        BSTResponse response = new BSTResponse();
        response.setLargestBSTSize(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Search for a value in the BST and return the subtree rooted at that node")
    @PostMapping("/search-bst")
    public ResponseEntity<BSTResponse> searchBST(@Validated @RequestBody BSTRequest.SearchBSTInput request) {
        BSTResponse.TreeNodeDTO result = service.searchBST(request.getRoot(), request.getVal());
        return ResponseEntity.ok(new BSTResponse(result));
    }

    @Operation(summary = "Find the predecessor and successor of a key in the BST")
    @PostMapping("/succ-pred-bst")
    public ResponseEntity<BSTResponse> succPredBST(@Validated @RequestBody BSTRequest.SuccPredBSTInput request) {
        List<Integer> result = service.succPredBST(request.getRoot(), request.getKey());
        return ResponseEntity.ok(new BSTResponse(result));
    }

    @Operation(summary = "Check if there exist two elements in the BST such that their sum equals k")
    @PostMapping("/two-sum-bst")
    public ResponseEntity<BSTResponse> twoSumBST(@Validated @RequestBody BSTRequest.TwoSumBSTInput request) {
        boolean result = service.twoSumBST(request.getRoot(), request.getK());
        BSTResponse response = new BSTResponse();
        response.setTwoSumResult(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the lowest common ancestor of two nodes in the BST")
    @PostMapping("/lca")
    public ResponseEntity<BSTResponse> lca(@Validated @RequestBody BSTRequest.LCAInput request) {
        int result = service.lca(request.getRoot(), request.getP(), request.getQ());
        BSTResponse response = new BSTResponse();
        response.setLcaResult(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Recover a BST where exactly two nodes have been swapped")
    @PostMapping("/recover-tree")
    public ResponseEntity<BSTResponse> recoverTree(@Validated @RequestBody BSTRequest.RecoverTreeInput request) {
        BSTResponse.TreeNodeDTO result = service.recoverTree(request.getRoot());
        return ResponseEntity.ok(new BSTResponse(result));
    }
} 