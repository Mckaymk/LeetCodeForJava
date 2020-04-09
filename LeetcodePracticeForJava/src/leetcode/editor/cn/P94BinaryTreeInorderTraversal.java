//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


package leetcode.editor.cn;

import java.util.*;

//java:二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {


    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        //TO TEST
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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
        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> s = new Stack<TreeNode>();
            List<Integer> res = new ArrayList();
            if ( root == null){
                return res;
            }
            do {
                while (root != null) {
                    s.push(root);
                    root = root.left;
                }
                if (!s.isEmpty()) {
                    TreeNode node = s.pop();
                    res.add(node.val);
                    root = node.right;
                }
            } while (!s.isEmpty() || root != null);

            return res;
        }
    }


//    class Solution {
//        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> res = new ArrayList();
//            if (root != null) {
//                inorderTraverForRecursion(root, res);
//            }
//
//            return res;
//        }
//
//        public void inorderTraverForRecursion(TreeNode root, List<Integer> list) {
//            if (root.left != null) {
//                inorderTraverForRecursion(root.left, list);
//            }
//            list.add(root.val);
//            if (root.right != null) {
//                inorderTraverForRecursion(root.right, list);
//            }
//        }
//
//    }


//leetcode submit region end(Prohibit modification and deletion)

}