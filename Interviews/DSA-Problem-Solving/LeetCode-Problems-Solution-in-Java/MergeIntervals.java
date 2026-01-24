// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/


class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        List<int[]> result = new ArrayList<>();
        
        int[] current_interval = intervals[0];
        result.add(current_interval);
        
        for(int[] interval : intervals) {
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            
            int next_begin = interval[0];
            int next_end = interval[1];
            
            if(current_end >= next_begin) {
                current_interval[1] = Math.max(current_end, next_end);
            }
            else {
                current_interval = interval;
                result.add(current_interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
