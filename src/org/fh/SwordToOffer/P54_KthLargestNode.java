package org.fh.SwordToOffer;

/**
 * 二叉搜索树的第k大节点
 */
class KthLargestNode {

    int k, kthVal;

    /**
     * 中序遍历的倒序 的第 k 个元素
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        reInorder(root);
        return kthVal;
    }

    /**
     * 中序遍历的倒序
     */
    public void reInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        reInorder(root.right);
        if (--k == 0) {
            kthVal = root.val;
            return;
        }
        reInorder(root.left);
    }
}

public class P54_KthLargestNode {
}
