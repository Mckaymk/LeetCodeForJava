//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找

package leetcode.editor.cn;

//java:在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        //TO TEST
        //先二分查找目标值，在向两边查找是否还有相同的
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        nums = solution.searchRange(nums, 6);

        int[] nums = {5,7,7,8,8,10};
        nums = solution.searchRange(nums, 8);

        System.out.println(nums[0]);
        System.out.println(nums[1]);

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = -1;
            int end = -1;
            int left = 0;
            int right = nums.length - 1;
            //二分查找
            while (left <= right) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) {
                    start = end = middle;
                    break;
                } else {
                    if (nums[middle] > target) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                }
            }

            while (start - 1 >= 0) {
                if (nums[start - 1] == target) {
                    start--;
                } else {
                    break;
                }
            }
            while (end + 1 < nums.length && end != -1) {
                if (nums[end + 1] == target) {
                    end++;
                } else {
                    break;
                }
            }

            return new int[]{start, end};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}