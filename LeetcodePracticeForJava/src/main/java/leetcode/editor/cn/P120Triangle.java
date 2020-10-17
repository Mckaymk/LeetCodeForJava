//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

//java:三角形最小路径和
public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        //TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }
            int[] dp = new int[triangle.size()];
            dp[0] = triangle.get(0).get(0);
            int pre = 0, curr;
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> tmpList = triangle.get(i);

                for (int j = 0; j < tmpList.size(); j++) {
                    //会被覆盖，所以需要一个变量存储当前dp中的值
                    curr = dp[j];
                    if (j == 0) {
                        dp[j] = curr + tmpList.get(j);
                    } else if (j == i) {
                        dp[j] = pre + tmpList.get(j);
                    } else {
                        dp[j] = Math.min(pre, curr) + tmpList.get(j);
                    }
                    pre = curr;
                }
            }
            int minPath = Integer.MAX_VALUE;
            System.out.println(Arrays.toString(dp));
            for (int i : dp) {
                minPath = Math.min(minPath, i);
            }
            return minPath;

        }


        public int minimumTotal1(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }
            // dp最大长度==triangle底边长度
            // 题意：只使用 O(n) 的额外空间（n 为三角形的总行数）
            int[] dp = new int[triangle.size()];
            dp[0] = triangle.get(0).get(0);

            // prev暂存dp[i-1][j-1],cur暂存dp[i-1][j]
            int prev = 0, cur;
            for (int i = 1; i < triangle.size(); i++) {
                //对每一行的元素进行推导
                List<Integer> rows = triangle.get(i);
                for (int j = 0; j <= i; j++) {
                    cur = dp[j];
                    if (j == 0) {
                        // 最左端特殊处理
                        dp[j] = cur + rows.get(j);
                    } else if (j == i) {
                        // 最右端特殊处理
                        dp[j] = prev + rows.get(j);
                    } else {
                        dp[j] = Math.min(cur, prev) + rows.get(j);
                    }
                    prev = cur;
                }
            }

            int res = Integer.MAX_VALUE;
            // dp最后一行记录了最小路径
            for (int i = 0; i < triangle.size(); i++) {
                res = Math.min(res, dp[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}