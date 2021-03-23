package org.fh.SwordToOffer;

/**
 * 删除链表的节点
 */
class DeleteNodeOfLinkedList {

    /**
     * 如果删除头节点直接返回
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val==val){
            return head.next;
        }
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                return head;
            }
            pre = pre.next;
        }
        return null;
    }

    /*public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                return newHead.next;
            }
            pre = pre.next;
        }
        return null;
    }*/
}

public class P18_DeleteNodeOfLinkedList {
}
