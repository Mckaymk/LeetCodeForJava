//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

//java:移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        //TO TEST
        //1.新建一个数组，不为0的放前面，为0的放后面
        //2.双指针，一个表示不为0的，一个表示有0的，
        //3.两次循环，第一次把不为0的放到前面，同时统计0的个数，第二次把0填充回去
//        int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {1, 2, 0, 3};
        solution.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }

            //第一遍循环，设置一个不为0指针，把不为0的往前移动，在后面填充0
//            if (nums == null || nums.length == 0) return;
//
//            int insertPos = 0;
//            for (int num: nums) {
//                if (num != 0) nums[insertPos++] = num;
//            }
//
//            while (insertPos < nums.length) {
//                nums[insertPos++] = 0;
//            }

            //判断第i个不为0，在移动
//            int i = 0;
//            int j = 0;
//            while (i < nums.length) {
//                if (nums[i] != 0) {
//                    nums[j] = nums[i];
//                    if (i != j) {
//                        nums[i] = 0;
//                    }
//                    j++;
//                }
//                i++;
//            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}