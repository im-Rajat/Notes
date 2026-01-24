// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/


// Using Heap (Priority Queue)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for (int key : map.keySet()) {
            heap.add(key);
            
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] result = new int[k];
        int i = k - 1;
        
        while (heap.isEmpty() == false) {
            result[i] = heap.poll();
            i--;
        }
        
        return result;
    }
}
