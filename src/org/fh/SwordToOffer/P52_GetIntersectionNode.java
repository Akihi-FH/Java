package org.fh.SwordToOffer;

/**
 * 两个链表的第一个公共节点
 */
class GetIntersectionNode {
    /**
     * 双指针法
     * pA = headA; pB = headB;
     * 若pA ！= pB，同时遍历两个链表
     * 若pA != null且pB ！= null，继续遍历
     * 若pA = null，使pA指向B
     * 若pB = null，使pB指向A
     * 则pA = pB时，即都指向相交结点时，两个指针经过的路程是一样的
     * <p>
     * 链表若等长，指针不需互相指向对方的头结点便能判断是否相交并找出相交结点
     * 若链表不等长，指针都指向对方的头结点之后，继续遍历，若相交必会同时指向头结点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}

public class P52_GetIntersectionNode {
}
