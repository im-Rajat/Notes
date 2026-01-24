// 103. Binary Tree Zigzag Level Order Traversal
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean reverse = false;
        
        while (queue.isEmpty() == false) {
            int size = queue.size();
            
            List<Integer> curr = new ArrayList<>();
            
            while (size > 0) {
                TreeNode temp = queue.poll();
                
                if (reverse) {
                    curr.add(0, temp.val);
                }
                else {
                    curr.add(temp.val);
                }
                
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                size--;
            }
            
            result.add(curr);
            reverse = !reverse;
        }
        
        return result;   
    }
}




// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
//         List<List<Integer>> result = new ArrayList<>();
        
//         if (root == null) {
//             return result;
//         }
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         boolean reverse = false;
        
//         while (queue.isEmpty() == false) {
//             int size = queue.size();
            
//             List<Integer> curr = new ArrayList<>();
            
//             while (size > 0) {
//                 TreeNode temp = queue.poll();
//                 curr.add(temp.val);
                
//                 if (temp.left != null) {
//                     queue.add(temp.left);
//                 }
//                 if (temp.right != null) {
//                     queue.add(temp.right);
//                 }
                
//                 size--;
//             }
            
//             if (reverse) {
//                 Collections.reverse(curr);
//             }
            
//             result.add(curr);
//             reverse = !reverse;
//         }
        
//         return result;
//     }
// }
