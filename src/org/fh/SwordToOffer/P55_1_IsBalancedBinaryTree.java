package org.fh.SwordToOffer;


/**
 * 平衡二叉树
 */
class IsBalancedBinaryTree {


    /**
     * 先序遍历 + 判断深度
     * 当左右子树都是平衡树且左右子树高度差 <= 1 则该树平衡
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true; //
        }
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int treeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }



    /**
     * 后序遍历 + 剪枝
     * 若有一个结点的左右子树高度差 >1 ,则直接返回-1，否则返回树的深度
     * @param root
     * @return
     */
    /*public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2
                ? Math.max(left, right) + 1
                : -1;
    }*/
}

public class P55_1_IsBalancedBinaryTree {
}
