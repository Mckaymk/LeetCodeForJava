//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表


package leetcode.editor.cn;

//java:K 个一组翻转链表
public class P25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1 || head == null) {
                return head;
            }
            return reverseList(head, k - 1);
        }

        private ListNode reverseList(ListNode head, int k) {

            ListNode pre = null, res = null;
            ListNode start = head;
            while (true) {
                ListNode end = start;
                int count;
                for (count = 0; count < k; count++) {
                    if (end == null) {
                        break;
                    }
                    end = end.next;
                }
                if (count != k || end == null) {
                    break;
                }
                ListNode tmpNode = end.next;
                end.next = null;
                reverse(start);
                if (pre == null) {
                    res = end;
                } else {
                    pre.next = end;
                }
                pre = start;
                start = tmpNode;
            }
            if (pre != null) {
                pre.next = start;
            }
            return res;

        }


        public ListNode reverseList1(ListNode head, int k) {
            ListNode pre = null, res = null;
            ListNode start = head;
            while (true) {
                int count;
                ListNode end = start;
                for (count = 0; count < k; count++) {
                    if (end == null) {
                        break;
                    }
                    end = end.next;
                }
                if (count != k || end == null) {
                    break;
                }
                ListNode node = end.next;
                end.next = null;
                reverse(start);

                if (pre != null) {
                    pre.next = end;
                } else {
                    res = end;
                }
                pre = start;
                start = node;
            }
            if (pre != null) {
                pre.next = start;
            }
            return res;

        }

        private void reverse(ListNode head) {
            ListNode pre = head;
            ListNode post = head.next;
            while (post != null) {
                ListNode tmp = post.next;
                post.next = pre;
                pre = post;
                post = tmp;
            }

        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}