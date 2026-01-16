// 334. Increasing Triplet Subsequence
// https://leetcode.com/problems/increasing-triplet-subsequence/


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        
        if(len < 3) {
            return false;
        }
        
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i++) {
            if(nums[i] <= firstMin) {
                firstMin = nums[i];
            }
            else if (nums[i] <= secondMin) {
                secondMin = nums[i];
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}
