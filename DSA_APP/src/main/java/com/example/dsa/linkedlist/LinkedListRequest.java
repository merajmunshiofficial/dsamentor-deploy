package com.example.dsa.linkedlist;

import jakarta.validation.constraints.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkedListRequest {
    public static class AddOneInput {
        @NotNull
        @Size(min = 1)
        private List<Integer> values;

        public List<Integer> getValues() { return values; }
        public void setValues(List<Integer> values) { this.values = values; }
        @JsonProperty("Values")
        public void setValuesUpper(List<Integer> values) { this.values = values; }
        @JsonProperty("values")
        public void setValuesLower(List<Integer> values) { this.values = values; }
    }

    public static class AddTwoNumbersInput {
        @NotNull
        @Size(min = 1)
        private List<Integer> l1;
        @NotNull
        @Size(min = 1)
        private List<Integer> l2;

        public List<Integer> getL1() { return l1; }
        public void setL1(List<Integer> l1) { this.l1 = l1; }
        @JsonProperty("L1")
        public void setL1Upper(List<Integer> l1) { this.l1 = l1; }
        @JsonProperty("l1")
        public void setL1Lower(List<Integer> l1) { this.l1 = l1; }
        public List<Integer> getL2() { return l2; }
        public void setL2(List<Integer> l2) { this.l2 = l2; }
        @JsonProperty("L2")
        public void setL2Upper(List<Integer> l2) { this.l2 = l2; }
        @JsonProperty("l2")
        public void setL2Lower(List<Integer> l2) { this.l2 = l2; }
    }

    public static class DeleteAllOccurrencesInput {
        private List<Integer> values;
        private int target;

        public DeleteAllOccurrencesInput() {}

        public DeleteAllOccurrencesInput(List<Integer> values, int target) {
            this.values = values;
            this.target = target;
        }

        public List<Integer> getValues() {
            return values;
        }

        public void setValues(List<Integer> values) {
            this.values = values;
        }
        @JsonProperty("Values")
        public void setValuesUpper(List<Integer> values) { this.values = values; }
        @JsonProperty("values")
        public void setValuesLower(List<Integer> values) { this.values = values; }

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }
        @JsonProperty("Target")
        public void setTargetUpper(int target) { this.target = target; }
        @JsonProperty("target")
        public void setTargetLower(int target) { this.target = target; }
    }

    public static class FindLengthOfLoopInput {
        private List<Integer> values;
        private int loopPosition; // -1 if no loop

        public FindLengthOfLoopInput() {}

        public FindLengthOfLoopInput(List<Integer> values, int loopPosition) {
            this.values = values;
            this.loopPosition = loopPosition;
        }

        public List<Integer> getValues() {
            return values;
        }

        public void setValues(List<Integer> values) {
            this.values = values;
        }
        @JsonProperty("Values")
        public void setValuesUpper(List<Integer> values) { this.values = values; }
        @JsonProperty("values")
        public void setValuesLower(List<Integer> values) { this.values = values; }

        public int getLoopPosition() {
            return loopPosition;
        }

        public void setLoopPosition(int loopPosition) {
            this.loopPosition = loopPosition;
        }
        @JsonProperty("LoopPosition")
        public void setLoopPositionUpper(int loopPosition) { this.loopPosition = loopPosition; }
        @JsonProperty("loopPosition")
        public void setLoopPositionLower(int loopPosition) { this.loopPosition = loopPosition; }
    }

    public static class FlattenLinkedListInput {
        private List<MultiLevelNode> nodes;

        public FlattenLinkedListInput() {}

        public FlattenLinkedListInput(List<MultiLevelNode> nodes) {
            this.nodes = nodes;
        }

        public List<MultiLevelNode> getNodes() {
            return nodes;
        }

        public void setNodes(List<MultiLevelNode> nodes) {
            this.nodes = nodes;
        }
        @JsonProperty("Nodes")
        public void setNodesUpper(List<MultiLevelNode> nodes) { this.nodes = nodes; }
        @JsonProperty("nodes")
        public void setNodesLower(List<MultiLevelNode> nodes) { this.nodes = nodes; }
    }

    public static class MultiLevelNode {
        private int val;
        private int nextIndex; // -1 if null
        private int childIndex; // -1 if null

        public MultiLevelNode() {}

        public MultiLevelNode(int val, int nextIndex, int childIndex) {
            this.val = val;
            this.nextIndex = nextIndex;
            this.childIndex = childIndex;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
        @JsonProperty("Val")
        public void setValUpper(int val) { this.val = val; }
        @JsonProperty("val")
        public void setValLower(int val) { this.val = val; }

        public int getNextIndex() {
            return nextIndex;
        }

        public void setNextIndex(int nextIndex) {
            this.nextIndex = nextIndex;
        }
        @JsonProperty("NextIndex")
        public void setNextIndexUpper(int nextIndex) { this.nextIndex = nextIndex; }
        @JsonProperty("nextIndex")
        public void setNextIndexLower(int nextIndex) { this.nextIndex = nextIndex; }

        public int getChildIndex() {
            return childIndex;
        }

        public void setChildIndex(int childIndex) {
            this.childIndex = childIndex;
        }
        @JsonProperty("ChildIndex")
        public void setChildIndexUpper(int childIndex) { this.childIndex = childIndex; }
        @JsonProperty("childIndex")
        public void setChildIndexLower(int childIndex) { this.childIndex = childIndex; }
    }

    public static class ListInput {
        private List<Integer> values;

        public ListInput() {}

        public ListInput(List<Integer> values) {
            this.values = values;
        }

        public List<Integer> getValues() {
            return values;
        }

        public void setValues(List<Integer> values) {
            this.values = values;
        }
        @JsonProperty("Values")
        public void setValuesUpper(List<Integer> values) { this.values = values; }
        @JsonProperty("values")
        public void setValuesLower(List<Integer> values) { this.values = values; }
    }

    public static class GetIntersectionNodeInput {
        private List<Integer> list1;
        private List<Integer> list2;
        private int intersectionIndex1; // Index in list1 where intersection starts
        private int intersectionIndex2; // Index in list2 where intersection starts

        public GetIntersectionNodeInput() {}

        public GetIntersectionNodeInput(List<Integer> list1, List<Integer> list2, int intersectionIndex1, int intersectionIndex2) {
            this.list1 = list1;
            this.list2 = list2;
            this.intersectionIndex1 = intersectionIndex1;
            this.intersectionIndex2 = intersectionIndex2;
        }

        public List<Integer> getList1() {
            return list1;
        }

        public void setList1(List<Integer> list1) {
            this.list1 = list1;
        }
        @JsonProperty("List1")
        public void setList1Upper(List<Integer> list1) { this.list1 = list1; }
        @JsonProperty("list1")
        public void setList1Lower(List<Integer> list1) { this.list1 = list1; }

        public List<Integer> getList2() {
            return list2;
        }

        public void setList2(List<Integer> list2) {
            this.list2 = list2;
        }
        @JsonProperty("List2")
        public void setList2Upper(List<Integer> list2) { this.list2 = list2; }
        @JsonProperty("list2")
        public void setList2Lower(List<Integer> list2) { this.list2 = list2; }

        public int getIntersectionIndex1() {
            return intersectionIndex1;
        }

        public void setIntersectionIndex1(int intersectionIndex1) {
            this.intersectionIndex1 = intersectionIndex1;
        }
        @JsonProperty("IntersectionIndex1")
        public void setIntersectionIndex1Upper(int intersectionIndex1) { this.intersectionIndex1 = intersectionIndex1; }
        @JsonProperty("intersectionIndex1")
        public void setIntersectionIndex1Lower(int intersectionIndex1) { this.intersectionIndex1 = intersectionIndex1; }

        public int getIntersectionIndex2() {
            return intersectionIndex2;
        }

        public void setIntersectionIndex2(int intersectionIndex2) {
            this.intersectionIndex2 = intersectionIndex2;
        }
        @JsonProperty("IntersectionIndex2")
        public void setIntersectionIndex2Upper(int intersectionIndex2) { this.intersectionIndex2 = intersectionIndex2; }
        @JsonProperty("intersectionIndex2")
        public void setIntersectionIndex2Lower(int intersectionIndex2) { this.intersectionIndex2 = intersectionIndex2; }
    }

    public static class RemoveNthFromEndInput {
        private List<Integer> values;
        private int n;

        public RemoveNthFromEndInput() {}

        public RemoveNthFromEndInput(List<Integer> values, int n) {
            this.values = values;
            this.n = n;
        }

        public List<Integer> getValues() {
            return values;
        }

        public void setValues(List<Integer> values) {
            this.values = values;
        }
        @JsonProperty("Values")
        public void setValuesUpper(List<Integer> values) { this.values = values; }
        @JsonProperty("values")
        public void setValuesLower(List<Integer> values) { this.values = values; }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
        @JsonProperty("N")
        public void setNUpper(int n) { this.n = n; }
        @JsonProperty("n")
        public void setNLower(int n) { this.n = n; }
    }

    public static class ReverseKGroupInput {
        private List<Integer> values;
        private int k;

        public ReverseKGroupInput() {}

        public ReverseKGroupInput(List<Integer> values, int k) {
            this.values = values;
            this.k = k;
        }

        public List<Integer> getValues() {
            return values;
        }

        public void setValues(List<Integer> values) {
            this.values = values;
        }
        @JsonProperty("Values")
        public void setValuesUpper(List<Integer> values) { this.values = values; }
        @JsonProperty("values")
        public void setValuesLower(List<Integer> values) { this.values = values; }

        public int getK() {
            return k;
        }

        public void setK(int k) {
            this.k = k;
        }
        @JsonProperty("K")
        public void setKUpper(int k) { this.k = k; }
        @JsonProperty("k")
        public void setKLower(int k) { this.k = k; }
    }

    public static class RotateRightInput {
        private List<Integer> values;
        private int k;

        public RotateRightInput() {}

        public RotateRightInput(List<Integer> values, int k) {
            this.values = values;
            this.k = k;
        }

        public List<Integer> getValues() {
            return values;
        }

        public void setValues(List<Integer> values) {
            this.values = values;
        }
        @JsonProperty("Values")
        public void setValuesUpper(List<Integer> values) { this.values = values; }
        @JsonProperty("values")
        public void setValuesLower(List<Integer> values) { this.values = values; }

        public int getK() {
            return k;
        }

        public void setK(int k) {
            this.k = k;
        }
        @JsonProperty("K")
        public void setKUpper(int k) { this.k = k; }
        @JsonProperty("k")
        public void setKLower(int k) { this.k = k; }
    }

    public static class RandomListNodeDTO {
        private int val;
        private Integer nextIndex; // null if no next
        private Integer randomIndex; // null if no random

        public RandomListNodeDTO() {}
        public RandomListNodeDTO(int val, Integer nextIndex, Integer randomIndex) {
            this.val = val;
            this.nextIndex = nextIndex;
            this.randomIndex = randomIndex;
        }
        public int getVal() { return val; }
        public void setVal(int val) { this.val = val; }
        @JsonProperty("Val")
        public void setValUpper(int val) { this.val = val; }
        @JsonProperty("val")
        public void setValLower(int val) { this.val = val; }
        public Integer getNextIndex() { return nextIndex; }
        public void setNextIndex(Integer nextIndex) { this.nextIndex = nextIndex; }
        @JsonProperty("NextIndex")
        public void setNextIndexUpper(Integer nextIndex) { this.nextIndex = nextIndex; }
        @JsonProperty("nextIndex")
        public void setNextIndexLower(Integer nextIndex) { this.nextIndex = nextIndex; }
        public Integer getRandomIndex() { return randomIndex; }
        public void setRandomIndex(Integer randomIndex) { this.randomIndex = randomIndex; }
        @JsonProperty("RandomIndex")
        public void setRandomIndexUpper(Integer randomIndex) { this.randomIndex = randomIndex; }
        @JsonProperty("randomIndex")
        public void setRandomIndexLower(Integer randomIndex) { this.randomIndex = randomIndex; }
    }

    public static class CopyRandomListInput {
        private List<RandomListNodeDTO> nodes;
        public CopyRandomListInput() {}
        public CopyRandomListInput(List<RandomListNodeDTO> nodes) { this.nodes = nodes; }
        public List<RandomListNodeDTO> getNodes() { return nodes; }
        public void setNodes(List<RandomListNodeDTO> nodes) { this.nodes = nodes; }
        @JsonProperty("Nodes")
        public void setNodesUpper(List<RandomListNodeDTO> nodes) { this.nodes = nodes; }
        @JsonProperty("nodes")
        public void setNodesLower(List<RandomListNodeDTO> nodes) { this.nodes = nodes; }
    }
}