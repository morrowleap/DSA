/*
 * https://leetcode.com/problems/odd-even-linked-list/description/
 * 
 * https://takeuforward.org/data-structure/segregate-even-and-odd-nodes-in-linkedlist
 * https://youtu.be/qf6qp7GzD5Q
*/

package linked_list;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddDummy = new ListNode(), temp1 = oddDummy, evenDummy = new ListNode(), temp2 = evenDummy;
        while (head != null && head.next != null) {
            temp1.next = head;
            temp1 = temp1.next;
            temp2.next = head.next;
            temp2 = temp2.next;
            head = head.next.next;
            temp1.next = null;
            temp2.next = null;
        }
        if (head != null) {
            temp1.next = head;
            temp1 = temp1.next;
            head = head.next;
        }

        temp1.next = evenDummy.next;
        return oddDummy.next;
    }
}
