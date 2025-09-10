/*
 * https://leetcode.com/problems/merge-k-sorted-lists/
*/

package linked_list;

import utils.ListNode;

public class MergeKsortedArrays {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(), temp = dummy;
        boolean check = true;
        while (check) {
            check = false;

            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < minVal) {
                    check = true;
                    minVal = lists[i].val;
                    minIdx = i;
                }
            }

            if (check && minIdx != -1) {
                temp.next = lists[minIdx];
                temp = temp.next;
                lists[minIdx] = lists[minIdx].next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = { l1, l2, l3 };

        MergeKsortedArrays sol = new MergeKsortedArrays();
        ListNode res = sol.mergeKLists(lists);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
