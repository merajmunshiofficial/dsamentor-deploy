package com.example.dsa.linkedlist;

import java.util.List;

public class LinkedListResponse {
    private List<Integer> result;
    private boolean hasCycle;
    private int loopLength;
    private int startingPoint;
    private int intersectionValue;
    private List<Integer> flattenedList;
    private List<Integer> sortedList;
    private List<Integer> rotatedList;
    private List<Integer> reversedList;
    private List<Integer> oddEvenList;
    private List<Integer> removedDuplicatesList;
    private List<Integer> removedNthFromEndList;
    private List<Integer> addedOneList;
    private List<Integer> addedTwoNumbersList;
    private List<Integer> copiedRandomList;
    private List<Integer> deletedAllOccurrencesList;
    private List<Integer> deletedMiddleList;
    private List<LinkedListRequest.RandomListNodeDTO> randomListResult;

    public LinkedListResponse() {}
    public LinkedListResponse(List<Integer> result) { this.result = result; }

    public List<Integer> getResult() { return result; }
    public void setResult(List<Integer> result) { this.result = result; }

    public List<LinkedListRequest.RandomListNodeDTO> getRandomListResult() { return randomListResult; }
    public void setRandomListResult(List<LinkedListRequest.RandomListNodeDTO> randomListResult) { this.randomListResult = randomListResult; }

    public int getLoopLength() { return loopLength; }
    public void setLoopLength(int loopLength) { this.loopLength = loopLength; }

    public int getStartingPoint() { return startingPoint; }
    public void setStartingPoint(int startingPoint) { this.startingPoint = startingPoint; }

    public boolean isHasCycle() { return hasCycle; }
    public void setHasCycle(boolean hasCycle) { this.hasCycle = hasCycle; }

    public List<Integer> getFlattenedList() { return flattenedList; }
    public void setFlattenedList(List<Integer> flattenedList) { this.flattenedList = flattenedList; }

    public List<Integer> getSortedList() { return sortedList; }
    public void setSortedList(List<Integer> sortedList) { this.sortedList = sortedList; }

    public List<Integer> getRotatedList() { return rotatedList; }
    public void setRotatedList(List<Integer> rotatedList) { this.rotatedList = rotatedList; }

    public List<Integer> getReversedList() { return reversedList; }
    public void setReversedList(List<Integer> reversedList) { this.reversedList = reversedList; }

    public List<Integer> getOddEvenList() { return oddEvenList; }
    public void setOddEvenList(List<Integer> oddEvenList) { this.oddEvenList = oddEvenList; }

    public List<Integer> getRemovedDuplicatesList() { return removedDuplicatesList; }
    public void setRemovedDuplicatesList(List<Integer> removedDuplicatesList) { this.removedDuplicatesList = removedDuplicatesList; }

    public List<Integer> getRemovedNthFromEndList() { return removedNthFromEndList; }
    public void setRemovedNthFromEndList(List<Integer> removedNthFromEndList) { this.removedNthFromEndList = removedNthFromEndList; }

    public List<Integer> getAddedOneList() { return addedOneList; }
    public void setAddedOneList(List<Integer> addedOneList) { this.addedOneList = addedOneList; }

    public List<Integer> getAddedTwoNumbersList() { return addedTwoNumbersList; }
    public void setAddedTwoNumbersList(List<Integer> addedTwoNumbersList) { this.addedTwoNumbersList = addedTwoNumbersList; }

    public List<Integer> getCopiedRandomList() { return copiedRandomList; }
    public void setCopiedRandomList(List<Integer> copiedRandomList) { this.copiedRandomList = copiedRandomList; }

    public List<Integer> getDeletedAllOccurrencesList() { return deletedAllOccurrencesList; }
    public void setDeletedAllOccurrencesList(List<Integer> deletedAllOccurrencesList) { this.deletedAllOccurrencesList = deletedAllOccurrencesList; }

    public List<Integer> getDeletedMiddleList() { return deletedMiddleList; }
    public void setDeletedMiddleList(List<Integer> deletedMiddleList) { this.deletedMiddleList = deletedMiddleList; }

    public int getIntersectionValue() { return intersectionValue; }
    public void setIntersectionValue(int intersectionValue) { this.intersectionValue = intersectionValue; }
} 