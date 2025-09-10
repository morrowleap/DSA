package utils;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part.trim()));
            current = current.next;
        }

        return dummy.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null)
                sb.append("->");
            curr = curr.next;
        }
        return sb.toString();
    }
}