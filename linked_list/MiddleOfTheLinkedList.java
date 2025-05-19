/*
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * 
 * https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/
 * https://youtu.be/7LjQ57RqgEc
*/

package linked_list;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode tortoise = head, hare = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        return tortoise;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        MiddleOfTheLinkedList r = new MiddleOfTheLinkedList();
        ListNode rev = r.middleNode(head);

        while (rev != null) {
            System.out.print(rev.val + " ");
            rev = rev.next;
        }
    }
}
