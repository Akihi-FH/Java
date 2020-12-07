//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1119 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class P101_SymmetricTree {
    static TreeNode root = new TreeNode(1);

    public static void main(String[] args) {
        Solution solution = new P101_SymmetricTree().new Solution();

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        node2.left = node5;
        node2.right = node6;

        solution.isSymmetric(root);
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isLRSymmetric(root, root);
        }

        /**
         * 迭代:
         *  定义一个队列，初始把根节点入队两次；
         *  每次提取队列中的两个结点并比较值，然后把两个结点的镜像对称的左右子节点放入队列；
         *  当队列为空或者检测到不对称时程序结束（镜像对称的左右结点点其中一个为空或结点值不等，则不对称）。
         *
         * @param l
         * @param r
         * @return
         */
        /*public boolean isLRSymmetric(TreeNode l, TreeNode r) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(l);
            queue.offer(r);
            while (!queue.isEmpty()) {
                l = queue.poll();
                r = queue.poll();
                if(l == null && r == null) {
                    continue;
                }
                if((l == null || r == null) || (l.val != r.val)) {
                    return false;
                }

                queue.offer(l.left);
                queue.offer(r.right);

                queue.offer(l.right);
                queue.offer(r.left);
            }
            return true;
        }*/


        /**
         * 递归：
         *  判断两个根节点是否具有相同的值 以及  每个节点的左子树与另一个节点的右子树是否镜像对称
         *      若作为参数的左右子树根节点都为空，则镜像对称；
         *      若只有其中一个为空，则不对称；
         *      若两个根节点值相同 则 再判断各自的左右子树是否对称
         *      若两个根节点值相同 则 不对称
         *
         * @param l
         * @param r
         * @return
         */
        public boolean isLRSymmetric(TreeNode l, TreeNode r) {
            if (l == null && r == null) {
                return true;
            }
            if(l == null || r == null) {
                return false;
            }
            if (l.val == r.val) {
                return isLRSymmetric(l.left, r.right) && isLRSymmetric(l.right, r.left);
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

