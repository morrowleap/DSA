/*
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * https://takeuforward.org/data-structure/reverse-a-linked-list/
 * https://youtu.be/iRtLEoL-r-g
 * 
*/

package linked_list;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList r = new ReverseLinkedList();
        ListNode rev = r.reverseList(head);

        while (rev != null) {
            System.out.print(rev.val + " ");
            rev = rev.next;
        }
    }
}
