package org.fh.SwordToOffer;

import utils.TreeNode;

/**
 * 对称二叉树
 */
class IsSymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return judgeSon(root.left, root.right);
    }

    /**
     * 值相同且左右子树对称 则树对称
     *
     * @param left
     * @param right
     * @return
     */
    public boolean judgeSon(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && judgeSon(left.left, right.right) && judgeSon(left.right, right.left);
    }
}

public class P28_IsSymmetricBinaryTree {
}
