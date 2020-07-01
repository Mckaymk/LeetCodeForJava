//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;

//java:二叉搜索树中第K小的元素
public class P230KthSmallestElementInABst {
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
        Solution solution = new P230KthSmallestElementInABst().new Solution();
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
        public int kthSmallest(TreeNode root, int k) {
            //前序遍历递归
//            ArrayList<Integer> num = searchKthSmallest(root, new ArrayList<Integer>());
//            return num.get(k - 1);
            //迭代
            LinkedList<TreeNode> stack = new LinkedList<>();
            while (true) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.removeLast();
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            }

        }

        public ArrayList<Integer> searchKthSmallest(TreeNode root, ArrayList<Integer> arr) {

            if (root == null) {
                return arr;
            }
            searchKthSmallest(root.left, arr);
            arr.add(root.val);
            searchKthSmallest(root.right, arr);

            return arr;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}