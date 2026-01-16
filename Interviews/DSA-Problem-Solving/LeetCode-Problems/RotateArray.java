// 189. Rotate Array
// https://leetcode.com/problems/rotate-array/

class Solution
{
    public void rotate(int[] nums, int k)
    {
        int len = nums.length;
        int i, j;
        k = k % len;
        
        for(i = 0, j = len - 1; i <= j; i++, j--)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        for(i = 0, j = k-1; i <= j ; i++, j--)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        for(i = k, j = len - 1; i <=j ; i++, j--)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
    }
}
