/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/
 * https://youtu.be/0DYoPz2Tpt4
*/

package linked_list;

import utils.ListNode;

public class FindIntersectionPointOfYLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Create a backlink
        ListNode temp = headA;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = headA;

        // Find the cycle entry point in linked list
        ListNode slow = headB, fast = headB;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode tmp1 = headB, tmp2 = slow;
                while (tmp1 != tmp2) {
                    tmp1 = tmp1.next;
                    tmp2 = tmp2.next;
                }
                temp.next = null;
                return tmp1;
            }
        }

        temp.next = null;
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 2 pointer approach
        if (headA == null || headB == null)
            return null;
        ListNode t1 = headA, t2 = headB;
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;

            if (t1 == t2) {
                return t1; // For the case, if no intersection
            }

            if (t1 == null) {
                t1 = headB;
            }
            if (t2 == null) {
                t2 = headA;
            }
        }

        return t1;
    }
}
