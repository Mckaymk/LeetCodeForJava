//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 553 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:四数之和
public class P18FourSum {
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        //TO TEST
        int[] nums = {0, 0, 0, 0};
        solution.fourSum(nums, 0);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            if (n < 4) {
                return res;
            }
            for (int i = 0; i < n - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < n - 2; j++) {

                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    int p = j + 1;
                    int q = n - 1;
                    while (p < q) {
                        int sum = nums[i] + nums[j] + nums[p] + nums[q];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                            while (p < q && nums[p + 1] == nums[p]) {
                                p++;
                            }
                            while (p < q && nums[q] == nums[q - 1]) {
                                q--;
                            }
                            p++;
                            q--;
                        } else if (sum < target) {
                            p++;
                        } else {
                            q--;
                        }
                    }

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}