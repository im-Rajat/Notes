// 215. Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array/


// Using Min Heap (Priority Qeueu)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        return minHeap.peek();
    }
}



/*
// Using Sorting
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        return nums[n - k];
    }
}
*/
