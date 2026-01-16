// 435. Non-overlapping Intervals
// https://leetcode.com/problems/non-overlapping-intervals/


class Solution {
    public int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length <= 1) {
            return 0;
        }
        
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        int count = 0;
        
        int current_end = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++) {
            if (current_end > intervals[i][0]) {
                count++;
                current_end = Math.min(current_end, intervals[i][1]);
            }
            else {
                current_end = intervals[i][1];
            }
        }
        
        return count;
    }
//     public int eraseOverlapIntervals(int[][] intervals){
        
//         if(intervals.length <= 1) {
//             return 0;
//         }
        
//         Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
//         int count = 0;
        
//         int[] current_interval = intervals[0];
        
//         for(int[] interval : intervals) {
//             if(current_interval == interval) {
//                 continue;
//             }
//             int current_begin = current_interval[0];
//             int current_end = current_interval[1];
            
//             int next_begin = interval[0];
//             int next_end = interval[1];
            
//             if(next_begin < current_end) {
//                 count++;
//                 current_interval[1] = Math.min(interval[1], current_interval[1]);
//             }
//             else {
//                 current_interval = interval;
//             }
//         }
        
//         return count;
//     }
}
