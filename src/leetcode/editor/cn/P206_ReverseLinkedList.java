//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1354 👎 0

package leetcode.editor.cn;

public class P206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206_ReverseLinkedList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {



        /**
         * 迭代
         * pre tmp nextNode
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextNode = curr.next;
                curr.next = pre;
                pre = curr;
                curr = nextNode;
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
        /*public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }*/


        /**
         * 迭代
         * head pre tmp
         *
         * @param head
         * @return
         */
        /*public ListNode reverseList(ListNode head) {
            if(head == null) {
                return null;
            }
            ListNode pre = null, tmp = head.next;
            head.next = null;
            while (tmp != null) {
                pre = tmp;
                tmp = tmp.next;
                pre.next = head;
                head = pre;

            }
            return head;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

