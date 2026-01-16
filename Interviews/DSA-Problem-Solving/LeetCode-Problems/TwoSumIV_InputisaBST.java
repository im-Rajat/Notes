// 653. Two Sum IV - Input is a BST
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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
    HashSet<Integer> hs = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) {
            return false;
        }

        if(hs.contains(k - root.val)) {
            return true;
        }
        else {
            hs.add(root.val);
        }

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
