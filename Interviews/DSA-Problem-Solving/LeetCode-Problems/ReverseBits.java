// 190. Reverse Bits
// https://leetcode.com/problems/reverse-bits/


public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result = result << 1;
            result = result | (n & 1);
            n = n >> 1;
        }
        
        return result;
    }
    
    
//     public int reverseBits(int n) {
//         List<Integer> list = new ArrayList<>();
        
//         for(int i = 0; i < 32; i++) {
//             list.add(n & 1);
//             n  = n >> 1;
//         }
        
//         int result = 0;
        
//         for(int i = 0; i < list.size(); i++) {
//             result = result << 1;
//             result = result | list.get(i);
//         }
        
//         return result;
//     }
}
