//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 828 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 颜色标记法
         *
         * 根节点入栈，若栈不为空，取出栈顶元素
         * 如果栈中遇到元素为TreeNode对象，则将其节点值入栈，
         *  然后将其右子树指针、该节点值、左子树指针依次入栈。
         * 如果中遇到元素为Integer对象，输出即保存到list中
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<Object> stack = new LinkedList<>();
            if (root == null) {
                return res;
            }
            stack.push(root);
            while (!stack.isEmpty()) {
                Object o = stack.pop();
                if (o instanceof Integer) {
                    res.add((Integer) o);
                } else {
                    TreeNode node = (TreeNode) o;
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    stack.push(node.val);
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
            }
            return res;
        }

        /**
         * 递归
         */
        /*public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(res, root);
            return res;
        }
         // 递归
         public void inorder(List<Integer> res, TreeNode root){
            if (root == null) {
                return;
            }
            inorder(res, root.left);
            res.add(root.val);
            inorder(res, root.right);
        }*/

        /**
         * 迭代
         * @param root
         * @return
         */
        /*public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
