// 1249. Minimum Remove to Make Valid Parentheses
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/


class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            }
            else if (c == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(c);
        }

        if (open == 0) {
            return sb.toString();
        }

        StringBuilder result = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {
            if (open > 0 && sb.charAt(i) == '(') {
                open--;
                continue;
            }

            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }
}
