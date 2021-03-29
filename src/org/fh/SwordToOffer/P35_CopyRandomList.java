package org.fh.SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 */
class CopyRandomList {

    Map<Node, Node> map = new HashMap<>();

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 已经有当前节点的一个拷贝，我们不需要重复拷贝
        if (map.containsKey(head)) {
            return map.get(head);
        }
        // 复制节点，并把被复制的节点放入map中
        Node node = new Node(head.val);
        map.put(head, node);
        // 复制 next和random 指针指向的节点
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 把所有节点极其拷贝加入到 map 中
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 为拷贝的新节点构建 next和 random 指针的指向
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 链表拼接和拆分
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 构建拼接链表，每个原节点后面创建一个新的拷贝节点
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        // 构建 新节点random指向
        cur = head;
        while (cur != null) {
            // cur.random为 null，null可没有新的拷贝节点, 不能执行cur.random.next
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 拆分新旧链表，顺便构建 next指向
        Node pre = head;
        cur = head.next;
        Node res = cur;
        // cur.next 不为 null，后面才会有新的拷贝节点 才能执行cur.next.next
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        // 单独处理原链表最后一个节点的指向
        pre.next = null;
        return res;
    }


}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class P35_CopyRandomList {
}
