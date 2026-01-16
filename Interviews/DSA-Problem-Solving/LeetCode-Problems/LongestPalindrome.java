// 409. Longest Palindrome
// https://leetcode.com/problems/longest-palindrome/


class Solution {
    public int longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s.length();
        }
        
        int[] set = new int[128];
        int count = 0;
        
        for(char c : s.toCharArray()) {
            set[c]++;
            if(set[c] == 2) {
                count = count + 2;
                set[c] = 0;
            }
        }
        
        if(count == s.length()) {
            return count;
        }
        
        return count + 1;
    }
}


// class Solution {
//     public int longestPalindrome(String s) {
//         if(s.length() <= 1) {
//             return s.length();
//         }
        
//         int count = 0;
//         HashSet<Character> set = new HashSet<>();
        
//         for(int i = 0; i < s.length(); i++) {
//             if(set.contains(s.charAt(i))) {
//                 count++;
//                 set.remove(s.charAt(i));
//             }
//             else {
//                 set.add(s.charAt(i));
//             }
//         }
        
//         if(set.isEmpty()) {
//             return count * 2;
//         }
        
//         return count * 2 + 1;
//     }
// }



// class Solution {
//     public int longestPalindrome(String s) {
//         if(s.length() <= 1) {
//             return s.length();
//         }
        
//         int[] lowerCase = new int[26];
//         int[] upparCase = new int[26];
        
//         for(int i = 0; i < s.length(); i++) {
//             char temp = s.charAt(i);
//             if(temp >= 'a' && temp <= 'z') {
//                 lowerCase[temp - 'a']++;
//             }
//             else {
//                 upparCase[temp - 'A']++;
//             }
//         }
        
//         int count = 0;
        
//         for (int i = 0; i < 26; i++) {
//             count = count + (lowerCase[i] / 2);
//             count = count + (upparCase[i] / 2);
//         }
        
//         if(count * 2 == s.length()) {
//             return count * 2;
//         }
        
//         return count * 2 + 1;
//     }
// }
