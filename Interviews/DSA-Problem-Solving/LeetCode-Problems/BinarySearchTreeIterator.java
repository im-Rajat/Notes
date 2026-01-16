// 173. Binary Search Tree Iterator
// https://leetcode.com/problems/binary-search-tree-iterator/


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
// Using stack, Average Time complexity is O(1) and Space complexity is O(h);
class BSTIterator {
    
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        partialInorder(root);
    }
    
    public void partialInorder(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        TreeNode top = stack.pop();
        partialInorder(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }
}



// // Using list, Time complexity is O(1) but Space complexity is O(n);
// class BSTIterator {

//     List<Integer> list = new ArrayList<>();
//     int index = 0;
    
//     public BSTIterator(TreeNode root) {
//         inorder(root);
//     }
    
//     public void inorder(TreeNode root) {
//         if (root == null) {
//             return;
//         }
        
//         inorder(root.left);
//         list.add(root.val);
//         inorder(root.right);
//     }
    
//     public int next() {
//         return list.get(index++);
//     }
    
//     public boolean hasNext() {
//         if (index < list.size()) {
//             return true;
//         }
//         else {
//             return false;
//         }
//     }
// }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
