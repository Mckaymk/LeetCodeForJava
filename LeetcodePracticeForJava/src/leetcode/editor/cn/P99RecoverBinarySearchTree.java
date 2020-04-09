//二叉搜索树中的两个节点被错误地交换。 
//
// 请在不改变其结构的情况下，恢复这棵树。 
//
// 示例 1: 
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// 示例 2: 
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3 
//
// 进阶: 
//
// 
// 使用 O(n) 空间复杂度的解法很容易实现。 
// 你能想出一个只使用常数空间的解决方案吗？ 
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//java:恢复二叉搜索树
public class P99RecoverBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new P99RecoverBinarySearchTree().new Solution();
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void swap(TreeNode a, TreeNode b) {
            int tmp = a.val;
            a.val = b.val;
            b.val = tmp;
        }

        public void recoverTree(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque();
            TreeNode x = null, y = null, pred = null;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.removeLast();
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) x = pred;
                    else break;
                }
                pred = root;
                root = root.right;
            }

            swap(x, y);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}