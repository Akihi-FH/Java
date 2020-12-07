//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 769 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234_PalindromeLinkedList().new Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        System.out.println(solution.isPalindrome(head));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 快慢指针找出链表后半部分起始结点
         * 迭代反转链表后半部分
         * 比较链表前后部分
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            // 后半部分链表的头节点
            ListNode half = lastPart(head);
            // 翻转后半部分
            ListNode reverse = reverse(half);

            while (reverse != null) {
                if (head.val != reverse.val) {
                    return false;
                }
                reverse = reverse.next;
                head = head.next;
            }
            return true;
        }

        // 链表后半部分
        public ListNode lastPart(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.next;
        }

        // 反转链表
        public ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode node = curr.next;
                curr.next = pre;
                pre = curr;
                curr = node;
            }
            return pre;
        }

        /**
         * 栈 与 链表
         * 栈中前半部分就是原链表的后半部分
         * 这两部分进行比较
         *
         * @param head
         * @return
         */
        /*public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            Deque<ListNode> queue = new LinkedList<>();
            ListNode pre = head;
            while (pre != null) {
                queue.push(pre);
                pre = pre.next;
            }
            pre = head;
            int half = queue.size() / 2;
            for (int i = 0; i < half; i++) {
                if (queue.pop().val != pre.val) {
                    return false;
                }
                pre = pre.next;
            }
            return true;
        }*/

        /**
         * 队列
         * @param head
         * @return
         */
        /*public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null) {
                return true;
            }
            Deque<ListNode> queue = new LinkedList<>();
            ListNode pre = head;
            while (pre != null) {
                queue.offer(pre);
                pre = pre.next;
            }
            while (queue.size() > 1) {
                int left = queue.poll().val;
                int right = queue.removeLast().val;
                if(left != right) {
                    return false;
                }
            }
            return true;
        }*/
    }

    /**
     * 链表复制到数组 再比较数组和链表
     *
     * @param head
     * @return
     */
    /*public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }*/
    //leetcode submit region end(Prohibit modification and deletion)


    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

