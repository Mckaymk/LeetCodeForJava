//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组

package leetcode.editor.cn;

//java:跳跃游戏
public class P55JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        //TO TEST
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
//        int[] nums = {2, 0, 0};
        System.out.println(solution.canJump(nums));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canJump(int[] nums) {
            //从右到左开始判断,每个位置的可以跳跃的最大长度
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }


        public boolean canJump2(int[] nums) {
            //从右到左开始判断，每个位置的跳跃情况
            int n = nums.length;
            int[] records = new int[n];
            records[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (records[i + j] == 1) {
                        records[i] = 1;
                        break;
                    }
                }
            }
            return records[0] == 1;
        }

//        public boolean canJump1(int[] nums) {
//            //检测每一个可跳跃的点，同时记录能跳跃的最远距离，如果可以一直跳到最后，则成功了
//            int k = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (i > k) {
//                    return false;
//                }
//                k = Math.max(k, i + nums[i]);
//            }
//            return true;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}