package sword.one.linkedlist;

import utils.ListNode;

/**
 * 反转链表
 */
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

public class P24_ReverseLinkedList {
}
