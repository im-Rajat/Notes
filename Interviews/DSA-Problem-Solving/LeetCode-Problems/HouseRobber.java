// 198. House Robber
// https://leetcode.com/problems/house-robber/


class Solution {
    public int rob(int[] nums) {
        
        int[] dp = new int[nums.length + 1];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        
        return dp[nums.length];
        
    }
//     public int rob(int[] nums) {
        
//         if(nums.length == 1) {
//             return nums[0];
//         }
        
//         if(nums.length == 2) {
//             return Math.max(nums[0], nums[1]);
//         }
        
//         int[] dp = new int[nums.length + 1];
        
//         dp[0] = nums[0];
//         dp[1] = nums[1];
        
//         int max_num = dp[0];
        
//         for(int i = 2; i < nums.length; i++) {
//             dp[i] = Math.max(dp[i-2] + nums[i], max_num + nums[i]);
//             max_num = Math.max(dp[i-1], max_num);
//         }
        
//         return Math.max(max_num, dp[nums.length - 1]);
//     }
}
