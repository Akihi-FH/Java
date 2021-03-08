package org.fh.SwordToOffer;

/**
 * 二叉树的最近公共祖先
 */
class LowestCommonAncestor {
    private TreeNode ans;

    public LowestCommonAncestor() {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    /**
     * 递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        // 结点的左子树和右子树 其中一个包含p结点另一个包含q结点
        // ||
        // 结点为p结点或q结点 且 左子树或右子树有一个包含了q或p结点
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}


public class P68_LowestCommonAncestor {
}
