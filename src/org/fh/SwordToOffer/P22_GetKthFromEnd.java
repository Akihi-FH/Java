package org.fh.SwordToOffer;

import utils.ListNode;

/**
 * 链表中倒数第 k 个节点
 */
class GetKthFromEnd {
    /**
     * 前后指针，前指针比后指针领先k个元素，前指针为null，后指针为倒数第k个
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode front = head;
        ListNode after = head;
        for (int i = 0; i < k; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            after = after.next;
        }
        return after;
    }
}

public class P22_GetKthFromEnd {
}
