//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 279 👎 0


package leetcode.editor.cn;

import java.util.List;

//java:重排链表
public class P143ReorderList {
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();
        //TO TEST
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        solution.reorderList(root);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast.next != null && fast.next.next != null) {

                slow = slow.next;
                fast = fast.next.next;

            }
            if (fast.next != null) {
                fast = fast.next;
            }
            reverseList(slow.next);
//            ListNode tmp = fast;
//            while (tmp != null) {
//                System.out.print(tmp.val + " ");
//                tmp = tmp.next;
//            }
            slow.next = null;
            ListNode pre = head;
            while (pre != null && fast != null) {
                ListNode nextBefore = pre.next;
                ListNode nextAfter = fast.next;
                pre.next = fast;
                fast.next = nextBefore;

                pre = nextBefore;
                fast = nextAfter;

            }
            while (slow.next != null) {
                slow = slow.next;
            }
            if (fast != null) {
                slow.next = fast;
            }

        }

        private void reverseList(ListNode head) {

            ListNode pre = head;
            ListNode next = pre.next;
            pre.next = null;
            while (next != null) {
                ListNode tmp = next.next;
                next.next = pre;
                pre = next;
                next = tmp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}