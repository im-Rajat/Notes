// 116. Populating Next Right Pointers in Each Node
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution
{
    public Node connect(Node root)
    {
        if(root == null)
        {
            return root;
        }
        
        Node leftNode = root;
        
        while(leftNode.left != null)
        {
            Node temp = leftNode;
            
            while(temp != null)
            {
                temp.left.next = temp.right;
                if(temp.next != null)
                {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            
            leftNode = leftNode.left;
        }
        
        return root;
    }
}
