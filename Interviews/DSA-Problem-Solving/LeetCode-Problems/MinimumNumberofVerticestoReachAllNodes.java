// 1557. Minimum Number of Vertices to Reach All Nodes
// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/


class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        
        for (int i = 0; i < edges.size(); i++) {
            arr[edges.get(i).get(1)]++;
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }
        
        return list;
    }
}
