//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 584 👎 0


package leetcode.editor.cn;

//java:两两交换链表中的节点
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            ListNode res = new ListNode(-1);
            res.next = head;
            ListNode pre = res;
            while (head != null && head.next != null){
                ListNode first = head;
                ListNode second = head.next;

                pre.next = second;
                first.next = second.next;
                second.next = first;

                head = first.next;
                pre  = first;
            }

            return res.next;

        }








        public ListNode swapPairs1(ListNode head) {
            ListNode res = new ListNode(-1);
            res.next = head;
            ListNode preNode = res;
            while (head != null && head.next != null) {
                //确定交换节点
                ListNode firstNode = head;
                ListNode secondNode = head.next;
                //进行交换
                preNode.next = secondNode;
                firstNode.next = secondNode.next;
                secondNode.next = firstNode;
                //指向下一个要交换的节点
                preNode = firstNode;
                head = firstNode.next;

            }

            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}