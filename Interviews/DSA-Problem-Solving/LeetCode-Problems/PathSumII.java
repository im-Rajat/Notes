// 113. Path Sum II
// https://leetcode.com/problems/path-sum-ii/


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtracking(root, targetSum, new ArrayList<>(), result);
        
        return result;
    }
    
    public void backtracking(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        curr.add(root.val);
        
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList(curr));
            return;
        }
        
        if (root.left != null) {
            backtracking(root.left, targetSum - root.val, curr, result);
            curr.remove(curr.size() - 1);
        }
        
        if (root.right != null) {
            backtracking(root.right, targetSum - root.val, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
