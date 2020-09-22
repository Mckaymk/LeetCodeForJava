//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 468 👎 0


package leetcode.editor.cn;

//java:反转链表 II
public class P92ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
//            return getListNode01(head, m, n);
            if (head == null) {
                return head;
            }
            ListNode curr = head, pre = null;
            while (m > 1) {
                pre = curr;
                curr = curr.next;
                m--;
                n--;
            }
            ListNode before = pre;
            ListNode tail = curr;
            ListNode tmp = null;
            while (n > 0) {
                tmp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = tmp;
                n--;
            }
            if (before != null) {
                before.next = pre;
            } else {
                head = pre;
            }

            tail.next = curr;
            return head;

        }


        private ListNode getListNode01(ListNode head, int m, int n) {
            // Empty list
            if (head == null) {
                return null;
            }

            // Move the two pointers until they reach the proper starting point
            // in the list.
            ListNode cur = head, prev = null;
            while (m > 1) {
                prev = cur;
                cur = cur.next;
                m--;
                n--;
            }

            // The two pointers that will fix the final connections.
            ListNode con = prev, tail = cur;

            // Iteratively reverse the nodes until n becomes 0.
            ListNode third = null;
            while (n > 0) {
                third = cur.next;
                cur.next = prev;
                prev = cur;
                cur = third;
                n--;
            }

            // Adjust the final connections as explained in the algorithm
            if (con != null) {
                con.next = prev;
            } else {
                head = prev;
            }

            tail.next = cur;
            return head;
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

}