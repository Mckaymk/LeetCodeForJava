//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:接雨水
public class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        //TO TEST
        //1、n^2，暴力解法，从从左到右，遍历每列可以接多少雨水
        //2、左右双指针
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height.length <= 1) {
                return 0;
            }
            int res = 0;
            int leftMax = height[0];
            int rightMax = 0;
            for (int i = 1; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    rightMax = Math.max(rightMax, height[j]);
                }
//                for (int j = 0; j < i; j++) {
//                    leftMax = Math.max(leftMax, height[j]);
//                }
                if (height[i] < leftMax && height[i] < rightMax) {
//                    System.out.println();
                    res += Math.min(rightMax, leftMax) - height[i];
                }
                leftMax = Math.max(height[i],leftMax);
                rightMax = 0;
            }
            return res;

//            左右双指针
//            if (height.length <= 1) {
//                return 0;
//            }
//            int res = 0;
//            int left = 0, right = height.length - 1;
//            int left_max = 0, right_max = 0;
//            while (left < right) {
//                if (height[left] < height[right]) {
//                    if (height[left] >= left_max) {
//                        left_max = height[left];
//                    } else {
//                        res += (left_max - height[left]);
//                    }
//                    left++;
//                } else {
//                    if (height[right] >= right_max) {
//                        right_max = height[right];
//                    }
//                    {
//                        res += (right_max - height[right]);
//                    }
//                    --right;
//                }
//            }
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}