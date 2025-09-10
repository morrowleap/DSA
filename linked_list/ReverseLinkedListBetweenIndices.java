/*
 * https://leetcode.com/problems/reverse-linked-list-ii/
*/

package linked_list;

import utils.ListNode;

public class ReverseLinkedListBetweenIndices {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);

        ListNode pl = dummy, l = head;

        for (int i = 1; i < left; i++) {
            pl = l;
            l = l.next;
        }

        ListNode prev = null, curr = l, next = null;
        for (int i = left; i <= right && curr != null; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode r = curr;
        pl.next.next = r;
        pl.next = prev;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedListBetweenIndices r = new ReverseLinkedListBetweenIndices();
        ListNode rev = r.reverseBetween(head, 2, 4);

        while (rev != null) {
            System.out.print(rev.val + " ");
            rev = rev.next;
        }
    }
}
