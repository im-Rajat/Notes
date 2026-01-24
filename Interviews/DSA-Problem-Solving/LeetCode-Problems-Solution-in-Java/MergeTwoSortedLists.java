// 21. Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode temp = new ListNode(0);
        ListNode newlist = temp;
        
        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                newlist.next = list1;
                list1 = list1.next;
            }
            else
            {
                newlist.next = list2;
                list2 = list2.next;
            }
            newlist = newlist.next;
        }
        
        while(list1 != null)
        {
            newlist.next = list1;
            list1 = list1.next;
            newlist = newlist.next;
        }
        
        while(list2 != null)
        {
            newlist.next = list2;
            list2 = list2.next;
            newlist = newlist.next;
        }
        
        return temp.next;
    }
}
