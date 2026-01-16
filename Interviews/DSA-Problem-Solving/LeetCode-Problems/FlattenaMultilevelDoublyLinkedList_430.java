// 430. Flatten a Multilevel Doubly Linked List
// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/


/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
// Using Stack
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        
        Stack<Node> stack = new Stack<>();
        
        Node curr = head;
        
        while (curr !=  null) {
            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            }
            else {
                if (curr.next == null && stack.isEmpty() == false) {
                    curr.next = stack.pop();
                    curr.next.prev = curr;
                }
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}


    
/*
// Using Recursion
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        
        Node curr = head;
        
        while (curr != null) {
            if (curr.child != null) {
                Node prevLevel = curr.next;
                
                curr.next = flatten(curr.child);
                
                curr.next.prev = curr;
                curr.child = null;
                
                while (curr.next != null) {
                    curr = curr.next;
                }
                
                if (prevLevel != null) {
                    curr.next = prevLevel;
                    curr.next.prev = curr;
                }
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}
*/
