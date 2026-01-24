// 75. Sort Colors
// https://leetcode.com/problems/sort-colors/


class Solution {
    public void sortColors(int[] nums) {
     
        int index0  = 0;
        int index2 = nums.length - 1;
        int i = 0;
        
        while (i <= index2 && index0 < index2) {
            if (nums[i] == 0) {
                nums[i] = nums[index0];
                nums[index0] = 0;
                i++;
                index0++;
            }
            else if (nums[i] == 2) {
                nums[i] = nums[index2];
                nums[index2] = 2;
                index2--;
            }
            else {
                i++;
            }
        }
    }
}
