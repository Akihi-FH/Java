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

import org.fh.SwordToOffer.TreeNode;

import java.util.ArrayList;
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}

