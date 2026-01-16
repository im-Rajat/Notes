// 234. Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list/


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
// Reversing second half of linked list and then comparing every element
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = null;
        
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        slow = head;
        
        while (prev != null) {
            if (slow.val != prev.val) {
                return false;
            }
            
            slow = slow.next;
            prev = prev.next;
        }
        
        return true;
    }
}
