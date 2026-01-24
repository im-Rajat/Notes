// 328. Odd Even Linked List
// https://leetcode.com/problems/odd-even-linked-list/


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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode oddCurr = head;
        ListNode evenHead = head.next;
        ListNode evenCurr = evenHead;
        
        while (oddCurr != null && evenCurr != null && evenCurr.next != null) {
            oddCurr.next = oddCurr.next.next;
            evenCurr.next = evenCurr.next.next;
            
            oddCurr = oddCurr.next;
            evenCurr = evenCurr.next;
        }
        
        oddCurr.next = evenHead;
        
        return head;
    }
}
