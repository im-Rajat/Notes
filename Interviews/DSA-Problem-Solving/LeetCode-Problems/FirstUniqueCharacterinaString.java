// 387. First Unique Character in a String
// https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {
    public int firstUniqChar(String s)
    {
        int[] hashmap = new int[26];
        
        int len = s.length();
        
        for(int i = 0; i < len; i++)
        {
            hashmap[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < len; i++)
        {
            if(hashmap[s.charAt(i) - 'a'] == 1)
            {
                return i;
            }
        }
        
        return -1;
    }
}
