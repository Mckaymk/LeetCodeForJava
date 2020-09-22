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
<<<<<<< HEAD
// 👍 396 👎 0
=======
// 👍 373 👎 0
>>>>>>> 4c9852c5397fc85c49b51bb582d525fe1ade9c45


package leetcode.editor.cn;

<<<<<<< HEAD
=======
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import javax.sound.midi.SoundbankResource;

>>>>>>> 4c9852c5397fc85c49b51bb582d525fe1ade9c45
//java:删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        //TO TEST
<<<<<<< HEAD
=======
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        ListNode listNode = solution.deleteDuplicates(root);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

>>>>>>> 4c9852c5397fc85c49b51bb582d525fe1ade9c45
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
=======
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            return head;
        }

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
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
>>>>>>> 4c9852c5397fc85c49b51bb582d525fe1ade9c45

}