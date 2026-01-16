// 199. Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/


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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (queue.isEmpty() == false) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == size - 1) {
                    result.add(temp.val);
                }
                
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        
        return result;
    }
}

// // Using Reverse Level Order Traversal
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
        
//         List<Integer> result = new ArrayList<>();
        
//         if (root == null) {
//             return result;
//         }
        
//         Queue<TreeNode> queue = new LinkedList<>();
        
//         queue.add(root);
        
//         while (queue.isEmpty() == false) {
//             int size = queue.size();
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode temp = queue.poll();
//                 if (i == 0) {
//                     result.add(temp.val);
//                 }
                
//                 if (temp.right != null) {
//                     queue.add(temp.right);
//                 }
                
//                 if (temp.left != null) {
//                     queue.add(temp.left);
//                 }
//             }
//         }
        
//         return result;
//     }
// }
