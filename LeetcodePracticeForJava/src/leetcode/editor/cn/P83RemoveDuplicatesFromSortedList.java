//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 

// 👍 396 👎 0


package leetcode.editor.cn;


//java:删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        //TO TEST
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        ListNode listNode = solution.deleteDuplicates(root);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pre = head;

            while (pre != null && pre.next != null) {
                if (pre.val == pre.next.val) {
                    pre.next = pre.next.next;
                } else {
                    pre = pre.next;
                }
            }

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    private ListNode getListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumpy = new ListNode(-1);
        ListNode pre = dumpy;
        ListNode p = head;
        while (p != null) {
            pre.next = p;
            pre = pre.next;
            ListNode curr = p.next;
            pre.next = null;
            while (curr != null && curr.val == p.val) {
                curr = curr.next;
            }
            p = curr;
        }
        return dumpy.next;
    }


    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}