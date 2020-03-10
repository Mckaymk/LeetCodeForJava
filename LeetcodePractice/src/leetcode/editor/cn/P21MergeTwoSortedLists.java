//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//java:合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        //TO TEST
        List<Integer> list = new ArrayList<>();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode l3 = solution.mergeTwoLists(null, new ListNode(0));
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //iteratively
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }
            ListNode tmp;
            if (l1.val > l2.val) {
                tmp = l1;
                l1 = l2;
                l2 = tmp;
            }
            tmp = l1;
            ListNode p1 = tmp.next;
            ListNode p2 = l2;
            while (p1 != null && p2 != null) {
                if (p1.val > p2.val) {
                    tmp.next = p2;
                    p2 = p2.next;
                    tmp.next.next = p1;
                    tmp = tmp.next;
                } else {
                    tmp = p1;
                    p1 = p1.next;
                }
            }
            if (p2 != null) {
                tmp.next = p2;
            }
            return l1;
            //recursively
//            if (l1 == null) return l2;
//            if (l2 == null) return l1;
//            if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }

        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}