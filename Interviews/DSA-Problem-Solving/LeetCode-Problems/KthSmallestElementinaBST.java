// 230. Kth Smallest Element in a BST
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/


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
// Using Inorder Traversal
class Solution {
    int count;
    int result;
    
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        
        usingInorder(root, k);
        
        return result;
    }
    
    public void usingInorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        
        usingInorder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        if (count < k) {
            usingInorder(root.right, k);
        }
    }
}


// // Using Stack
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         Stack<TreeNode> stack = new Stack<>();
        
//         while (true) {
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
            
//             root = stack.pop();
//             if (--k == 0) {
//                 return root.val;
//             }
//             root = root.right;
//         }
//     }
// }


// // Using Inorder Traversal and list
// class Solution {
    
//     List<Integer> list = new LinkedList<>();
        
//     public int kthSmallest(TreeNode root, int k) {
//         inorder(root);
        
//         return list.get(k - 1);
        
//     }
    
//     public void inorder(TreeNode root) {
//         if (root == null) {
//             return;
//         }
        
//         inorder(root.left);
//         list.add(root.val);
//         inorder(root.right);
        
//     }
// }
