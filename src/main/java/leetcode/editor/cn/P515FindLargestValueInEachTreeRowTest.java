//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 173 👎 0

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P515FindLargestValueInEachTreeRowTest {
    @Test
    public void solutionTest() {
        Solution solution = new P515FindLargestValueInEachTreeRowTest().new Solution();
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
        public List<Integer> largestValues(TreeNode root) {
            return levelTraver(root);
        }

        private List<Integer> levelTraver(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int size = 1;
            while (!queue.isEmpty()) {
                int max = Integer.MIN_VALUE;
                int nextSize = 0;
                while (size > 0) {
                    TreeNode tmp = queue.poll();
                    max = Math.max(max, tmp.val);
                    size--;
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                        nextSize++;
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                        nextSize++;
                    }
                }
                res.add(max);
                size = nextSize;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

