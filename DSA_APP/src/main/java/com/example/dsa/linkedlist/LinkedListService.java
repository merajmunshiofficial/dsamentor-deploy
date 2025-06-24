package com.example.dsa.linkedlist;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LinkedListService {
    // ListNode definition
    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode() { val = 0; next = null; prev = null; }
        ListNode(int val) { this.val = val; next = null; prev = null; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; this.prev = null; }
        ListNode(int val, ListNode next, ListNode prev) { this.val = val; this.next = next; this.prev = prev; }
    }

    // Helper: Convert List<Integer> to ListNode
    private ListNode fromList(List<Integer> values) {
        if (values == null || values.isEmpty()) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: Convert ListNode to List<Integer>
    private List<Integer> toList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    // AddOne logic
    public List<Integer> addOne(List<Integer> values) {
        ListNode head = fromList(values);
        int carry = addHelper(head);
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            head = newNode;
        }
        return toList(head);
    }

    private int addHelper(ListNode node) {
        if (node == null) return 1;
        int carry = addHelper(node.next);
        node.val += carry;
        if (node.val < 10) return 0;
        node.val = 0;
        return 1;
    }

    // AddTwoNumbers logic
    public List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2) {
        ListNode node1 = fromList(l1);
        ListNode node2 = fromList(l2);
        ListNode result = addTwoNumbersHelper(node1, node2);
        return toList(result);
    }

    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        return dummy.next;
    }

    public List<Integer> deleteAllOccurrences(List<Integer> values, int target) {
        if (values == null || values.isEmpty()) {
            return new ArrayList<>();
        }

        // Create doubly linked list
        ListNode head = createDoublyLinkedList(values);
        
        // Delete all occurrences
        head = deleteAllOccurrencesHelper(head, target);
        
        // Convert back to list
        return convertDoublyLinkedListToList(head);
    }

    private ListNode deleteAllOccurrencesHelper(ListNode head, int target) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == target) {
                // Update head if needed
                if (temp == head) {
                    head = temp.next;
                }

                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;

                // Update previous node's next
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                // Update next node's previous
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                // Delete the current node
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    private ListNode createDoublyLinkedList(List<Integer> values) {
        if (values.isEmpty()) return null;
        
        ListNode head = new ListNode(values.get(0));
        ListNode current = head;
        
        for (int i = 1; i < values.size(); i++) {
            ListNode newNode = new ListNode(values.get(i));
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        
        return head;
    }

    private List<Integer> convertDoublyLinkedListToList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode current = head;
        
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        
        return result;
    }

    public List<Integer> deleteMiddle(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return new ArrayList<>();
        }

        // Create linked list
        ListNode head = createLinkedList(values);
        
        // Delete middle node
        head = deleteMiddleHelper(head);
        
        // Convert back to list
        return convertLinkedListToList(head);
    }

    private ListNode deleteMiddleHelper(ListNode head) {
        // If the list is empty or has only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next.next;

        // Move 'fast' pointer twice as fast as 'slow'
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node by skipping it
        slow.next = slow.next.next;
        return head;
    }

    private ListNode createLinkedList(List<Integer> values) {
        if (values.isEmpty()) return null;
        
        ListNode head = new ListNode(values.get(0));
        ListNode current = head;
        
        for (int i = 1; i < values.size(); i++) {
            ListNode newNode = new ListNode(values.get(i));
            current.next = newNode;
            current = newNode;
        }
        
        return head;
    }

    private List<Integer> convertLinkedListToList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode current = head;
        
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        
        return result;
    }

    public int findLengthOfLoop(List<Integer> values, int loopPosition) {
        if (values == null || values.isEmpty()) {
            return 0;
        }

        // Create linked list with loop
        ListNode head = createLinkedListWithLoop(values, loopPosition);
        
        // Find length of loop
        return findLengthOfLoopHelper(head);
    }

    private int findLengthOfLoopHelper(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list to detect a loop
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;

            // If the slow and fast pointers meet, there is a loop
            if (slow == fast) {
                return findLength(slow, fast);
            }
        }

        // If the fast pointer reaches the end, there is no loop
        return 0;
    }

    private int findLength(ListNode slow, ListNode fast) {
        // Count to keep track of nodes encountered in loop
        int cnt = 1;
        
        // Move fast by one step
        fast = fast.next;
        
        // Traverse fast till it reaches back to slow
        while (slow != fast) {
            cnt++;
            fast = fast.next;
        }
        
        return cnt;
    }

    private ListNode createLinkedListWithLoop(List<Integer> values, int loopPosition) {
        if (values.isEmpty()) return null;
        
        ListNode head = new ListNode(values.get(0));
        ListNode current = head;
        ListNode loopNode = null;
        
        for (int i = 1; i < values.size(); i++) {
            ListNode newNode = new ListNode(values.get(i));
            current.next = newNode;
            current = newNode;
            
            // Mark the loop node
            if (i == loopPosition) {
                loopNode = newNode;
            }
        }
        
        // Create loop if specified
        if (loopPosition >= 0 && loopPosition < values.size()) {
            current.next = loopNode;
        }
        
        return head;
    }

    public int findStartingPoint(List<Integer> values, int loopPosition) {
        if (values == null || values.isEmpty()) {
            return -1;
        }

        // Create linked list with loop
        ListNode head = createLinkedListWithLoop(values, loopPosition);
        
        // Find starting point of loop
        ListNode result = findStartingPointHelper(head);
        
        return result != null ? result.val : -1;
    }

    private ListNode findStartingPointHelper(ListNode head) {
        // Initialize slow and fast pointers to the head of the list
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect the loop
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            
            // Move fast two steps
            fast = fast.next.next;

            // If slow and fast meet, a loop is detected
            if (slow == fast) {
                // Reset the slow pointer to the head of the list
                slow = head;

                // Phase 2: Find the first node of the loop
                while (slow != fast) {
                    // Move slow and fast one step at a time
                    slow = slow.next;
                    fast = fast.next;
                }
                
                // Return the first node of the loop
                return slow;
            }
        }
        
        // If no loop is found, return null
        return null;
    }

    public List<Integer> flattenLinkedList(List<LinkedListRequest.MultiLevelNode> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return new ArrayList<>();
        }

        // Create multi-level linked list
        MultiLevelListNode head = createMultiLevelLinkedList(nodes);
        
        // Flatten the linked list
        head = flattenLinkedListHelper(head);
        
        // Convert back to list
        return convertFlattenedLinkedListToList(head);
    }

    private MultiLevelListNode flattenLinkedListHelper(MultiLevelListNode head) {
        // If head is null or there is no next node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten the rest of the linked list
        MultiLevelListNode mergedHead = flattenLinkedListHelper(head.next);

        // Merge the lists
        head = merge(head, mergedHead);
        return head;
    }

    private MultiLevelListNode merge(MultiLevelListNode list1, MultiLevelListNode list2) {
        // Create a dummy node as a placeholder for the result
        MultiLevelListNode dummyNode = new MultiLevelListNode(-1);
        MultiLevelListNode res = dummyNode;

        // Merge the lists based on data values
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }

        // Connect the remaining elements if any
        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }

        // Break the last node's link to prevent cycles
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        return dummyNode.child;
    }

    private MultiLevelListNode createMultiLevelLinkedList(List<LinkedListRequest.MultiLevelNode> nodes) {
        if (nodes.isEmpty()) return null;
        
        // Create all nodes first
        MultiLevelListNode[] nodeArray = new MultiLevelListNode[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            nodeArray[i] = new MultiLevelListNode(nodes.get(i).getVal());
        }
        
        // Set next and child pointers
        for (int i = 0; i < nodes.size(); i++) {
            LinkedListRequest.MultiLevelNode node = nodes.get(i);
            if (node.getNextIndex() >= 0 && node.getNextIndex() < nodes.size()) {
                nodeArray[i].next = nodeArray[node.getNextIndex()];
            }
            if (node.getChildIndex() >= 0 && node.getChildIndex() < nodes.size()) {
                nodeArray[i].child = nodeArray[node.getChildIndex()];
            }
        }
        
        return nodeArray[0];
    }

    private List<Integer> convertFlattenedLinkedListToList(MultiLevelListNode head) {
        List<Integer> result = new ArrayList<>();
        MultiLevelListNode current = head;
        
        while (current != null) {
            result.add(current.val);
            current = current.child;
        }
        
        return result;
    }

    // Multi-level linked list node class
    private static class MultiLevelListNode {
        int val;
        MultiLevelListNode next;
        MultiLevelListNode child;

        MultiLevelListNode(int val) {
            this.val = val;
            this.next = null;
            this.child = null;
        }
    }

    public int getIntersectionNode(List<Integer> list1, List<Integer> list2, int intersectionIndex1, int intersectionIndex2) {
        if (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty()) {
            return -1;
        }

        // Create linked lists with intersection
        ListNode head1 = createLinkedListWithIntersection(list1, list2, intersectionIndex1, intersectionIndex2, true);
        ListNode head2 = createLinkedListWithIntersection(list1, list2, intersectionIndex1, intersectionIndex2, false);
        
        // Find intersection node
        ListNode result = getIntersectionNodeHelper(head1, head2);
        
        return result != null ? result.val : -1;
    }

    private ListNode getIntersectionNodeHelper(ListNode headA, ListNode headB) {
        // Initialize two pointers, d1 and d2
        ListNode d1 = headA;
        ListNode d2 = headB;

        // Traverse both lists until the pointers meet
        while (d1 != d2) {
            // Move pointer d1 to the head of the second list if it reaches the end of the first list
            d1 = (d1 == null) ? headB : d1.next;
            // Move pointer d2 to the head of the first list if it reaches the end of the second list
            d2 = (d2 == null) ? headA : d2.next;
        }

        // Return the intersection node
        return d1;
    }

    private ListNode createLinkedListWithIntersection(List<Integer> list1, List<Integer> list2, int intersectionIndex1, int intersectionIndex2, boolean isFirstList) {
        if (isFirstList) {
            return createLinkedList(list1);
        } else {
            // For second list, we need to create it up to intersectionIndex2, then point to the intersection node
            if (intersectionIndex2 >= 0 && intersectionIndex2 < list2.size()) {
                ListNode head = new ListNode(list2.get(0));
                ListNode current = head;
                
                for (int i = 1; i <= intersectionIndex2; i++) {
                    ListNode newNode = new ListNode(list2.get(i));
                    current.next = newNode;
                    current = newNode;
                }
                
                // Point to the intersection node from list1
                if (intersectionIndex1 >= 0 && intersectionIndex1 < list1.size()) {
                    ListNode intersectionNode = createLinkedList(list1);
                    for (int i = 0; i < intersectionIndex1; i++) {
                        intersectionNode = intersectionNode.next;
                    }
                    current.next = intersectionNode;
                }
                
                return head;
            } else {
                return createLinkedList(list2);
            }
        }
    }

    public boolean hasCycle(List<Integer> values, int loopPosition) {
        if (values == null || values.isEmpty()) {
            return false;
        }

        // Create linked list with loop
        ListNode head = createLinkedListWithLoop(values, loopPosition);
        
        // Check for cycle
        return hasCycleHelper(head);
    }

    private boolean hasCycleHelper(ListNode head) {
        // Initialize two pointers, slow and fast, to the head of the linked list
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the linked list with the slow and fast pointers
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;

            // Check if slow and fast pointers meet
            if (slow == fast) {
                return true;  // Loop detected
            }
        }

        // If fast reaches the end of the list, there is no loop
        return false;
    }

    public boolean isPalindrome(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return true;
        }

        // Create linked list
        ListNode head = createLinkedList(values);
        
        // Check if palindrome
        return isPalindromeHelper(head);
    }

    private boolean isPalindromeHelper(ListNode head) {
        // Check if the linked list is empty or has only one node
        if (head == null || head.next == null) {
            // It's a palindrome by definition
            return true;
        }

        // Initialize two pointers, slow and fast, to find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the linked list to find the middle using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            // Move slow pointer one step
            slow = slow.next;
            // Move fast pointer two steps
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list starting from the middle
        ListNode newHead = reverseLinkedListHelper(slow.next);

        // Pointer to the first half
        ListNode first = head;
        // Pointer to the reversed second half
        ListNode second = newHead;
        while (second != null) {
            // Compare data values of nodes from both halves
            if (first.val != second.val) {
                // Reverse the second half back to its original state
                reverseLinkedListHelper(newHead);
                // Not a palindrome
                return false;
            }

            // Move the first pointer
            first = first.next;
            // Move the second pointer
            second = second.next;
        }

        // Reverse the second half back to its original state
        reverseLinkedListHelper(newHead);

        // Linked List is a palindrome
        return true;
    }

    public List<Integer> reverseLinkedList(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return new ArrayList<>();
        }

        // Create linked list
        ListNode head = createLinkedList(values);
        
        // Reverse the list
        head = reverseLinkedListHelper(head);
        
        // Convert back to list
        return convertLinkedListToList(head);
    }

    private ListNode reverseLinkedListHelper(ListNode head) {
        // Initialize 'temp' at head of linked list
        ListNode temp = head;
        
        // Initialize pointer 'prev' to NULL, representing the previous node
        ListNode prev = null;
        
        // Continue till 'temp' reaches the end (NULL)
        while (temp != null) {
            // Store the next node in 'front' to preserve the reference
            ListNode front = temp.next;
            
            // Reverse the direction of the current node's 'next' pointer to point to 'prev'
            temp.next = prev;
            
            // Move 'prev' to the current node for the next iteration
            prev = temp;
            
            // Move 'temp' to the 'front' node advancing the traversal
            temp = front;
        }
        
        // Return the new head of the reversed linked list
        return prev;
    }

    public List<Integer> reverseKGroup(List<Integer> values, int k) {
        if (values == null || values.isEmpty()) {
            return new ArrayList<>();
        }

        // Create linked list
        ListNode head = createLinkedList(values);
        
        // Reverse in groups of k
        head = reverseKGroupHelper(head, k);
        
        // Convert back to list
        return convertLinkedListToList(head);
    }

    private ListNode reverseKGroupHelper(ListNode head, int k) {
        // Initialize a temporary node to traverse the list
        ListNode temp = head;

        // Initialize a pointer to track the last node of the previous group
        ListNode prevLast = null;
        
        // Traverse through the linked list
        while (temp != null) {
            // Get the Kth node of the current group
            ListNode kThNode = getKthNode(temp, k);

            // If the Kth node is NULL (not a complete group)
            if (kThNode == null) {
                // If there was a previous group, link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                
                // Exit the loop
                break;
            }
            
            // Store the next node after the Kth node
            ListNode nextNode = kThNode.next;

            // Disconnect the Kth node to prepare for reversal
            kThNode.next = null;

            // Reverse the nodes from temp to the Kth node
            reverseLinkedListHelper(temp);
            
            // Adjust the head if the reversal starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous group to the reversed group
                prevLast.next = kThNode;
            }

            // Update the pointer to the last node of the previous group
            prevLast = temp;

            // Move to the next group
            temp = nextNode;
        }
        
        // Return the head of the modified linked list
        return head;
    }

    private ListNode getKthNode(ListNode temp, int k) {
        // Decrement K as we already start from the 1st node
        k -= 1;

        // Decrement K until it reaches the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;
            
            // Move to the next node
            temp = temp.next;
        }
        
        // Return the Kth node
        return temp;
    }

    public List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list1.isEmpty()) {
            return list2 != null ? list2 : new ArrayList<>();
        }
        if (list2 == null || list2.isEmpty()) {
            return list1;
        }

        // Create linked lists
        ListNode head1 = createLinkedList(list1);
        ListNode head2 = createLinkedList(list2);
        
        // Merge lists
        ListNode result = mergeTwoListsHelper(head1, head2);
        
        // Convert back to list
        return convertLinkedListToList(result);
    }

    private ListNode mergeTwoListsHelper(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the head of the merged list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            // Compare elements of both lists and link the smaller node to the merged list
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer to the next node
            temp = temp.next;
        }

        // If any list still has remaining elements, append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Return merged list
        return dummyNode.next;
    }

    public List<Integer> sortList(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return new ArrayList<>();
        }

        // Create linked list
        ListNode head = createLinkedList(values);
        
        // Sort the list
        head = sortListHelper(head);
        
        // Convert back to list
        return convertLinkedListToList(head);
    }

    private ListNode sortListHelper(ListNode head) {
        // Base case: if the list is empty or has only one node, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find middle of list using findMiddle function
        ListNode middle = findMiddle(head);
        
        // Divide the list into two halves
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;
        
        // Recursively sort left and right halves
        left = sortListHelper(left);
        right = sortListHelper(right);
        
        // Merge the sorted halves
        return mergeTwoSortedLinkedLists(left, right);
    }

    private ListNode findMiddle(ListNode head) {
        // If the list is empty or has only one node, the middle is the head itself
        if (head == null || head.next == null) {
            return head;
        }

        // Initializing slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // Move the fast pointer twice as fast as the slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
        // Create dummy node to serve as head of merged list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            // Compare elements of both lists and link the smaller node to the merged list
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer to the next node
            temp = temp.next;
        }

        // If any list still has remaining elements append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        // Return the merged list starting from the next of the dummy node
        return dummyNode.next;
    }

    public List<Integer> oddEvenList(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return new ArrayList<>();
        }

        // Create linked list
        ListNode head = createLinkedList(values);
        
        // Rearrange odd-even
        head = oddEvenListHelper(head);
        
        // Convert back to list
        return convertLinkedListToList(head);
    }

    private ListNode oddEvenListHelper(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Initialize pointers for odd and even nodes and keep track of the first even node
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        // Rearranging nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        // Connect the last odd node to the first even node
        odd.next = firstEven;

        return head;
    }

    public List<Integer> removeDuplicates(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return new ArrayList<>();
        }

        // Create doubly linked list
        ListNode head = createDoublyLinkedList(values);
        
        // Remove duplicates
        head = removeDuplicatesHelper(head);
        
        // Convert back to list
        return convertDoublyLinkedListToList(head);
    }

    private ListNode removeDuplicatesHelper(ListNode head) {
        ListNode temp = head;

        // Traverse the list
        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next;

            // Remove all duplicate nodes
            while (nextNode != null && nextNode.val == temp.val) {
                // Store the duplicate node
                ListNode duplicate = nextNode;
                // Move to the next node
                nextNode = nextNode.next;
                // Delete the duplicate node
                duplicate = null;
            }

            // Link the current node to the next non-duplicate node
            temp.next = nextNode;
            // Update previous pointer of next non-duplicate node
            if (nextNode != null) {
                nextNode.prev = temp;
            }

            // Move to the next node
            temp = temp.next;
        }

        return head;
    }

    public List<Integer> removeNthFromEnd(List<Integer> values, int n) {
        if (values == null || values.isEmpty()) {
            return new ArrayList<>();
        }

        // Create linked list
        ListNode head = createLinkedList(values);
        
        // Remove nth from end
        head = removeNthFromEndHelper(head, n);
        
        // Convert back to list
        return convertLinkedListToList(head);
    }

    private ListNode removeNthFromEndHelper(ListNode head, int n) {
        // Creating pointers
        ListNode fastp = head;
        ListNode slowp = head;

        // Move the fastp pointer N nodes ahead
        for (int i = 0; i < n; i++) {
            if (fastp == null) return head;
            fastp = fastp.next;
        }

        // If fastp becomes NULL, the Nth node from the end is the head
        if (fastp == null) {
            return head.next;
        }

        // Move both pointers until fastp reaches the end
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Delete the Nth node from the end
        slowp.next = slowp.next.next;
        return head;
    }

    public List<Integer> rotateRight(List<Integer> values, int k) {
        if (values == null || values.isEmpty()) {
            return new ArrayList<>();
        }

        // Create linked list
        ListNode head = createLinkedList(values);
        
        // Rotate right by k steps
        head = rotateRightHelper(head, k);
        
        // Convert back to list
        return convertLinkedListToList(head);
    }

    private ListNode rotateRightHelper(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) 
            return head;

        // Calculating length
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }

        // Link last node to first node
        temp.next = head;
        // When k is more than length of list
        k = k % length; 
        // To get end of the list
        int end = length - k; 
        while (end-- > 0) 
            temp = temp.next;

        // Breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;

        return head;
    }

    // Copy a linked list with random pointers
    public List<LinkedListRequest.RandomListNodeDTO> copyRandomList(List<LinkedListRequest.RandomListNodeDTO> nodes) {
        if (nodes == null || nodes.isEmpty()) return new ArrayList<>();
        // Step 1: Build original node list
        List<RandomListNode> origNodes = new ArrayList<>();
        for (LinkedListRequest.RandomListNodeDTO dto : nodes) {
            origNodes.add(new RandomListNode(dto.getVal()));
        }
        // Step 2: Set next and random pointers
        for (int i = 0; i < nodes.size(); i++) {
            Integer nextIdx = nodes.get(i).getNextIndex();
            Integer randIdx = nodes.get(i).getRandomIndex();
            if (nextIdx != null && nextIdx >= 0 && nextIdx < nodes.size()) {
                origNodes.get(i).next = origNodes.get(nextIdx);
            }
            if (randIdx != null && randIdx >= 0 && randIdx < nodes.size()) {
                origNodes.get(i).random = origNodes.get(randIdx);
            }
        }
        // Step 3: Clone the list
        RandomListNode head = origNodes.get(0);
        RandomListNode clonedHead = copyRandomListInternal(head);
        // Step 4: Collect cloned nodes in order
        Map<RandomListNode, Integer> nodeToIndex = new HashMap<>();
        List<RandomListNode> clonedNodes = new ArrayList<>();
        RandomListNode temp = clonedHead;
        int idx = 0;
        while (temp != null) {
            nodeToIndex.put(temp, idx++);
            clonedNodes.add(temp);
            temp = temp.next;
        }
        // Step 5: Build DTOs for output
        List<LinkedListRequest.RandomListNodeDTO> result = new ArrayList<>();
        for (int i = 0; i < clonedNodes.size(); i++) {
            RandomListNode node = clonedNodes.get(i);
            Integer nextIdx = node.next != null ? nodeToIndex.get(node.next) : null;
            Integer randIdx = node.random != null ? nodeToIndex.get(node.random) : null;
            result.add(new LinkedListRequest.RandomListNodeDTO(node.val, nextIdx, randIdx));
        }
        return result;
    }
    // Internal node class for random list
    private static class RandomListNode {
        int val;
        RandomListNode next, random;
        RandomListNode(int val) { this.val = val; }
    }
    // Internal logic from CopyRandomList.java
    private RandomListNode copyRandomListInternal(RandomListNode head) {
        if (head == null) return null;
        // Insert copy nodes
        RandomListNode temp = head;
        while (temp != null) {
            RandomListNode copy = new RandomListNode(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }
        // Set random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        // Separate the lists
        temp = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyCurr = dummy;
        while (temp != null) {
            copyCurr.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            copyCurr = copyCurr.next;
        }
        return dummy.next;
    }
} 