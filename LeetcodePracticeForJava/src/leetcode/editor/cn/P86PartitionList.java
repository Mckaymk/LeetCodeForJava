//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 242 👎 0


package leetcode.editor.cn;

//java:分隔链表
public class P86PartitionList {
    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
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
        public ListNode partition(ListNode head, int x) {

//            return partition01(head, x);
            ListNode beforeHead = new ListNode(-1);
            ListNode afterHead = new ListNode(-1);
            ListNode before = beforeHead;
            ListNode after = afterHead;
            while (head != null) {
                if (head.val < x) {
                    before.next = head;
                    before = before.next;
                } else {
                    after.next = head;
                    after = after.next;
                }
                head = head.next;
            }
            after.next = null;
            before.next = afterHead.next;

            return beforeHead.next;
        }


        private ListNode partition01(ListNode head, int x) {
            ListNode before_head = new ListNode(0);
            ListNode before = before_head;
            ListNode after_head = new ListNode(0);
            ListNode after = after_head;

            while (head != null) {

                if (head.val < x) {
                    before.next = head;
                    before = before.next;
                } else {
                    after.next = head;
                    after = after.next;
                }

                head = head.next;
            }

            after.next = null;


            before.next = after_head.next;

            return before_head.next;
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