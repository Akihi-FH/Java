//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 843 👎 0

package leetcode.editor.cn;

import utils.ListNode;

public class P92_ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new P92_ReverseLinkedListIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode hair = new ListNode(-1);
            hair.next = head;
            // left前面一个结点
            ListNode pre = hair;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            // right指向的结点
            ListNode r = pre;
            for (int i = 0; i < right - left + 1; i++) {
                r = r.next;
            }
            // left指向的结点
            ListNode l = pre.next;
            // right后面一个结点
            ListNode suc = r.next;
            // 断开 pre 和 left 的连接
            pre.next = null;
            // 断开 right 和 suc 的连接
            r.next = null;
            // pre.next 指向反转后的链表也就是right
            pre.next = reverse(l);
            // l.next 指向 suc
            l.next = suc;

            return hair.next;
        }

        /**
         * 翻转链表
         * @param head
         * @return
         */
        public ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode node = cur.next;
                cur.next = pre;
                pre = cur;
                cur = node;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

