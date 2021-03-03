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

    /**
     * 重建
     * @param preorder  前序遍历
     * @param preStart  左/右 树在前序遍历中的起始位置
     * @param preEnd    左/右 树在前序遍历中的结束位置
     * @param inorder   中序遍历
     * @param inStart   左/右 树在前序遍历中的起始位置
     * @param inEnd     左/右 树在前序遍历中的结束位置
     * @param map       保存了节点值在中序遍历中的位置，因为通过前序遍历可以知道根节点，通过中序遍历就可以知道
     *                  左右子树有多少个节点，中序遍历中根节点在中间
     * @return
     */
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

public class P07_BuildTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};
        solution.buildTree(preorder, inorder);
    }
}
