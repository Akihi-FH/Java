//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1381 👎 0

package leetcode.editor.cn;


public class P21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21_MergeTwoSortedLists().new Solution();
    }

    //Definition for singly-linked list.
    class ListNode {
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


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 迭代：
         * 定义一个头节点和一个指针pre；
         * 当l1和l2都不为空，遍历l1、l2，每次选出l1，l2中值最小的节点连接在pre后面，
         * 再将选出了节点的链表中的指针和pre都往后移一个
         * 直到l1，l2其中一个为null，则此时它们中另一个链表直接连接在pre后面；
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode pre = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }
            pre.next = l1 == null ? l2 : l1;
            return head.next;
        }


        /**
         * 递归：
         *  每次比较 l1 和 l2 当前节点的值，然后求该节点之外所有节点的合并链表；
         *  若其中一个链表为空即遍历完了，则将另一个链表作为结果返回
         *
         * @param l1
         * @param l2
         * @return
         */
        /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}

