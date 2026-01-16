// 26. Remove Duplicates from Sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/


class Solution {
    public int removeDuplicates(int[] nums) {
        
        int l = 0;
        int r = 1;
        
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        
        return l + 1;
    }
}
