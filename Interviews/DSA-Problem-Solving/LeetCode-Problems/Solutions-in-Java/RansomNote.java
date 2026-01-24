// 383. Ransom Note
// https://leetcode.com/problems/ransom-note/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine)
    {
        int[] hash_map = new int[26];
        
        for(char c : magazine.toCharArray())
        {
            hash_map[c - 'a']++;
        }
        
        for(char c : ransomNote.toCharArray())
        {
            if(hash_map[c - 'a'] == 0)
            {
                return false;
            }
            hash_map[c - 'a']--;
        }
        
        return true;
        
        
//         int len1 = ransomNote.length();
//         int len2 = magazine.length();
        
//         if(len1 > len2)
//         {
//             return false;
//         }
        
//         int[] hash_map1 = new int[26];
//         int[] hash_map2 = new int[26];
        
//         for(int i = 0; i < len1; i++)
//         {
//             hash_map1[ransomNote.charAt(i) - 'a']++;
//         }
//         for(int i = 0; i < len2; i++)
//         {
//             hash_map2[magazine.charAt(i) - 'a']++;
//         }
        
//         for(int i = 0; i < 26; i++)
//         {
//             if(hash_map1[i] > hash_map2[i])
//             {
//                 return false;
//             }
//         }
        
//         return true;
    }
}
