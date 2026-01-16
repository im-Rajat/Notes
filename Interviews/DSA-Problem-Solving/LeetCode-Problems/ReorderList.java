// 143. Reorder List
// https://leetcode.com/problems/reorder-list/


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
    public void reorderList(ListNode head) {
        if (head == null|| head.next == null) {
            return;
        }
        
        ListNode head1 = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        prev = null;
        ListNode curr = slow;
        ListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode head2 = prev;
        
        // ListNode newHead = head1;
        
        while (head1 != null || head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            
            head1.next = head2;
            
            if (temp1 == null) {
                break;
            }
            
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
        
        // head = newHead;
        
    }
}
