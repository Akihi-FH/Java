//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 692 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class P226_InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P226_InvertBinaryTree().new Solution();

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        node2.left = node5;
        node2.right = node6;

        System.out.println(solution.invertTree(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 递归
         *  做指针指向翻转后的右子树
         *  右指针指向翻转后的左子树
         * 这里注意使用中间对象存储翻转的子树。
         *
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.right);
            TreeNode right = invertTree(root.left);
            root.left = left;
            root.right = right;
            return root;
        }

        /**
         * 迭代：
         *  一般使用队列来存储每一层的结点；
         *  根节点入队，
         *  队列中结点依次出队，不为空，则翻转左右子结点；
         *  若该层左右子结点的下一层左右子结点不为空，则该层左右结点入队
         * @param root
         * @return
         */
        /*public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;

                node.left = node.right;
                node.right = left;

                if (node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            return root;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}

