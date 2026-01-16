// 15. 3Sum
// https://leetcode.com/problems/3sum/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        int len = nums.length;
        if(len < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i < len -1; i++) {
            if(i > 0 && nums[i] == nums[i -1]) {
                continue;
            }
            
            int sum = 0 - nums[i];
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k) {
                if(nums[j] + nums[k] == sum) {
                    List<Integer>temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    // result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while(j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(nums[j] + nums[k] > sum) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        
        
        return result;
    }
}
