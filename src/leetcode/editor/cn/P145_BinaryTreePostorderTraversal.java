//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 561 👎 0

package leetcode.editor.cn;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P145_BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145_BinaryTreePostorderTraversal().new Solution();
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
        /**
         * 深度优先遍历
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }
        // 后序遍历  左-右-根
        private void dfs(TreeNode root, List<Integer> res) {
            if (root == null){
                return;
            }
            dfs(root.left, res);
            dfs(root.right, res);
            res.add(root.val);
        }


        /**
         * 迭代 - 栈
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal_2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode pre = null; // 标记上一次访问的结点
            while (root != null || !stack.isEmpty()) {
                // 从根结点开始 把所有左子节点入栈
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                // 出栈
                root = stack.pop();
                // 判断结点右没有右子树， 没有则该节点值加入结果集，标记为已访问过
                if (root.right == null || root.right == pre) {
                    res.add(root.val);
                    pre = root;
                    root = null;
                } else { // 有 则该节点再次入栈，并将右子节点的所有左子节点入栈
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

