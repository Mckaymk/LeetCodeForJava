//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


package leetcode.editor.cn;

import java.util.*;

//java:二叉树的锯齿形层次遍历
public class P103BinaryTreeZigzagLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> listArrayList = new ArrayList<>();
            if (root == null) {
                return listArrayList;
            }

            Deque<TreeNode> queue = new LinkedList<TreeNode>();
            int level = 0;
            queue.add(root);
            while (!queue.isEmpty()) {

                listArrayList.add(new ArrayList<Integer>());

                TreeNode node = null;

                int n = queue.size();

                while (n > 0) {
                    if (level % 2 == 0) {
                        node = queue.pollFirst();

                        if (node.left != null) {
                            queue.add(node.left);
                        }
                        if (node.right != null) {
                            queue.add(node.right);
                        }


                    } else {
                        node = queue.pollLast();
                        if (node. right != null) {
                            queue.addFirst(node.right);
                        }
                        if (node.left != null) {
                            queue.addFirst(node.left);
                        }
                    }
                    listArrayList.get(level).add(node.val);
                    n--;
                }
                level++;
            }
            return listArrayList;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}