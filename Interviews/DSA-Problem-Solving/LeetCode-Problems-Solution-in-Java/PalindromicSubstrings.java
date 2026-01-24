// 647. Palindromic Substrings
// https://leetcode.com/problems/palindromic-substrings/


class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        
        for(int d = 0; d < len; d++) {
            int r = 0;
            int c = d;
            
            while (c < len) {
                if(d == 0) {
                    dp[r][c] = true;
                    count++;
                }
                else if (d == 1) {
                    if(s.charAt(r) == s.charAt(c)) {
                        dp[r][c] = true;
                        count++;
                    }
                    else {
                        dp[r][c] = false;
                    }
                }
                else {
                    if(s.charAt(r) == s.charAt(c) && dp[r+1][c-1] == true) {
                        dp[r][c] = true;
                        count++;
                    }
                    else {
                        dp[r][c] = false;
                    }
                }
                
                r++;
                c++;
            }
        }
        
        return count;
    }
}
