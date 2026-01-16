// 145. Binary Tree Postorder Traversal
// https://leetcode.com/problems/binary-tree-postorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        
        if(root == null) {
            return output;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            output.add(0, temp.val);
            
            if(temp.left != null) {
                stack.push(temp.left);
            }
            
            if(temp.right != null) {
                stack.push(temp.right);
            }
        }
        
        return output;
        
    }
//     public List<Integer> postorderTraversal(TreeNode root) {
        
//         List<Integer> output = new ArrayList<>();
        
//         postorder(output, root);
        
//         return output;
//     }
    
//     public void postorder(List<Integer> output, TreeNode root) {
//         if(root == null) {
//             return;
//         }
        
//         postorder(output, root.left);
//         postorder(output, root.right);
//         output.add(root.val);
//     }
}
