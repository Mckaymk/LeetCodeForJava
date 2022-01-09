//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:路径总和 II
public class P113PathSumIi {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {


        Solution solution = new P113PathSumIi().new Solution();
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
        List<List<Integer>> allList = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<Integer> list = new ArrayList<>();
            dps(root, sum, list);
            return allList;
        }

        public void dps(TreeNode root, int sum, List<Integer> list) {
            if (root != null) {
                if (root.left == null && root.right == null) {
                    if (sum - root.val == 0) {
                        List<Integer> list1 = new ArrayList<>(list);
                        list1.add(root.val);
                        allList.add(list1);
                    }
                } else {
                    list.add(root.val);
                    dps(root.left, sum - root.val, new ArrayList<>(list));
                    dps(root.right, sum - root.val, new ArrayList<>(list));
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}