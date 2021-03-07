package org.fh.SwordToOffer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 */
class MaximumDepthOfBinaryTree {
    /**
     * 递归：
     * 树的深度 = 1 + max(左子树深度，右子树深度);
     * <p>
     * 判断当前节点是否是null：
     * 是null：  返回深度 = 0；
     * 不是null：深度 = 1 + max(左子树深度， 右子树深度);
     *
     * @param root
     * @return
     */
    /*public int maxDepth(TreeNode root) {
         return root == null ? 0
                 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }*/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
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
    }
}

public class P55_1_MaximumDepthOfBinaryTree {
}
