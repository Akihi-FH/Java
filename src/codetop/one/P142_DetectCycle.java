package codetop.one;

import utils.ListNode;

/**
 * 返回链表入环的第一个结点
 */
class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        ListNode pre = head;
        while (slow != pre) {
            slow = slow.next;
            pre = pre.next;
        }
        return pre;
    }
}

public class P142_DetectCycle {
}
