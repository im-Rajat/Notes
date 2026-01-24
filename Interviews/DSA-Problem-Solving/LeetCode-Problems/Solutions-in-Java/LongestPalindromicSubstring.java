// 5. Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/


class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        
        boolean[][] dp = new boolean[len][len];
        
        int maxlen = 0;
        int start = 0;
        int end = 0;
        
        for (int g = 0; g < len; g++) {
            int r = 0;
            int c = g;
            
            while(c < len) {
                if(g == 0) {
                    dp[r][c] = true;
                    if(c - r + 1 > maxlen) {
                        maxlen = c - r + 1;
                        start = r;
                        end = c;
                    }
                }
                else if(g == 1) {
                    if(s.charAt(r) == s.charAt(c)) {
                        dp[r][c] = true;
                        if(c - r + 1 > maxlen) {
                            maxlen = c - r + 1;
                            start = r;
                            end = c;
                        }
                    }
                }
                else {
                    if(s.charAt(r) == s.charAt(c) && dp[r + 1][c - 1] == true) {
                        dp[r][c] = true;
                        if(c - r + 1 > maxlen) {
                            maxlen = c - r + 1;
                            start = r;
                            end = c;
                        }
                    }
                }
                c++;
                r++;
            }
        }
        
        return s.substring(start, end + 1);
    }
}
