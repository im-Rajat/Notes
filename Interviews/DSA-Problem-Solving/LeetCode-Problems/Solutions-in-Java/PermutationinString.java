// 567. Permutation in String
// https://leetcode.com/problems/permutation-in-string/

class Solution
{
    public boolean checkInclusion(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if(s2 == null || len2 == 0 || len1 > len2)
        {
            return false;
        }
        
        if(len1 == 0)
        {
            return true;
        }
        
        int[] hashmap1 = new int[26];
        int[] hashmap2 = new int[26];
        
        for(int i = 0; i < len1; i++)
        {
            hashmap1[s1.charAt(i) - 'a']++;
            hashmap2[s2.charAt(i) - 'a']++;
        }
        
        int i = 0;
        int j = len1 - 1;
        while(j < len2)
        {
            if(isPermutation(hashmap1, hashmap2))
            {
                return true;
            }
            hashmap2[s2.charAt(i) - 'a']--;
            i++;
            j++;
            if (j < len2)
                hashmap2[s2.charAt(j) - 'a']++;
        }
        
        if(isPermutation(hashmap1, hashmap2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean isPermutation(int[] hashmap1, int[] hashmap2)
    {
        for(int i = 0; i < hashmap2.length; i++)
        {
            if(hashmap1[i] != hashmap2[i])
            {
                return false;
            }
        }
        return true;
    }
}
