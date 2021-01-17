package org.fh.SwordToOffer;


import java.util.HashMap;
import java.util.Map;


class Solution {
    /**
     * 重建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        // 存储结点值在中序遍历数组中的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = reBuildTree(preorder, 0, length - 1, inorder, 0, length - 1, map);
        return root;
    }

    public TreeNode reBuildTree(int[] preorder, int preStart, int preEnd,
                                int[] inorder, int inStart, int inEnd,
                                Map<Integer, Integer> map) {
        // 前序遍历的下标范围的开始 > 结束，则当前的二叉树中没有节点，返回 null
        if (preStart > preEnd) {
            return null;
        }
        // 一个结点：根结点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart != preEnd) { // 多个结点
            // root在中序遍历数组中的位置
            int rootIdx = map.get(rootVal);
            // 左右子树结点数
            int leftNodes = rootIdx - inStart;
            int rightNodes = inEnd - rootIdx;
            // 构建左、右子树
            TreeNode leftSubTree = reBuildTree(preorder, preStart + 1, preStart + leftNodes,
                    inorder, inStart, rootIdx - 1,
                    map);
            TreeNode rightSubTree = reBuildTree(preorder, preEnd - rightNodes + 1, preEnd,
                    inorder, rootIdx + 1, inEnd,
                    map);
            root.left = leftSubTree;
            root.right = rightSubTree;
        }
        return root;
    }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class P07_BuildTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};
        solution.buildTree(preorder, inorder);
    }
}
