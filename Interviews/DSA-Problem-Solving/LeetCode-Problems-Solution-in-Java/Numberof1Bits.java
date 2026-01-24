// 191. Number of 1 Bits
// https://leetcode.com/problems/number-of-1-bits/


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int output = 0;
        // int mask = 1;
        
        for(int i = 0; i < 32; i++) {
            output = output + ((n >> i) & 1);
            
            // if((n & mask) != 0) {
            //     output++;
            // }
            // mask = mask << 1;
        }
        
        return output;
        
//         int output = 0;
        
//         while(n != 0) {
//             output = output + (n & 1);
//             n = n >>> 1;
//         }
        
//         return output;
        
        // return Integer.bitCount(n);      // one line solution (inbuild function)
    }
}
