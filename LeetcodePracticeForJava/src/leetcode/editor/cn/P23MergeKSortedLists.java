//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法 
// 👍 843 👎 0


package leetcode.editor.cn;

//java:合并K个排序链表
public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return MergeList(lists, 0, lists.length - 1);
        }

        public ListNode MergeList(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = l + (r - l) / 2;
            return merge(MergeList(lists, l, mid), MergeList(lists, mid + 1, r));
        }

        public ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }
            ListNode res = new ListNode(-1);

            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode p3 = res;

            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p3.next = p1;
                    p1 = p1.next;
                } else {
                    p3.next = p2;
                    p2 = p2.next;
                }
                p3 = p3.next;
            }
            if (p1 != null) {
                p3.next = p1;
            }
            if (p2 != null) {
                p3.next = p2;
            }
            return res.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}