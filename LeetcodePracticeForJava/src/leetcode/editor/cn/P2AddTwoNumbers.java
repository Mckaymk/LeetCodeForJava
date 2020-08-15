//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package leetcode.editor.cn;

//java:两数相加
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(-1);
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode p3 = res;
            int count = 0;
            while (p1 != null || p2 != null) {
                int x = (p1 != null) ? p1.val : 0;
                int y = (p2 != null) ? p2.val : 0;
                int sum = x + y + count;
                count = sum / 10;
                p3.next = new ListNode(sum % 10);
                p3 = p3.next;
                if (p1 != null) {
                    p1 = p1.next;
                }
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
            if (count > 0) {
                p3.next = new ListNode(count);
            }
            return res.next;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(-1);
            ListNode p = l1, q = l2, curr = res;
            int count = 0;
            while (p != null || q != null) {
                int x = p != null ? p.val : 0;
                int y = q != null ? q.val : 0;
                int sum = x + y + count;
                count = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }
            if (count > 0) {
                curr.next = new ListNode(count);
            }
            return res.next;
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