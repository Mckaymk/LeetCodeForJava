//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
<<<<<<< HEAD
// 👍 371 👎 0
=======
// 👍 343 👎 0
>>>>>>> 4c9852c5397fc85c49b51bb582d525fe1ade9c45


package leetcode.editor.cn;

<<<<<<< HEAD
=======
import java.rmi.UnexpectedException;

>>>>>>> 4c9852c5397fc85c49b51bb582d525fe1ade9c45
//java:删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
<<<<<<< HEAD
            return getListNode01(head);
        }

        private ListNode getListNode01(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;
            for (ListNode pre = head, post = head; pre != null; pre = post) {
                while (post != null && post.val == pre.val) {
                    post = post.next;
                }
                if (pre.next == post) {
                    tail.next = pre;
                    tail = pre;
                    tail.next = null;
                }
            }

=======
            if (head == null) {
                return head;
            }
            ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
            ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。

            for (ListNode l = head, r = head; l != null; l = r) {
                while (r != null && r.val == l.val) {
                    r = r.next;
                }
                if (l.next == r) {
                    tail.next = l;
                    tail = l;
                    tail.next = null;
                }
            }
>>>>>>> 4c9852c5397fc85c49b51bb582d525fe1ade9c45
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

<<<<<<< HEAD
=======
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
>>>>>>> 4c9852c5397fc85c49b51bb582d525fe1ade9c45
}