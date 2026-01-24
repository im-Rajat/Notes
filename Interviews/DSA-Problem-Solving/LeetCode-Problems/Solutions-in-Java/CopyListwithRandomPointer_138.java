// 138. Copy List with Random Pointer
// https://leetcode.com/problems/copy-list-with-random-pointer/


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        
        Node curr = head;
        
        while (curr != null) {
            Node nextNode = curr.next;
            Node newNode = new Node(curr.val);
            
            curr.next = newNode;
            newNode.next = nextNode;
            curr = curr.next.next;
        }
        
        curr = head;
        
        while (curr != null) {
            Node nextNode = curr.next;
            
            if (curr.random != null) {
                nextNode.random = curr.random.next;
            }
            
            curr = curr.next.next;
        }
        
        curr = head;
        Node newHead = curr.next;
        
        while (curr != null) {
            Node temp = curr.next;
            curr.next = temp.next;
            
            if (curr.next != null) {
                temp.next = curr.next.next;
            }
            
            curr = curr.next;
        }
        
        return newHead;
    }
}
