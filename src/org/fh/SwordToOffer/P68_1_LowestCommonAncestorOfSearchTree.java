package org.fh.SwordToOffer;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最近公共祖先
 */
class LowestCommonAncestorOfSearchTree {

    /**
     * 遍历一次
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while (true) {
            // 如果 ans结点值 > p和 q 的值，p,q在左子树，ans移动到左子节点
            // 如果 ans结点值 < p和 q 的值，p,q在右子树，ans移动到右子节点
            // 否则，ans为分岔结点，或者是p或者q其中一个，即为结果
            if (ans.val > p.val && ans.val > q.val) {
                ans = ans.left;
            } else if (ans.val < p.val && ans.val < q.val) {
                ans = ans.right;
            } else {
                break;
            }
        }
        return ans;
    }



    /**
     * 遍历2次
     * @param root
     * @param p
     * @param q
     * @return
     */
    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 分别获取 找到 p 和 q 的结点路径
        // 由于都是从根结点开始寻找，所以遍历时连续相同结点的最后一个即结果
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ans = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            if (path_p.get(i) == path_q.get(i)) {
                ans = path_p.get(i);
            } else {
                break;
            }
        }
        return ans;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        // 获取root 到 target的结点路径
        while (node != target) {
            list.add(node);
            if (node.val > target.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        list.add(node);
        return list;
    }
    */
}

public class P68_1_LowestCommonAncestorOfSearchTree {
}
