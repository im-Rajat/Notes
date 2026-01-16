// 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        
        int[] output = new int[len];
        
        output[0] = 1;
        
        for(int i = 1; i < len; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        
        int prev_product = 1;
        for(int i = len - 1; i >=0; i--) {
            output[i] = prev_product * output[i];
            prev_product = prev_product * nums[i];
        }
        
        return output;
    }
}


// class Solution {
//     public int[] productExceptSelf(int[] nums) {
        
//         int len = nums.length;
        
//         int[] left_products = new int[len];
//         int[] right_products = new int[len];
        
//         left_products[0] = 1;
        
//         for(int i = 1; i < len; i++) {
//             left_products[i] = left_products[i - 1] * nums[i - 1];
//         }
        
//         right_products[len - 1] = 1;
        
//         for(int i = len - 2; i >= 0; i--) {
//             right_products[i] = right_products[i + 1] * nums[i + 1];
//         }
        
//         int[] output = new int[len];
        
//         for(int i = 0; i < len; i++) {
//             output[i] = left_products[i] * right_products[i];
//         }
        
//         return output;
//     }
// }
