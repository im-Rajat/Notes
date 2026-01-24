// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head)
    {
        ListNode prev_node = null;
        ListNode curr_node = head;
        ListNode next_node = null;
        
        while(curr_node != null)
        {
            next_node = curr_node.next;
            curr_node.next = prev_node;
            prev_node = curr_node;
            curr_node = next_node;
        }
        
        return prev_node;
    }
}



// class Solution {
    
//     private ListNode newHead = null;
    
//     public ListNode reverseList(ListNode head)
//     {
//         ListNode curr = head;
//         while (curr != null) {
//             ListNode temp = curr.next;
//             addAtHead(curr);
//             curr = temp;
//         }
        
//         return newHead;
//     }
    
//     public void addAtHead(ListNode node) {
//             node.next = newHead;
//             newHead = node;
//     }
// }
