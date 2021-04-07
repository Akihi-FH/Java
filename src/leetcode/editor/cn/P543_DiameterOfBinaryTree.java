//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 549 👎 0

package leetcode.editor.cn;

public class P543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P543_DiameterOfBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 边数 = 节点数 - 1
         *
         * 结点 == null，树的深度 = 0;
         * 结点！= null，树的深度 = 1 + max(左子树深度， 右子树深度);
         * 最长路径结点数 = 最深左子树结点 + 最深右子树结点 + 1（根节点）
         * 最长边 = 最长路径结点数 - 1
         *
         *
         * @param root
         * @return
         */
        private int nodes = 1; // root为空或只有一个结点时

        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return nodes - 1; // 边数 = 节点数 - 1
        }

        public int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lNodes = depth(root.left);  // lNodes：左子树深度
            int rNodes = depth(root.right); // rNodes：右子树深度
            nodes = Math.max(nodes, 1 + lNodes + rNodes); // 更新最长路径的节点数
            return 1 + Math.max(lNodes, rNodes); //返回当前树最大深度
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}

