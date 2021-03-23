//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表 
// 👍 883 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class P160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new P160_IntersectionOfTwoLinkedLists().new Solution();
        ListNode a = new ListNode(1);
        ListNode b = a;
        System.out.println(solution.getIntersectionNode(a, b).val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

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
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }

        /**
         * 先计算两个链表的长度 lenA、lenB
         * 让更长的链表先走若干步直到lenA == lenB
         * 若headA != headB，遍历两个链表，
         * 直到headA == headB即 找到相交结点 或 不相交两指针都为null
         *
         * @param headA
         * @param headB
         * @return
         */
        /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = getLength(headA);
            int lengthB = getLength(headB);
            while (lengthA != lengthB) {
                if (lengthA > lengthB) {
                    headA = headA.next;
                    lengthA--;
                } else {
                    headB = headB.next;
                    lengthB--;
                }
            }
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                head = head.next;
                length++;
            }
            return length;
        }*/

        /**
         * set集合存放1
         * @param headA
         * @param headB
         * @return
         */
        /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //创建集合set
            Set<ListNode> set = new HashSet<>();
            //先把链表A的结点全部存放到集合set中
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }

            //然后访问链表B的结点，判断集合中是否包含链表B的结点，如果包含就直接返回
            while (headB != null) {
                if (set.contains(headB))
                    return headB;
                headB = headB.next;
            }
            //如果集合set不包含链表B的任何一个结点，说明他们没有交点，直接返回null
            return null;
        }*/

        /**
         * set集合存放2
         * @param headA
         * @param headB
         * @return
         */
        /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();
            while (headA != null || headB != null) {
                if(headA != null) {
                    if (!set.add(headA)) {
                        return headA;
                    }
                    headA = headA.next;

                }
                if(headB != null) {
                    if (!set.add(headB)) {
                        return headB;
                    }
                    headB = headB.next;
                }
            }
            return null;
        }*/

    }


    //leetcode submit region end(Prohibit modification and deletion)

    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}

