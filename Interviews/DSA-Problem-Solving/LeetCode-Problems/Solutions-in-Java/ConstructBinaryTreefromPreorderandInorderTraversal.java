// 105. Construct Binary Tree from Preorder and Inorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


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

// using hashmap, easy to understand
class Solution {
    HashMap<Integer, Integer> inorderIndexMap;
    int preorderIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        preorderIndex = 0;
        
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return arrayToTree(0, preorder.length - 1, preorder);
    }
    
    public TreeNode arrayToTree(int start, int end, int[] preorder) {
        if (start > end) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;
        
        node.left = arrayToTree(start, inorderIndexMap.get(node.val) - 1, preorder);
        node.right = arrayToTree(inorderIndexMap.get(node.val) + 1, end, preorder);
        
        return node;
    }
}



// // without using hashmap
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if (preorder.length == 0 || inorder.length == 0) {
//             return null;
//         }
        
//         return treeHelper(0, 0, inorder.length - 1, preorder, inorder);
//     }
    
//     public TreeNode treeHelper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
//         if (preStart > preorder.length - 1 || inStart > inEnd) {
//             return null;
//         }

//         TreeNode node = new TreeNode(preorder[preStart]);

//         int inIndex = 0;
//         for (int i = 0; i < inorder.length; i++) {
//             if (inorder[i] == node.val) {
//                 inIndex = i;
//                 break;
//             }
//         }

//         node.left = treeHelper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
//         node.right = treeHelper(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);

//         return node;
//     }
// }
