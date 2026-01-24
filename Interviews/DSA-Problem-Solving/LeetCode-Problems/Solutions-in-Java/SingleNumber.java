// 136. Single Number
// https://leetcode.com/problems/single-number/


class Solution {
    public int singleNumber(int[] nums) {
        int output = nums[0];
        for(int i = 1; i < nums.length; i++) {
            output = output ^ nums[i];
        }
        
        return output;
    }
}

// Can use hashmap also
