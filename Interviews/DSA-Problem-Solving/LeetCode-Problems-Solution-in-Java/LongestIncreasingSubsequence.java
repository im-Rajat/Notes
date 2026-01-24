// 300. Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/


class Solution {
    public int lengthOfLIS(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 0;
        
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}


// class Solution {
//     public int lengthOfLIS(int[] nums){

//         if (nums.length <= 1) {
//             return nums.length;
//         }

//         List<Integer> result = new ArrayList<>();
//         result.add(nums[0]);

//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > result.get(result.size() - 1)) {
//                 result.add(nums[i]);
//             }
//             else {   // can use binary search here to reduct complexity to nlogn.
//                 int j = 0;
//                 while (j < result.size()) {
//                     if (result.get(j) >= nums[i]) {
//                         result.set(j, nums[i]);
//                         break;
//                     }
//                     j++;
//                 }
//             }
//         }

//         return result.size();
//     }
// }
