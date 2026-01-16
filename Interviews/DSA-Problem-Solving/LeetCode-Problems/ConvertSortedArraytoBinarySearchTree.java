// 108. Convert Sorted Array to Binary Search Tree
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/


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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        
        TreeNode head = BST(nums, 0, nums.length - 1);
        return head;
    }
    
    public TreeNode BST(int[] nums, int low, int high) {
        
        if (low > high) {
            return null;
        }
        
        int mid = low + (high - low) / 2;
        
        TreeNode node = new TreeNode(nums[mid]);
        node.left = BST(nums, low, mid - 1);
        node.right = BST(nums, mid + 1, high);
        
        return node;
    }
}
