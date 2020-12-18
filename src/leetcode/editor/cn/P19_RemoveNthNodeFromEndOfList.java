//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1147 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class P19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(solution.removeNthFromEnd(node1, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 遍历一次：
         *  考虑到删除第一个结点，创建一个头结点
         *  双指针，fast领先n+1个，fast为null时，low指向要删除结点的前一个结点
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode newHead = new ListNode(0, head);
            ListNode fast = newHead, low = newHead;
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                low = low.next;
            }
            low.next = low.next.next;
            return newHead.next;
        }

        /**
         * 栈
         * @param head
         * @param n
         * @return
         */
        /*public ListNode removeNthFromEnd(ListNode head, int n) {
            Deque<ListNode> stack = new LinkedList<>();
            ListNode newHead = new ListNode(0, head);
            ListNode pre = newHead;
            while (pre != null) {
                stack.push(pre);
                pre = pre.next;
            }
            for (int i = 0; i < n; i++) {
                stack.pop();
            }
            ListNode node =  stack.peek();
            node.next = node.next.next;
            return newHead.next;
        }*/

        /**
         * 暴力破解
         * @param head
         * @param n
         * @return
         */
        /*public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode newHead = new ListNode(0, head);
            ListNode pre = head, pre2 = newHead;

            // 计算结点个数
            int count = 0;
            while (pre != null) {
                count++;
                pre = pre.next;
            }
            if (count == 0) {
                return head;
            }
            // 1 2 3 4 5
            // 遍历链表
            int num = 0;
            while (num + 1 < count - n + 1) {
                pre2 = pre2.next;
                num++;
            }
            pre2.next = pre2.next.next;
            return newHead.next;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

