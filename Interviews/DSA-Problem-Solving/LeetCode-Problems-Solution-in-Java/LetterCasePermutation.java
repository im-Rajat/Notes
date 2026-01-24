// 784. Letter Case Permutation
// https://leetcode.com/problems/letter-case-permutation/


class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> output = new ArrayList<>();
        
        generatePermutations(s, output, 0);
        
        return output;
    }
    
    public void generatePermutations(String s, List<String> output, int index) {
        output.add(s);
        
        for(int i = index; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            
            if(Character.isLetter(chars[i])) {
                if(Character.isUpperCase(chars[i])) {
                    chars[i] = Character.toLowerCase(chars[i]);
                    generatePermutations(String.valueOf(chars), output, i + 1);
                }
                else {
                    chars[i] = Character.toUpperCase(chars[i]);
                    generatePermutations(String.valueOf(chars), output, i + 1);
                }
            }
        }
    }
}
