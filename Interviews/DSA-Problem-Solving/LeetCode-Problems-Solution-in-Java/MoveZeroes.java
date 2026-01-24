// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/

class Solution
{
    public void moveZeroes(int[] nums)
    {
        if(nums.length <= 1)
        {
            return;
        }
        
        int l = 0;
        int r = 0;
        int temp;
        
        while(r < nums.length)
        {
            if(nums[r]==0)
            {
                r++;
            }
            else
            {
                temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
                r++;
            }
        }
    }
}
