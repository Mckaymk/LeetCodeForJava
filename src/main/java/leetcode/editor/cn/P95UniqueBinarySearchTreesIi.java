//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics 树 动态规划


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//java:不同的二叉搜索树 II
public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {


        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> pre = new ArrayList<TreeNode>();
            if (n == 0) {
                return pre;
            }
            pre.add(null);
            //每次增加一个数字
            for (int i = 1; i <= n; i++) {
                List<TreeNode> cur = new ArrayList<>();
                //遍历之前的所有解
                for (TreeNode root : pre) {
                    //插入到根节点
                    TreeNode insert = new TreeNode(i);
                    insert.left = root;
                    cur.add(insert);
                    //插入到右孩子，右孩子的右孩子...最多找 n 次孩子
                    for (int j = 0; j <= n; j++) {
                        TreeNode root_copy = treeCopy(root); //复制当前的树
                        TreeNode right = root_copy; //找到要插入右孩子的位置
                        int k = 0;
                        //遍历 j 次找右孩子
                        for (; k < j; k++) {
                            if (right == null) {
                                break;
                            }
                            right = right.right;
                        }
                        //到达 null 提前结束
                        if (right == null) {
                            break;
                        }
                        //保存当前右孩子的位置的子树作为插入节点的左孩子
                        TreeNode rightTree = right.right;
                        insert = new TreeNode(i);
                        right.right = insert; //右孩子是插入的节点
                        insert.left = rightTree; //插入节点的左孩子更新为插入位置之前的子树
                        //加入结果中
                        cur.add(root_copy);
                    }
                }
                pre = cur;

            }
            return pre;
        }


        private TreeNode treeCopy(TreeNode root) {
            if (root == null) {
                return root;
            }
            TreeNode newRoot = new TreeNode(root.val);
            newRoot.left = treeCopy(root.left);
            newRoot.right = treeCopy(root.right);
            return newRoot;
        }


//        public List<TreeNode> generateTrees(int n) {
//            if (n == 0) {
//                return new LinkedList<TreeNode>();
//            }
//            return generateBinarySearchTree(1, n);
//        }
//
//        public List<TreeNode> generateBinarySearchTree(int start, int end) {
//            List<TreeNode> res = new LinkedList<>();
//            if (start > end) {
//                res.add(null);
//            }
//            for (int i = start; i <= end; i++) {
//                List<TreeNode> leftTree = generateBinarySearchTree(start, i - 1);
//                List<TreeNode> rightTree = generateBinarySearchTree(i+1, end);
//                for (TreeNode left : leftTree) {
//                    for (TreeNode right : rightTree) {
//                        TreeNode node = new TreeNode(i);
//                        node.left = left;
//                        node.right = right;
//                        res.add(node);
//                    }
//                }
//
//            }
//            return res;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}