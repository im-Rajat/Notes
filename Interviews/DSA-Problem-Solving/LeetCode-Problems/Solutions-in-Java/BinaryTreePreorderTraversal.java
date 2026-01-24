// 144. Binary Tree Preorder Traversal
// https://leetcode.com/problems/binary-tree-preorder-traversal/

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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> pre = new ArrayList<>();
        
        if(root == null) {
            return pre;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            pre.add(temp.val);
            
            if(temp.right != null) {
                stack.push(temp.right);
            }
            
            if(temp.left != null) {
                stack.push(temp.left);
            }
        }
        
        return pre;
        
    }
//     public List<Integer> preorderTraversal(TreeNode root) {
        
//         List<Integer> pre = new ArrayList<>();
        
//         preorder(pre, root);
        
//         return pre;
//     }
    
//     void preorder(List<Integer> pre, TreeNode root) {
//         if(root == null) {
//             return;
//         }
        
//         pre.add(root.val);
//         preorder(pre, root.left);
//         preorder(pre, root.right);
//     }
}
