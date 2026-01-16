// 415. Add Strings
// https://leetcode.com/problems/add-strings/


class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        int i = len1 - 1;
        int j = len2 -  1;
        int c = 0;

        String result = "";

        while (i >= 0 || j >= 0 || c > 0) {
            int temp1, temp2;

            if (i >= 0) {
                temp1 = num1.charAt(i) - '0';
            }
            else {
                temp1 = 0;
            }

            if (j >= 0) {
                temp2 = num2.charAt(j) - '0';
            }
            else {
                temp2 = 0;
            }

            int sum = temp1 + temp2 + c;
            result = (sum % 10) + result;
            c = sum / 10;
            i--;
            j--;
        }

        return result;
    }
}

// class Solution {
//    public String addStrings(String num1, String num2) {
//         int len1 = num1.length();
//         int len2 = num2.length();

//         int i = len1 - 1;
//         int j = len2 -  1;
//         int c = 0;

//         StringBuilder result = new StringBuilder();

//         while (i >=0 && j >= 0) {
//             int temp = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + c;
//             result.append(temp % 10);
//             c = temp / 10;
//             // System.out.println(temp);
//             i--;
//             j--;
//         }

//         while (i >= 0) {
//             int temp = (num1.charAt(i) - '0') + c;
//             result.append(temp % 10);
//             c = temp / 10;
//             i--;
//         }

//         while (j >= 0) {
//             int temp = (num2.charAt(j) - '0') + c;
//             result.append(temp % 10);
//             c = temp / 10;
//             j--;
//         }
       
//         if (c > 0) {
//             result.append(c);
//         }

//         result.reverse();
//         return result.toString();
//     }
// }
