/*
 * https://leetcode.com/problems/linked-list-cycle/description/
 * 
 * https://takeuforward.org/data-structure/detect-a-cycle-in-a-linked-list/
 * https://youtu.be/354J83hX7RI
*/

package linked_list;

public class DetectCycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        ListNode tortoise = head, hare = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (tortoise == hare) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        DetectCycleInLinkedList r = new DetectCycleInLinkedList();
        System.out.println(r.hasCycle(head));
    }
}
