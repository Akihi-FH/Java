package codetop.one;

import utils.ListNode;

import java.util.List;

/**
 * pro:k个一组反转链表
 */
class ReverseListWithKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        // 每组的临时头结点
        ListNode pre = hair;

        while (true) {
            // 初始指向每组头结点，遍历后指向每组尾结点
            ListNode end = pre;
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            // 1、断开与下一组的连接
            // 记录下一句的第一个结点
            ListNode nextHead = end.next;
            // 断开连接
            end.next = null;

            // 2、反转该组
            // 每组第一个结点，反转后是每组最后一个结点
            ListNode start = pre.next;
            // 每组的临时头结点指向反转后的第一个结点
            pre.next = reverse(start);

            // 3、连接下一组
            start.next = nextHead;
            pre = start;
        }
        return hair.next;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
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

public class P25_ReverseListWithKGroup {
}
