// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t)
    {
        int len1 = s.length();
        int len2 = t.length();
        
        if(len1 != len2)
        {
            return false;
        }
        
        int[] hash_map = new int[26];
        
        for(char c : s.toCharArray())
        {
            hash_map[c - 'a']++;
        }
        
        for(char c : t.toCharArray())
        {
            if(hash_map[c - 'a'] == 0)
            {
                return false;
            }
            hash_map[c - 'a']--;
        }
        
        return true;
    }
}
