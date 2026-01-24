// 977. Squares of a Sorted Array
// https://leetcode.com/problems/squares-of-a-sorted-array/

class Solution
{
    public int[] sortedSquares(int[] nums)
    {
        int low = 0;
        int high = nums.length - 1;
        
        int[] sorted_squares = new int[nums.length];
        
        int i = high;
        
        while(low <= high)
        {
            int temp_low = nums[low] * nums[low];
            int temp_high = nums[high] * nums[high];
            if(temp_low < temp_high)
            {
                sorted_squares[i] = temp_high;
                i--;
                high -= 1;
            }
            else
            {
                sorted_squares[i] = temp_low;
                i--;
                low += 1;
            }
        }
        
        return sorted_squares;
        
    }
}
