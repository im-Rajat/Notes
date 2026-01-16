// 53. Maximum Subarray
// https://leetcode.com/problems/maximum-subarray/

class Solution
{
    public int maxSubArray(int[] nums)
    {
        int count = 0;
        int max_num = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < 0)
            {
                count += 1;
                max_num = Math.max(max_num, nums[i]);
            }  
        }
        
        if(count == nums.length)
        {
            return max_num;
        }
        
        int local_sum = 0;
        int global_sum = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            local_sum = local_sum + nums[i];
            if(local_sum > global_sum)
            {
                global_sum = local_sum;
            }
            
            if(local_sum < 0)
            {
                local_sum = 0;
            }
        }
        
        return global_sum;
        
    }
}
