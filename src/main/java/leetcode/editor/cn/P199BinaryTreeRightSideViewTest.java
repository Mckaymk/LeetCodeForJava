//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 635 👎 0

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class P199BinaryTreeRightSideViewTest {
    @Test
    public void solutionTest() {
        Solution solution = new P199BinaryTreeRightSideViewTest().new Solution();
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
        List<Integer> res = new ArrayList<>();
        int depth = 0;

        public List<Integer> rightSideView(TreeNode root) {
            preOrder2(root);
            return res;
        }

        void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            depth++;
            if (res.size() < depth) {
                res.add(root.val);
            }
            preOrder(root.right);
            preOrder(root.left);
            depth--;
        }

        void preOrder2(TreeNode root) {
            if (root == null) {
                return;
            }
            depth++;
            if (res.size() < depth) {
                res.add(root.val);
            }
            preOrder2(root.right);
            preOrder2(root.left);
            depth--;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

