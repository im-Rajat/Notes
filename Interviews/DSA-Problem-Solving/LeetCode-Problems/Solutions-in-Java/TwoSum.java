// 1. Two Sum
// https://leetcode.com/problems/two-sum/

class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> nums_map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            int temp = target - nums[i];
            if(nums_map.containsKey(temp))
            {
                return new int[] {nums_map.get(temp), i};
            }
            nums_map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No match found!");
    }
}
