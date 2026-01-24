// 226. Invert Binary Tree
// https://leetcode.com/problems/invert-binary-tree/

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.right = left;
        root.left = right;
        
        return root;
    }
    
//     public TreeNode invertTree(TreeNode root) {
//         if(root == null) {
//             return root;
//         }
        
//         invert(root);
        
//         return root;
//     }
    
//     public void invert(TreeNode root) {
//         if(root == null) {
//             return;
//         }
        
//         TreeNode temp = root.left;
//         root.left = root.right;
//         root.right = temp;
        
//         invert(root.left);
//         invert(root.right);
//     }
}
