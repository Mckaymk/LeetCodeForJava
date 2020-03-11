//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//java:删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        //TO TEST
        //暴力遍历，找到倒数第n个节点
        //双指针，找到倒数第n+1个节点
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode tmp = new ListNode(0);
            tmp.next = head;
            ListNode preNode = tmp;
            ListNode nextNode = tmp;
            while (n >= 0) {
                nextNode = nextNode.next;
                n--;
            }
            while (nextNode != null) {
                nextNode = nextNode.next;
                preNode = preNode.next;
            }
            preNode.next = preNode.next.next;
            return tmp.next;
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