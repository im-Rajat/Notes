// 25. Reverse Nodes in k-Group
// https://leetcode.com/problems/reverse-nodes-in-k-group/


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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        int size = 0;
        
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        
        ListNode prev = dummy;
        curr = head;
        ListNode next = null;
        
        while (size >= k) {
            curr = prev.next;
            next = curr.next;
            
            for(int i = 0; i < k - 1; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            
            prev = curr;
            size = size - k;
        }
        
        return dummy.next;
    }
}



// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if (head == null) {
//             return head;
//         }
        
//         ListNode curr = head;
//         ListNode prev = null;
//         ListNode next = null;
        
//         int temp = 0;
//         while (curr != null) {
//             curr = curr.next;
//             temp++;
//         }
        
//         if (temp < k) {
//             return head;
//         }
        
//         int count = 0;
//         curr = head;
        
//         while (count < k && curr != null) {
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//             count++;
//         }
        
//         if (next != null) {
//             head.next = reverseKGroup(next, k);
//         }
        
//         return prev;
//     }
// }
