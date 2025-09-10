/*
 * https://leetcode.com/problems/reorder-list/description/
 * 
 * https://takeuforward.org/data-structure/reorder-list/
*/

package linked_list;

import utils.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        // Find middle of the linked List
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half1 = head, half2 = slow.next;

        // Reverse the other half
        ListNode prev = null, curr = half2, next = null;
        slow.next = null; // Cut the connection
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        half2 = prev;

        // Merge these hafl1 and half2
        while (half2 != null) {
            ListNode tmp1 = half1.next, tmp2 = half2.next;
            half1.next = half2;
            half2.next = tmp1;
            half1 = tmp1;
            half2 = tmp2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList r = new ReorderList();
        r.reorderList(head);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
