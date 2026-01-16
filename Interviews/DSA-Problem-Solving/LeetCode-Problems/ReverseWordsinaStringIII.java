// 557. Reverse Words in a String III
// https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution
{
    public String reverseWords(String s)
    {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        
        String[] words = s.split(" ");
        StringBuilder output = new StringBuilder();
        
        for(String word : words)
        {
            StringBuilder temp = new StringBuilder();
            temp.append(word);
            temp.reverse();
            output.append(temp.toString() + " ");
        }
        
        output.setLength(s.length());
        return output.toString();
    }
}
