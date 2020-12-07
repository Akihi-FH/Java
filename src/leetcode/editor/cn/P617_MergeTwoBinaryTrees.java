//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 579 👎 0

package leetcode.editor.cn;

public class P617_MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new P617_MergeTwoBinaryTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 以 t1 为参照树
         * t1的左/右子结点 -> 合并后的左/右子树
         * <p>
         * t1、t2都不为null，t2的值加到t1上，
         * t1==null, return t2; t1左/右子结点指向 t2的左/右子结点
         * t2==null, return t1; t1左/右子结点指向不变
         *
         * @param t1
         * @param t2
         * @return
         */
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            /*if (t1 != null && t2 != null) {
                t1.val += t2.val;
            } else if (t1 != null) { //为真则 t2 = null
                return t1;
            } else { // t1 =null; t2!=null或t2==null
                return t2;
            }*/

            // 优化 if语句：
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

