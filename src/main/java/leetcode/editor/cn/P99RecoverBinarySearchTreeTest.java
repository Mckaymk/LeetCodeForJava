//给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 664 👎 0

package leetcode.editor.cn;

import lombok.val;
import org.junit.jupiter.api.Test;

class P99RecoverBinarySearchTreeTest {
    @Test
    public void solutionTest() {
        Solution solution = new P99RecoverBinarySearchTreeTest().new Solution();
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
        TreeNode first = null, second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {
            inorderTravel(root);
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }

        void inorderTravel(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTravel(root.left);
            if (root.val < prev.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            inorderTravel(root.right);
        }

        void inorderTravel2(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTravel2(root.left);
            if (root.val < prev.val) {
                if (first == null) {
                    first = root;
                }
                second = root;
            }
            prev = root;
            inorderTravel2(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

