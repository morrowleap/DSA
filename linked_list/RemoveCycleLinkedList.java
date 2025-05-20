/*
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 * 
 * Remove loop from linked list
 * 
 * Find First Node of Loop in Linked List
 * https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/
 * https://www.geeksforgeeks.org/how-does-floyds-slow-and-fast-pointers-approach-work/
*/

package linked_list;

public class RemoveCycleLinkedList {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode temp = head, prev = slow;
                while (temp != slow) {
                    prev = slow;
                    slow = slow.next;
                    temp = temp.next;
                }
                prev.next = null;
                return head;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        RemoveCycleLinkedList solver = new RemoveCycleLinkedList();
        ListNode start = solver.detectCycle(head);

        System.out.println(start != null ? start.val : "null");
    }
}
