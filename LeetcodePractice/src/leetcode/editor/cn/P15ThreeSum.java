//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        solution.threeSum(nums);
        //TO TEST
        //1、n^3，暴力
        //1、n^2,hash表
        //1、n^2,双指针
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for(int k = 0; k < nums.length - 2; k++){
                if(nums[k] > 0) break;
                if(k > 0 && nums[k] == nums[k - 1]) continue;
                int i = k + 1, j = nums.length - 1;
                while(i < j){
                    int sum = nums[k] + nums[i] + nums[j];
                    if(sum < 0){
                        while(i < j && nums[i] == nums[++i]);
                    } else if (sum > 0) {
                        while(i < j && nums[j] == nums[--j]);
                    } else {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                        while(i < j && nums[i] == nums[++i]);
                        while(i < j && nums[j] == nums[--j]);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}