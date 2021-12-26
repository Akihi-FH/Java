package org.fh.SwordToOffer;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 3
 * 第一层从左到右
 * 第二层从右到左
 * ···
 */
class LevelOrder3 {
    /**
     * 当前list层数大小为偶数 下一层从尾部添加
     * 当前list层数大小为奇数 下一层从尾部添加
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> tmps = new LinkedList<>();
            for (int i = size; i > 0; i--) {
                TreeNode node = queue.poll();
                // 当前list层数大小为偶数，下一层从尾部添加
                if (list.size() % 2 == 0) tmps.addLast(node.val);
                // 当前list大小为偶数，下一层从头部添加
                else tmps.addFirst(node.val);
                // 左右子结点入队
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            list.add(tmps);
        }
        return list;
    }
}


public class P32_3_LevelOrder {
}