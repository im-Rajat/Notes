// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        int left = 0;
        int right = 0;
        int max = 0;
        
        HashSet<Character> hash_set = new HashSet<>();
        
        while(right < s.length())
        {
            if(!hash_set.contains(s.charAt(right)))
            {
                hash_set.add(s.charAt(right));
                right++;
                max = Math.max(hash_set.size(), max);
            }
            else
            {
                hash_set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
