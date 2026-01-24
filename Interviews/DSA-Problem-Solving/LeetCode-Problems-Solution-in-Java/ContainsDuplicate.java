// 217. Contains Duplicate
// https://leetcode.com/problems/contains-duplicate/

class Solution
{
    public boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> numbers = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(numbers.contains(nums[i]))
            {
                return true;
            }
            numbers.add(nums[i]);
        }
        return false;
    }
}
