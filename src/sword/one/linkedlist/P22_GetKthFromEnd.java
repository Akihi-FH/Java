package sword.one.linkedlist;

import utils.ListNode;

class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head, right = head;
        while (k > 0 && right !=null) {
            right = right.next;
            k--;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}

public class P22_GetKthFromEnd {
}
