//给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = , k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁴ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1, nums2 均为升序排列 
// 1 <= k <= 1000 
// 
// Related Topics 数组 堆（优先队列） 👍 262 👎 0

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class P373FindKPairsWithSmallestSumsTest {
    @Test
    public void solutionTest() {
        Solution solution = new P373FindKPairsWithSmallestSumsTest().new Solution();
        //TO TEST
//        List<List<Integer>> res1 = solution.kSmallestPairs(new int[] {1, 7, 11}, new int[] {2, 4, 6}, 3);
//        System.out.println(res1);
//        List<List<Integer>> res2 = solution.kSmallestPairs(new int[] {1, 2, 4, 5, 6}, new int[] {3, 5, 7, 9}, 3);
        List<List<Integer>> res2 = solution.kSmallestPairs(new int[] {1, 1, 2}, new int[] {1, 2, 3}, 3);
        System.out.println(res2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int i = 0;
            int j = 0;
            List<List<Integer>> res = new ArrayList<>();
            while (k > 0) {
                ArrayList<Integer> tmpRes = new ArrayList<>();
                tmpRes.add(nums1[i]);
                tmpRes.add(nums2[j]);
                k -= 1;
                res.add(tmpRes);
                if (i == nums1.length - 1 && j == nums2.length - 1) {
                    break;
                }
                if (i + 1 < nums1.length && j + 1 < nums1.length) {
                    if ((nums1[i + 1] + nums1[j]) <= (nums1[i] + nums2[j + 1])) {
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    if (i < nums1.length) {
                        i++;
                    }
                    if (j < nums2.length) {
                        j++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

