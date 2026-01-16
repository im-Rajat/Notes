// 229. Majority Element II
// https://leetcode.com/problems/majority-element-ii/


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = -1;
        int ele2 = -1;
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == ele1) {
                count1++;
            }
            else if (nums[i] == ele2) {
                count2++;
            }
            else if (count1 == 0) {
                ele1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0) {
                ele2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(ele1 == nums[i]) {
                count1++;
            }
            else if(ele2 == nums[i]) {
                count2++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        if (count1 > nums.length/3) {
            result.add(ele1);
        }
        
        if (count2 > nums.length/3) {
            result.add(ele2);
        }
        
       
        return result;
    }
}
