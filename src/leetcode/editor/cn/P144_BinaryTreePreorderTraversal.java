//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 549 👎 0

package leetcode.editor.cn;

import org.fh.SwordToOffer.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144_BinaryTreePreorderTraversal().new Solution();
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
         * 递归 深度优先遍历
         *
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }

        // 前序遍历  根-左-右
        private void dfs(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            dfs(root.left, res);
            dfs(root.right, res);
        }

        /**
         * 迭代
         *
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal_2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                // 从根结点开始到 把左子节点都入栈 并将其值加入结果集
                while (node != null) {
                    res.add(node.val);
                    stack.push(node);
                    node = node.left;
                }
                // 左边遍历到底后，取出父节点，node设为 右子节点，继续上面的步骤
                node = stack.pop();
                node = node.right;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

