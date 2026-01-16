// 43. Multiply Strings
// https://leetcode.com/problems/multiply-strings/


class Solution {
    public String multiply(String num1, String num2) {
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        if(len1 == 0 || len2 == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
//         if(num1.equals("1")) {
//             return num2;
//         }
        
//         if(num2.equals("1")) {
//             return num1;
//         }
        
        int[] result = new int[len1 + len2];
        
        for(int i = len1 - 1; i >= 0; i--) {
            for(int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                mul = mul + result[i + j + 1];
                result[i + j + 1] = mul % 10;
                result[i + j] = result[i + j] + mul / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int num : result) {
            if(sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }
        
        return sb.toString();
    }
}
