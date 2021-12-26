package codetop.one;

import utils.ListNode;

/**
 * 反转left到right之间的链表
 */
class ReverseBetweenLAndR {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode();
        hair.next = head;
        // left 前面的一个结点
        ListNode pre = hair;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // right 指向的结点
        ListNode r = pre;
        for (int i = 0; i < right - left + 1; i++) {
            r = r.next;
        }
        // 断开 pre 和 left
        ListNode l = pre.next;
        pre.next = null;
        // 记录right后面的结点next，断开right 和 next
        ListNode next = r.next;
        r.next = null;
        // 翻转 并连接链表
        pre.next = reverse(l);
        l.next = next;

        return hair.next;
    }

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


public class P92_ReverseBetweenLAndR {

}
