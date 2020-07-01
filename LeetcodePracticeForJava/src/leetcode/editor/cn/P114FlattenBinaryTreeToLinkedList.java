//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.Stack;

//java:二叉树展开为链表
public class P114FlattenBinaryTreeToLinkedList {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
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
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(root);
            TreeNode pre = null;
            while (!s.isEmpty()) {
                TreeNode temp = s.pop();
                /***********修改的地方*************/
                if (pre != null) {
                    pre.right = temp;
                    pre.left = null;
                }
                /********************************/
                if (temp.right != null) {
                    s.push(temp.right);
                }
                if (temp.left != null) {
                    s.push(temp.left);
                }
                /***********修改的地方*************/
                pre = temp;
                /********************************/
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}