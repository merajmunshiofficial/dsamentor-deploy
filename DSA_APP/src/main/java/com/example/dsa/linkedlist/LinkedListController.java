package com.example.dsa.linkedlist;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/linked-list")
@Tag(name = "Linked List", description = "DSA Linked List Problems")
public class LinkedListController {
    private final LinkedListService service;

    @Autowired
    public LinkedListController(LinkedListService service) {
        this.service = service;
    }

    @Operation(summary = "Add one to a number represented as a linked list")
    @PostMapping("/add-one")
    public ResponseEntity<LinkedListResponse> addOne(@Validated @RequestBody LinkedListRequest.AddOneInput request) {
        return ResponseEntity.ok(new LinkedListResponse(service.addOne(request.getValues())));
    }

    @Operation(summary = "Add two numbers represented as linked lists")
    @PostMapping("/add-two-numbers")
    public ResponseEntity<LinkedListResponse> addTwoNumbers(@Validated @RequestBody LinkedListRequest.AddTwoNumbersInput request) {
        return ResponseEntity.ok(new LinkedListResponse(service.addTwoNumbers(request.getL1(), request.getL2())));
    }

    @Operation(summary = "Copy a linked list with random pointers")
    @PostMapping("/copy-random-list")
    public ResponseEntity<LinkedListResponse> copyRandomList(@Validated @RequestBody LinkedListRequest.CopyRandomListInput request) {
        LinkedListResponse response = new LinkedListResponse();
        response.setRandomListResult(service.copyRandomList(request.getNodes()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete all occurrences of a target value from a doubly linked list")
    @PostMapping("/delete-all-occurrences")
    public ResponseEntity<LinkedListResponse> deleteAllOccurrences(@Validated @RequestBody LinkedListRequest.DeleteAllOccurrencesInput request) {
        List<Integer> result = service.deleteAllOccurrences(request.getValues(), request.getTarget());
        return ResponseEntity.ok(new LinkedListResponse(result));
    }

    @Operation(summary = "Delete the middle node of a linked list")
    @PostMapping("/delete-middle")
    public ResponseEntity<LinkedListResponse> deleteMiddle(@Validated @RequestBody LinkedListRequest.ListInput request) {
        List<Integer> result = service.deleteMiddle(request.getValues());
        return ResponseEntity.ok(new LinkedListResponse(result));
    }

    @Operation(summary = "Find the length of the loop in a linked list")
    @PostMapping("/find-length-of-loop")
    public ResponseEntity<LinkedListResponse> findLengthOfLoop(@Validated @RequestBody LinkedListRequest.FindLengthOfLoopInput request) {
        int result = service.findLengthOfLoop(request.getValues(), request.getLoopPosition());
        LinkedListResponse response = new LinkedListResponse();
        response.setLoopLength(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the starting point of the loop in a linked list")
    @PostMapping("/find-starting-point")
    public ResponseEntity<LinkedListResponse> findStartingPoint(@Validated @RequestBody LinkedListRequest.FindLengthOfLoopInput request) {
        int result = service.findStartingPoint(request.getValues(), request.getLoopPosition());
        LinkedListResponse response = new LinkedListResponse();
        response.setStartingPoint(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Flatten a multi-level linked list")
    @PostMapping("/flatten-linked-list")
    public ResponseEntity<LinkedListResponse> flattenLinkedList(@Validated @RequestBody LinkedListRequest.FlattenLinkedListInput request) {
        List<Integer> result = service.flattenLinkedList(request.getNodes());
        LinkedListResponse response = new LinkedListResponse();
        response.setFlattenedList(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find the intersection node of two linked lists")
    @PostMapping("/get-intersection-node")
    public ResponseEntity<LinkedListResponse> getIntersectionNode(@Validated @RequestBody LinkedListRequest.GetIntersectionNodeInput request) {
        int result = service.getIntersectionNode(request.getList1(), request.getList2(), request.getIntersectionIndex1(), request.getIntersectionIndex2());
        LinkedListResponse response = new LinkedListResponse();
        response.setIntersectionValue(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if a linked list has a cycle")
    @PostMapping("/has-cycle")
    public ResponseEntity<LinkedListResponse> hasCycle(@Validated @RequestBody LinkedListRequest.FindLengthOfLoopInput request) {
        boolean result = service.hasCycle(request.getValues(), request.getLoopPosition());
        LinkedListResponse response = new LinkedListResponse();
        response.setHasCycle(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if a linked list is a palindrome")
    @PostMapping("/is-palindrome")
    public ResponseEntity<LinkedListResponse> isPalindrome(@Validated @RequestBody LinkedListRequest.ListInput request) {
        boolean result = service.isPalindrome(request.getValues());
        LinkedListResponse response = new LinkedListResponse();
        response.setHasCycle(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Merge two sorted linked lists")
    @PostMapping("/merge-two-lists")
    public ResponseEntity<LinkedListResponse> mergeTwoLists(@Validated @RequestBody LinkedListRequest.AddTwoNumbersInput request) {
        List<Integer> result = service.mergeTwoLists(request.getL1(), request.getL2());
        return ResponseEntity.ok(new LinkedListResponse(result));
    }

    @Operation(summary = "Sort a linked list using merge sort")
    @PostMapping("/sort-list")
    public ResponseEntity<LinkedListResponse> sortList(@Validated @RequestBody LinkedListRequest.ListInput request) {
        List<Integer> result = service.sortList(request.getValues());
        LinkedListResponse response = new LinkedListResponse();
        response.setSortedList(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Rearrange linked list with odd nodes first, then even nodes")
    @PostMapping("/odd-even-list")
    public ResponseEntity<LinkedListResponse> oddEvenList(@Validated @RequestBody LinkedListRequest.ListInput request) {
        List<Integer> result = service.oddEvenList(request.getValues());
        LinkedListResponse response = new LinkedListResponse();
        response.setOddEvenList(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove duplicates from a sorted doubly linked list")
    @PostMapping("/remove-duplicates")
    public ResponseEntity<LinkedListResponse> removeDuplicates(@Validated @RequestBody LinkedListRequest.ListInput request) {
        List<Integer> result = service.removeDuplicates(request.getValues());
        LinkedListResponse response = new LinkedListResponse();
        response.setRemovedDuplicatesList(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove the nth node from the end of a linked list")
    @PostMapping("/remove-nth-from-end")
    public ResponseEntity<LinkedListResponse> removeNthFromEnd(@Validated @RequestBody LinkedListRequest.RemoveNthFromEndInput request) {
        List<Integer> result = service.removeNthFromEnd(request.getValues(), request.getN());
        LinkedListResponse response = new LinkedListResponse();
        response.setRemovedNthFromEndList(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Reverse a linked list")
    @PostMapping("/reverse-linked-list")
    public ResponseEntity<LinkedListResponse> reverseLinkedList(@Validated @RequestBody LinkedListRequest.ListInput request) {
        List<Integer> result = service.reverseLinkedList(request.getValues());
        LinkedListResponse response = new LinkedListResponse();
        response.setReversedList(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Reverse a linked list in groups of k")
    @PostMapping("/reverse-k-group")
    public ResponseEntity<LinkedListResponse> reverseKGroup(@Validated @RequestBody LinkedListRequest.ReverseKGroupInput request) {
        List<Integer> result = service.reverseKGroup(request.getValues(), request.getK());
        LinkedListResponse response = new LinkedListResponse();
        response.setReversedList(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Rotate a linked list to the right by k steps")
    @PostMapping("/rotate-right")
    public ResponseEntity<LinkedListResponse> rotateRight(@Validated @RequestBody LinkedListRequest.RotateRightInput request) {
        List<Integer> result = service.rotateRight(request.getValues(), request.getK());
        LinkedListResponse response = new LinkedListResponse();
        response.setRotatedList(result);
        return ResponseEntity.ok(response);
    }
} 