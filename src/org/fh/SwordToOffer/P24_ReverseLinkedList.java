package org.fh.SwordToOffer;

import utils.ListNode;

/**
 * 反转链表
 */
class ReverseLinkedList {
    /**
     * 双指针，pre：前一个结点，cur：后一个节点，next：下一个节点
     * cur为null时，pre指向最后一个节点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }

    /**
     * 递归
     * 找出反转后的头结点 层层返回
     * 在当前层，node.next.next = node，让node原来的下一个节点指向自己
     *         node.next = null，让node指向空
     *
     * @param head
     * @return
     */
    /*
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    */
}

public class P24_ReverseLinkedList {
}
