// 297. Serialize and Deserialize Binary Tree
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Using Level Order Traversal ( Using Queue)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (queue.isEmpty() == false) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                sb.append("n ");
            }
            else {
                sb.append(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodesVal = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(nodesVal[0]));
        queue.add(root);
        
        // while (q.isEmpty() == false) // both will work
        for (int i = 1; i < nodesVal.length; i = i + 2) {
            TreeNode parent = queue.poll();
            
            if (nodesVal[i].equals("n") == false) {
                TreeNode left = new TreeNode(Integer.parseInt(nodesVal[i]));
                parent.left = left;
                queue.add(left);
            }
            
            if (nodesVal[i + 1].equals("n") == false) {
                TreeNode right = new TreeNode(Integer.parseInt(nodesVal[i + 1]));
                parent.right = right;
                queue.add(right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
