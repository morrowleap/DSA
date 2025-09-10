/*
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * 
 * https://takeuforward.org/data-structure/merge-two-sorted-linked-lists/
 * https://youtu.be/Xb4slcp1U38
*/

package linked_list;

import utils.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode merged = m.mergeTwoLists(l1, l2);

        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
