// 973. K Closest Points to Origin
// https://leetcode.com/problems/k-closest-points-to-origin/


// Using Max Heap (Priority Queue)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
    
        Queue<int[]> heap = new PriorityQueue<>((p1, p2) -> (p2[0]*p2[0] + p2[1]*p2[1]) - (p1[0]*p1[0] + p1[1]*p1[1]));
        
        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        
        int[][] result = new int[k][2];
        
        int i = k - 1;
        while (heap.isEmpty() == false) {
            result[i] = heap.poll();
            i--;
        }
        
        return result;
    }
}



/*
// Using Map and Max Heap (Priority Queue)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distance = (x * x) + (y * y);
            map.put(i, distance);
        }
        
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
        
        for (int key : map.keySet()) {
            heap.add(key);
            
            if (heap.size() > k) {
                heap.remove();
            }
        }
        
        int[][] result = new int[k][2];
        
        int i = 0;
        while (heap.isEmpty() == false) {
            int index = heap.poll();
            result[i][0] = points[index][0];
            result[i][1] = points[index][1];
            i++;
        }
        
        return result;
    }
}
*/
