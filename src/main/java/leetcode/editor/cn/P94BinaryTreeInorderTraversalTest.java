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
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1281 👎 0

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class P94BinaryTreeInorderTraversalTest {
    @Test
    public void solutionTest() {
        Solution solution = new P94BinaryTreeInorderTraversalTest().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
//            ArrayList<Integer> res = new ArrayList<>();
//            recursion(root, res);
//            return res;
//            return iter(root);
            return iter2(root);
        }

        public void recursion(TreeNode root, List<Integer> res) {

            if (root == null) {
                return;
            }
            recursion(root.left, res);
            res.add(root.val);
            recursion(root.right, res);
        }

        public List<Integer> iter(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            ArrayList<Integer> res = new ArrayList<>();
            while (!stack.isEmpty() || curr != null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    TreeNode tmp = stack.pop();
                    res.add(tmp.val);
                    curr = tmp.right;
                }
            }
            return res;
        }

        public List<Integer> iter2(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();
            TreeNode curr = root;

            while (!stack.isEmpty() || curr != null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    res.add(curr.val);
                    curr = curr.right;
                }

            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

