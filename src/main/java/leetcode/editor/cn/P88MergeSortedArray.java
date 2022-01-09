//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.Arrays;

//java:合并两个有序数组
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        //TO TEST
        //1.(n+m)log(n+m)：暴力，先把两个数组，合并，在排序
        //2.n+m，将num1拷贝一份，双指针移动，向num1中填充，需要额外的空间
        //3.n+m，双指针，从后往前，不需要额外的空间
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
        int[] nums1 = {0};
        int[] nums2 = {1};
        solution.merge(nums1, 0, nums2, 1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = nums1.length - 1;
            m--;
            n--;
            while (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n]) {
                    nums1[i--] = nums1[m--];
                } else {
                    nums1[i--] = nums2[n--];
                }
            }
            while (n >= 0) {
                nums1[i--] = nums2[n--];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}