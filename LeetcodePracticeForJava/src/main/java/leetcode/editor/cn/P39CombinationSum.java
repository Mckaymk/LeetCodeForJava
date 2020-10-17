//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:组合总和
public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        //TO TEST
        int[] nums = {2, 3, 5};
        System.out.println(solution.combinationSum(nums, 8));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            getResultList(candidates, target, res, 0, new ArrayList<Integer>());
            return res;
        }

        public void getResultList(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmpList) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(tmpList));
                return;
            }
            for (int start = i; start < candidates.length; start++) {
                if (target < candidates[start]) {
                    break;
                }
                tmpList.add(candidates[start]);
                getResultList(candidates, target - candidates[start], res, start, tmpList);
                //回溯
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}