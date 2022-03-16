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
// Related Topics 树 深度优先搜索 二叉树 👍 935 👎 0

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;

class P543DiameterOfBinaryTreeTest {
    @Test
    public void solutionTest() {
        Solution solution = new P543DiameterOfBinaryTreeTest().new Solution();
        //TO TEST
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
        int maxLen = Integer.MIN_VALUE;

        public int diameterOfBinaryTree(TreeNode root) {
            postOrder2(root);
            return maxLen;
        }

        int postOrder(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = postOrder(root.left);
            int right = postOrder(root.right);
            maxLen = Math.max(left + right, maxLen);
            return Math.max(left, right) + 1;
        }

        int postOrder2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMax = postOrder2(root.left);
            int rightMax = postOrder2(root.right);
            maxLen = Math.max(maxLen, leftMax + rightMax);
            return Math.max(leftMax, rightMax) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

