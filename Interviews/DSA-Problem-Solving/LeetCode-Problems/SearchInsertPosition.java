// 35. Search Insert Position
// https://leetcode.com/problems/search-insert-position/

class Solution
{
    public int searchInsert(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        
        if(target < nums[low])
        {
            return 0;
        }
        if(target > nums[high])
        {
            return high + 1;
        }
        
        while(low <= high)
        {
            mid = low + ((high - low) / 2);
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return low;
    }
}
