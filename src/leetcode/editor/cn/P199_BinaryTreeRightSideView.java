//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 438 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P199_BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new P199_BinaryTreeRightSideView().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        List<Integer> res = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            dfs(root, 0); // 从根节点开始访问，根节点深度是 0
            return res;
        }
        // 1、深度优先遍历  根-右-左
        private void dfs(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            // 先访问 当前节点，再递归地访问 右子树 和 左子树。
            if (depth == res.size()) {
                // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
                res.add(root.val);
            }
            depth++;
            dfs(root.right, depth);
            dfs(root.left, depth);
        }

        /**
         * 2、广度优先遍历-层序遍历
         * @param root
         * @return
         */
        public List<Integer> rightSideView2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res; // 这里不能直接返回 null ，也是醉了
            }
            // 队列每次保存一层结点
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                // 当前队列大小
                int size = queue.size();
                // 除了每层最右边的一个，其余结点都出队并将其子结点入队
                for (int i = size; i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                    // i == 1时，当前结点是每层最后一个，将值保存到结果集中
                    if (i == 1) {
                        res.add(node.val);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

