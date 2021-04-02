//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1237 👎 0

package leetcode.editor.cn;

import org.fh.SwordToOffer.ListNode;

public class P23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23_MergeKSortedLists().new Solution();
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

        /**
         * 2、分治合并
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        // 分治合并
        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = (l + r) >> 1;
            return mergeTwoLists(
                    merge(lists, l, mid),
                    merge(lists, mid + 1, r)
            );
        }


        /**
         * 1、在合并两个链表的基础上，把结果与后面的链表合并
         */
        /*
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode res = null;
            for (int i = 0; i < lists.length; i++) {
                res = mergeTwoLists(res, lists[i]);
            }
            return res;
        }
        */

        // 合并两个有序链表
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode hair = new ListNode(0);
            ListNode pre = hair;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }
            pre.next = l1 == null ? l2 : l1;
            return hair.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

