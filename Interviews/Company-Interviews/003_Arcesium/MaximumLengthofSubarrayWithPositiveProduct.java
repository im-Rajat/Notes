// Arcesium 1st Coding Round - HackerRank
// 1567. Maximum Length of Subarray With Positive Product
// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/


class Solution {
    public int getMaxLen(int[] nums) {
        
        int firstNeg = -1;
        int lastZero = -1;
        int countNeg = 0;
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                countNeg++;
                if (firstNeg == -1) {
                    firstNeg = i;
                }
            }
            
            if (nums[i] == 0) {
                firstNeg = -1;
                lastZero = i;
                countNeg = 0;
            }
            else {
                if (countNeg % 2 == 0) {
                    result = Math.max(result, i - lastZero);
                }
                else {
                    result = Math.max(result, i - firstNeg);
                }
            }
        }
        
        return result;
    }
}


// class Solution {
//     public int getMaxLen(int[] nums) {
        
//         int len = nums.length;
//         int[][] dp = new int[len + 1][2];
        
//         int result = 0;
        
//         for (int i = 0; i < len; i++) {
//             if (nums[i] > 0) {
//                 dp[i + 1][0] = 1 + dp[i][0];
//                 if (dp[i][1] > 0) {
//                     dp[i + 1][1] = 1 + dp[i][1];
//                 }
//             }
            
//             if (nums[i] < 0) {
//                 dp[i + 1][1] = 1 + dp[i][0];
//                 if (dp[i][1] > 0) {
//                     dp[i + 1][0] = 1 + dp[i][1];
//                 }
//             }
            
//             result = Math.max(result, dp[i + 1][0]);
//         }
        
//         return result;
//     }
// }