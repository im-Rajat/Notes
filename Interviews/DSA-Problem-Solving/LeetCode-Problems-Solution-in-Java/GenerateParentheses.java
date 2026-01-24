// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        generateAll("(", 1, 0, res, n);
        
        return res;
    }
    
    public void generateAll(String curr, int open, int close, List<String> res, int n) {
        if(curr.length() == 2 * n) {
            res.add(curr);
            return;
        }
        
        if(open < n) {
            generateAll(curr + "(", open + 1, close, res, n);
        }
        
        if(close < open) {
            generateAll(curr + ")", open, close + 1, res, n);
        }
    }
}
