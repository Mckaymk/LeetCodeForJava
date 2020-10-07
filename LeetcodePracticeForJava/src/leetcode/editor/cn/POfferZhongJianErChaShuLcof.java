//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 218 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:重建二叉树
public class POfferZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new POfferZhongJianErChaShuLcof().new Solution();
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
        private Map<Integer, Integer> indexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }

            return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }

        private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
            if (preorderLeft > preorderRight) {
                return null;
            }
            int preorderRoot = preorderLeft;
            int inorderRoot = indexMap.get(preorder[preorderRoot]);
            int sizeOfLeftSubTree = inorderRoot - inorderLeft;

            TreeNode root = new TreeNode(preorder[preorderRoot]);



            root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeOfLeftSubTree, inorderLeft, inorderRoot - 1);
            root.right = myBuildTree(preorder, inorder, preorderLeft + sizeOfLeftSubTree + 1, preorderRight, inorderRoot + 1, inorderRight);
            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}