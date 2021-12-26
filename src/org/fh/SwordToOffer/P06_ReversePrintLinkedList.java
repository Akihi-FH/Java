package org.fh.SwordToOffer;

import utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 从尾到头打印链表
 */
class ReversePrintLinkedList {
    /**
     * 栈：注意保存栈的大小，因为出栈后大小会改变
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}

public class P06_ReversePrintLinkedList {
}
