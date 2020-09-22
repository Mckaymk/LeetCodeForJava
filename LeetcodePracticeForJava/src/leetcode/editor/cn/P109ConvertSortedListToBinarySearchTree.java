//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 278 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:有序链表转换二叉搜索树
public class P109ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P109ConvertSortedListToBinarySearchTree().new Solution();
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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

        private List<Integer> values;

        public Solution() {
            this.values = new ArrayList<Integer>();
        }

        private void mapListToValues(ListNode head) {
            while (head != null) {
                this.values.add(head.val);
                head = head.next;
            }
        }

        private TreeNode convertListToBST(int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left)/2;
            TreeNode head = new TreeNode(this.values.get(mid));
            head.left = convertListToBST(left,mid-1);
            head.right = convertListToBST(mid+1,right);
            return head;
        }

        public TreeNode sortedListToBST(ListNode head) {

            // Form an array out of the given linked list and then
            // use the array to form the BST.
            this.mapListToValues(head);

            // Convert the array to
            return convertListToBST(0, this.values.size() - 1);
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}