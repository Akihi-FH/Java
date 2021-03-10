package org.fh.SwordToOffer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 1
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
class LevelOrder1 {
    /**
     * 迭代
     *  每次将左右子结点放入队列中
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }
}


public class P32_1_LevelOrder {
}
