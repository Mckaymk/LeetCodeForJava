//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 778 👎 0

package leetcode.editor.cn;

import lombok.experimental.var;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class P145BinaryTreePostorderTraversalTest {
    @Test
    public void solutionTest() {
        Solution solution = new P145BinaryTreePostorderTraversalTest().new Solution();
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

        public List<Integer> postorderTraversal(TreeNode root) {
//            List<Integer> res = new ArrayList<>();
//            postOrder(root, res);
//            return res;
//            return postOrder2(root);
            return postOrder3(root);
        }

        void postOrder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            postOrder(root.left, res);
            postOrder(root.right, res);
            res.add(root.val);
        }

        List<Integer> postOrder2(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                res.addFirst(node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            return res;
        }

        List<Integer> postOrder3(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> op = new Stack<>();
            Stack<TreeNode> tmp = new Stack<>();
            op.push(root);
            while (!op.isEmpty()) {
                TreeNode curr = op.pop();
                tmp.push(curr);
                if (curr.left != null) {
                    op.push(curr.left);
                }
                if (curr.right != null) {
                    op.push(curr.right);
                }
            }

            while (!tmp.isEmpty()) {
                res.add(tmp.pop().val);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

