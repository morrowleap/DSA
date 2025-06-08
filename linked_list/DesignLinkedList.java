/*
 * https://leetcode.com/problems/design-linked-list/description/
*/

package linked_list;

public class DesignLinkedList {

}

class Node {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    Node head, tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        Node temp = head;
        int i = 0;
        for (i = 0; i <= index && temp != null; i++) {
            temp = temp.next;
        }
        if (i != index || temp == null) {
            return -1;
        } else {
            return temp.val;
        }
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
