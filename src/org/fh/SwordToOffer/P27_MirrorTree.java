package org.fh.SwordToOffer;


import utils.TreeNode;

class MirrorTree {
    /**
     * 递归
     * 左指针指向翻转后的右子树
     * 右指针指向翻转后的左子树
     * 这里注意使用中间对象存储翻转的子树。
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode L = mirrorTree(root.right);
        TreeNode R = mirrorTree(root.left);
        root.left = L;
        root.right = R;
        return root;
    }

    /**
     * 迭代
     * 一般使用队列来存储每一层的结点；
     * 根节点入队，
     * while判断队列不为空则
     *  队列中结点依次出队，若结点不为空，则翻转左右子结点（引用互换）；
     *  若左右子结点不为空，则相继入队，
     * @param root
     * @return
     */
    /*public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 左右子节点引用互换
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left!=null) {
                queue.offer(node.left);
            }
            if (node.right!=null) {
                queue.offer(node.right);
            }
        }
        return root;
    }*/
}

public class P27_MirrorTree {
}
