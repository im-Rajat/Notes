// 693. Binary Number with Alternating Bits
// https://leetcode.com/problems/binary-number-with-alternating-bits/


class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n <= 1) {
            return true;
        }
        
        int prev = n % 2;
        n = n / 2;
        
        while(n > 0) {
            if(n % 2 != prev) {
                prev = n % 2;
                n = n / 2;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}
