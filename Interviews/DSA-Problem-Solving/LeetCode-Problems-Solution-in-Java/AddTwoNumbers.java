// 2. Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode node1 = l1;
        ListNode node2 = l2;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        int carry = 0;
        
        while(node1 != null || node2 != null) {
            int num1 = (node1 != null) ? node1.val : 0;
            int num2 = (node2 != null) ? node2.val : 0;
            
            int sum = num1 + num2 + carry;
            
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            
            if(node1 != null) {
                node1 = node1.next;
            }
            
            if(node2 != null) {
                node2 = node2.next;
            }
        }
        
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        return dummy.next;
        
        
    }
}
