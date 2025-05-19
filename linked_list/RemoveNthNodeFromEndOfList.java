package linked_list;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode pt1 = dummy, pt2 = dummy;

        for (int i = 0; i <= n; i++) {
            pt2 = pt2.next;
        }

        while (pt2 != null) {
            pt1 = pt1.next;
            pt2 = pt2.next;
        }

        pt1.next = pt1.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        ListNode rev = r.removeNthFromEnd(head, 2);

        while (rev != null) {
            System.out.print(rev.val + " ");
            rev = rev.next;
        }
    }
}
