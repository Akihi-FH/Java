package codetop.one;

import utils.ListNode;

class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode lA = headA, lB = headB;
        while (lA != lB) {
            lA = lA != null ? lA.next : headB;
            lB = lB != null ? lB.next : headA;
        }
        return lA;
    }
}

public class P160_GetIntersectionNode {
}
