// 94. Binary Tree Inorder Traversal
// https://leetcode.com/problems/binary-tree-inorder-traversal/

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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        
        if(root == null) {
            return output;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
            
        }
        
        return output;
    }
    
//     public List<Integer> inorderTraversal(TreeNode root) {
        
//         List<Integer> output = new ArrayList<>();
        
//         inorder(output, root);
        
//         return output;
//     }
    
//     public void inorder(List<Integer> output, TreeNode root) {
        
//         if(root == null) {
//             return;
//         }
        
//         inorder(output, root.left);
//         output.add(root.val);
//         inorder(output, root.right);
//     }
}
