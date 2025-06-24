package com.example.dsa.heaps;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class HeapsService {

    // 1. Min-heap to Max-heap converter
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDownMax(nums, i);
        }
        return nums;
    }
    private void heapifyDownMax(int[] arr, int ind) {
        int n = arr.length;
        int largestInd = ind;
        int left = 2 * ind + 1, right = 2 * ind + 2;
        if (left < n && arr[left] > arr[largestInd]) largestInd = left;
        if (right < n && arr[right] > arr[largestInd]) largestInd = right;
        if (largestInd != ind) {
            int temp = arr[largestInd]; arr[largestInd] = arr[ind]; arr[ind] = temp;
            heapifyDownMax(arr, largestInd);
        }
    }

    // 2. Heap Sort
    public int[] heapSort(int[] nums) {
        buildMaxHeap(nums);
        int last = nums.length - 1;
        while (last > 0) {
            int temp = nums[0]; nums[0] = nums[last]; nums[last] = temp;
            last--;
            heapifyDownMax(nums, 0, last);
        }
        return nums;
    }
    public void buildMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDownMax(nums, i, n - 1);
        }
    }
    private void heapifyDownMax(int[] arr, int ind, int last) {
        int largestInd = ind;
        int left = 2 * ind + 1, right = 2 * ind + 2;
        if (left <= last && arr[left] > arr[largestInd]) largestInd = left;
        if (right <= last && arr[right] > arr[largestInd]) largestInd = right;
        if (largestInd != ind) {
            int temp = arr[largestInd]; arr[largestInd] = arr[ind]; arr[ind] = temp;
            heapifyDownMax(arr, largestInd, last);
        }
    }

    // 3. Kth Largest in stream (class-based, not stateless)
    public static class KthLargest {
        private int K;
        private PriorityQueue<Integer> pq;
        public KthLargest(int k, int[] nums) {
            K = k;
            pq = new PriorityQueue<>();
            for (int num : nums) {
                if (pq.size() < K) pq.offer(num);
                else if (num > pq.peek()) {
                    pq.poll(); pq.offer(num);
                }
            }
        }
        public int add(int val) {
            if (pq.size() < K) pq.offer(val);
            else if (val > pq.peek()) {
                pq.poll(); pq.offer(val);
            }
            return pq.peek();
        }
    }

    // 4. Kth Largest Element in array
    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) pq.add(nums[i]);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll(); pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    // 5. MaxHeap operations (basic, stateless for API)
    public static class MaxHeap {
        private List<Integer> arr = new ArrayList<>();
        public void insert(int key) {
            arr.add(key);
            heapifyUp(arr.size() - 1);
        }
        private void heapifyUp(int ind) {
            int parent = (ind - 1) / 2;
            if (ind > 0 && arr.get(ind) > arr.get(parent)) {
                int temp = arr.get(ind); arr.set(ind, arr.get(parent)); arr.set(parent, temp);
                heapifyUp(parent);
            }
        }
        public void changeKey(int index, int newVal) {
            if (arr.get(index) < newVal) {
                arr.set(index, newVal); heapifyUp(index);
            } else {
                arr.set(index, newVal); heapifyDown(index);
            }
        }
        private void heapifyDown(int ind) {
            int n = arr.size();
            int largest = ind, left = 2 * ind + 1, right = 2 * ind + 2;
            if (left < n && arr.get(left) > arr.get(largest)) largest = left;
            if (right < n && arr.get(right) > arr.get(largest)) largest = right;
            if (largest != ind) {
                int temp = arr.get(largest); arr.set(largest, arr.get(ind)); arr.set(ind, temp);
                heapifyDown(largest);
            }
        }
        public void extractMax() {
            int last = arr.size() - 1;
            int temp = arr.get(last); arr.set(last, arr.get(0)); arr.set(0, temp);
            arr.remove(last); heapifyDown(0);
        }
        public boolean isEmpty() { return arr.isEmpty(); }
        public int getMax() { return arr.get(0); }
        public int heapSize() { return arr.size(); }
    }

    // 6. MinHeap operations (basic, stateless for API)
    public static class MinHeap {
        private List<Integer> arr = new ArrayList<>();
        public void insert(int key) {
            arr.add(key);
            heapifyUp(arr.size() - 1);
        }
        private void heapifyUp(int ind) {
            int parent = (ind - 1) / 2;
            if (ind > 0 && arr.get(ind) < arr.get(parent)) {
                int temp = arr.get(ind); arr.set(ind, arr.get(parent)); arr.set(parent, temp);
                heapifyUp(parent);
            }
        }
        public void changeKey(int index, int newVal) {
            if (arr.get(index) > newVal) {
                arr.set(index, newVal); heapifyUp(index);
            } else {
                arr.set(index, newVal); heapifyDown(index);
            }
        }
        private void heapifyDown(int ind) {
            int n = arr.size();
            int smallest = ind, left = 2 * ind + 1, right = 2 * ind + 2;
            if (left < n && arr.get(left) < arr.get(smallest)) smallest = left;
            if (right < n && arr.get(right) < arr.get(smallest)) smallest = right;
            if (smallest != ind) {
                int temp = arr.get(smallest); arr.set(smallest, arr.get(ind)); arr.set(ind, temp);
                heapifyDown(smallest);
            }
        }
        public void extractMin() {
            int last = arr.size() - 1;
            int temp = arr.get(last); arr.set(last, arr.get(0)); arr.set(0, temp);
            arr.remove(last); heapifyDown(0);
        }
        public boolean isEmpty() { return arr.isEmpty(); }
        public int getMin() { return arr.get(0); }
        public int heapSize() { return arr.size(); }
    }

    // 7. MinHeap Validator
    public boolean isMinHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            int left = 2 * i + 1, right = 2 * i + 2;
            if (left < n && nums[left] < nums[i]) return false;
            if (right < n && nums[right] < nums[i]) return false;
        }
        return true;
    }

    // 8. Build MinHeap from array
    public int[] buildMinHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDownMin(nums, i);
        }
        return nums;
    }
    private void heapifyDownMin(int[] arr, int ind) {
        int n = arr.length;
        int smallest = ind, left = 2 * ind + 1, right = 2 * ind + 2;
        if (left < n && arr[left] < arr[smallest]) smallest = left;
        if (right < n && arr[right] < arr[smallest]) smallest = right;
        if (smallest != ind) {
            int temp = arr[smallest]; arr[smallest] = arr[ind]; arr[ind] = temp;
            heapifyDownMin(arr, smallest);
        }
    }

    // 9. MinHeap Adjuster (change value at index)
    public int[] adjustMinHeap(int[] nums, int ind, int val) {
        if (nums[ind] > val) {
            nums[ind] = val;
            heapifyUpMin(nums, ind);
        } else {
            nums[ind] = val;
            heapifyDownMin(nums, ind);
        }
        return nums;
    }
    private void heapifyUpMin(int[] arr, int ind) {
        int parent = (ind - 1) / 2;
        if (ind > 0 && arr[ind] < arr[parent]) {
            int temp = arr[ind]; arr[ind] = arr[parent]; arr[parent] = temp;
            heapifyUpMin(arr, parent);
        }
    }

    // Alias for minToMaxHeap for controller compatibility
    public int[] heapConverter(int[] nums) {
        return minToMaxHeap(nums);
    }

    // Alias for heapSort for controller compatibility
    public int[] heapSorter(int[] nums) {
        return heapSort(nums);
    }

    // Alias for buildMaxHeap for controller compatibility
    public int[] maxHeap(int[] nums) {
        buildMaxHeap(nums);
        return nums;
    }

    // Alias for buildMinHeap for controller compatibility
    public int[] minHeap(int[] nums) {
        return buildMinHeap(nums);
    }

    // Alias for adjustMinHeap for controller compatibility
    public int[] minHeapAdjuster(int[] nums, int index) {
        // For demonstration, adjust value at index to value+1
        return adjustMinHeap(nums, index, nums[index] + 1);
    }

    // Alias for buildMinHeap for controller compatibility
    public int[] minHeapBuilder(int[] nums) {
        return buildMinHeap(nums);
    }

    // Alias for isMinHeap for controller compatibility
    public boolean minHeapValidator(int[] nums) {
        return isMinHeap(nums);
    }
} 