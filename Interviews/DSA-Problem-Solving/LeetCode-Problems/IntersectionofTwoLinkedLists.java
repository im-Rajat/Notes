// 160. Intersection of Two Linked Lists
// https://leetcode.com/problems/intersection-of-two-linked-lists/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        
        while (curr1 != curr2) {
            if (curr1 == null) {
                curr1 = headB;
            }
            else {
                curr1 = curr1.next;
            }
            
            if (curr2 == null) {
                curr2 = headA;
            }
            else {
                curr2 = curr2.next;
            }
        }
        
        return curr1;
    }
}



// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         int len1 = 0;
//         int len2 = 0;
        
//         ListNode node1  = headA;
//         while(node1 != null) {
//             len1++;
//             node1 = node1.next;
//         }
        
//         ListNode node2 = headB;
//         while(node2 != null) {
//             len2++;
//             node2 = node2.next;
//         }
        
//         // System.out.println("len1 : " + len1 + " len2 : " + len2);
//         node1 = headA;
//         node2 = headB;
        
//         if(len2 > len1) {
//             int temp = len2 - len1;
//             while(temp > 0) {
//                 node2 = node2.next;
//                 temp--;
//             }
//         }
        
//         if(len1 > len2) {
//             int temp = len1 - len2;
//             while(temp > 0) {
//                 node1 = node1.next;
//                 temp--;
//             }
//         }
        
//         while(node1 != node2) {
//             if(node1 == null || node2 == null) {
//                 return null;
//             }
//             node1 = node1.next;
//             node2 = node2.next;
//         }
        
//         return node1;
//     }
// }
