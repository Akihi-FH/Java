//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 740 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class P104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node4.left = node5;
        node4.right = node6;

        System.out.println(solution.maxDepth(root));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 递归：
         *  树的深度 = 1 + max(左子树深度，右子树深度);
         *
         *  判断当前节点是否是null：
         *      是null：  返回深度 = 0；
         *      不是null：深度 = 1 + max(左子树深度， 右子树深度);
         *
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            return root == null ? 0
                    : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//            if(root == null) {
//                return 0;
//            }
//            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

        /**
         * 队列迭代：
         *  广度优先遍历，队列中每次只保存同一层的结点，
         *  先将根结点入队，
         *  只要队列不为空
         *      遍历队列，若队列长度 > 0，即队列中还有同一层元素；（遍历作用就是把同一层的结点加入队列中）
         *          取出结点，判断结点的左右子树是否为null：
         *          左右子树是不为null，则将左或右子结点加入队列中；（就是把同一层的结点加入队列中）
         *          队列长度 -1
         *      深度 +1
         *
         *
         * @param root
         * @return
         */
        /*public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            int height = 0;
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                height++;
            }
            return height;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

