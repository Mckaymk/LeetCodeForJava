//给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。 
//
// 回想一下： 
//
// 
// 叶节点 是二叉树中没有子节点的节点 
// 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1 
// 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。 
// 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,3]
//输出：[1,2,3]
//解释： 
//最深的叶子是值为 2 和 3 的节点。
//这些叶子的最近共同祖先是值为 1 的节点。
//返回的答案为序列化的 TreeNode 对象（不是数组）"[1,2,3]" 。 
//
// 示例 2： 
//
// 输入：root = [1,2,3,4]
//输出：[4]
// 
//
// 示例 3： 
//
// 输入：root = [1,2,3,4,5]
//输出：[2,4,5]
// 
//
// 
//
// 提示： 
//
// 
// 给你的树中将有 1 到 1000 个节点。 
// 树中每个节点的值都在 1 到 1000 之间。 
// 
// Related Topics 树 深度优先搜索 
// 👍 50 👎 0


package leetcode.editor.cn;

//java:最深叶节点的最近公共祖先
public class P1123LowestCommonAncestorOfDeepestLeaves {
    public static void main(String[] args) {
        Solution solution = new P1123LowestCommonAncestorOfDeepestLeaves().new Solution();
        //TO TEST
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(solution.lcaDeepestLeaves(root));

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
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
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            if (root == null) {
                return null;
            }
            int ld = depth(root.left);
            int rd = depth(root.right);
            System.out.println(ld);
            System.out.println(rd);
            if (ld == rd) {
                return root;
            } else if (ld > rd) {
                return lcaDeepestLeaves(root.left);
            } else {
                return lcaDeepestLeaves(root.right);
            }
        }

        public int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = depth(node.right);
            int right = depth(node.left);
            return Math.max(left, right) + 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}