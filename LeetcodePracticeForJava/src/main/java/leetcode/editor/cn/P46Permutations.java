//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        //TO TEST
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            int[] visited = new int[nums.length];
            getAllPermutations(nums, visited, lists, new ArrayList<Integer>());
            return lists;
        }

        public void getAllPermutations(int[] nums, int[] visited, List<List<Integer>> res, List<Integer> tmpList) {
            if (tmpList.size() == nums.length) {
                res.add(new ArrayList<>(tmpList));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1) {
                    continue;
                }
                visited[i] = 1;
                tmpList.add(nums[i]);
                getAllPermutations(nums, visited, res, tmpList);
                visited[i] = 0;
                tmpList.remove(tmpList.size() - 1);

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}