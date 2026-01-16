// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

class Solution
{
    public boolean isValid(String s)
    {
        int len = s.length();
        
        if(len % 2 != 0)
        {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            }
            else if(c == ')' && !stack.isEmpty() && stack.peek() == '(')
            {
                stack.pop();
            }
            else if(c == ']' && !stack.isEmpty() && stack.peek() == '[')
            {
                stack.pop();
            }
            else if(c == '}' && !stack.isEmpty() && stack.peek() == '{')
            {
                stack.pop();
            }
            else
            {
                return false;
            }
        }
        
        if(stack.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
