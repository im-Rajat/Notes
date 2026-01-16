// 61. Rotate List
// https://leetcode.com/problems/rotate-list/


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
// By counting length of linked list first
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int len = 0;
        ListNode curr = head;
        
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        k = k % len;
        if (k <= 0) {
            return head;
        }
        
        curr = head;
        int i = 0;
        while (i < len - k - 1) {
            i++;
            curr = curr.next;
        }
        
        ListNode newHead = curr.next;
        
        curr.next = null;
        
        curr = newHead;
        while (curr.next != null) {
            curr = curr.next;
        }
        
        curr.next = head;
        
        return newHead;
    }
}
