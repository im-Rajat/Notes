// 231. Power of Two
// https://leetcode.com/problems/power-of-two/


class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }
        
        while(n > 1 && (n & 1) == 0) {
            n = n >> 1;
        }
        
        if(n == 1) {
            return true;
        }
        else {
            return false;
        }   
    }
    
//     public boolean isPowerOfTwo(int n) {
//         if (n == 0) {
//             return false;
//         }
        
//         if((n & (~(n - 1))) == n) {
//             return true;
//         }
//         else {
//             return false;
//         }
            
//     }
}
