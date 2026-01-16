// 98. Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/

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
    
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    
    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        
        if(min != null && root.val <= min) {
            return false;
        }
        
        if(max != null && root.val >= max) {
            return false;
        }
        
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
    
//     LinkedList<Integer> ll = new LinkedList<>();
    
//     public boolean isValidBST(TreeNode root) {
//         if(root.left == null && root.right == null) {
//             return true;
//         }
        
//         inorder(root);
        
//         for(int i = 1; i < ll.size(); i++) {
//             if(ll.get(i-1) >= ll.get(i)) {
//                 return false;
//             }
//         }
        
//         return true;
//     }
    
//     public void inorder(TreeNode root) {
//         if(root.left != null) {
//             inorder(root.left);
//         }
//         ll.add(root.val);
//         if(root.right!=null) {
//             inorder(root.right);
//         }
//     }
}
