//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


package leetcode.editor.cn;

import sun.util.resources.hu.CalendarData_hu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:二叉树的层次遍历
public class P102BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> listArrayList = new ArrayList<>();
            if (root == null) {
                return listArrayList;
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            int level = 0;
            queue.add(root);
            while (!queue.isEmpty()) {

                listArrayList.add(new ArrayList<Integer>());

                TreeNode node = null;

                int n = queue.size();

                while (n > 0) {
                    node = queue.poll();
                    listArrayList.get(level).add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    n--;
                }
                level++;
            }
            return listArrayList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}