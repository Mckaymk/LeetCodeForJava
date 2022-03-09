//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1577 👎 0

package leetcode.editor.cn;

import org.junit.jupiter.api.Test;

class P96UniqueBinarySearchTreesTest {
    @Test
    public void solutionTest() {
        Solution solution = new P96UniqueBinarySearchTreesTest().new Solution();
        //TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int numTrees(int n) {
            memo = new int[n + 1][n + 1];
            return count2(1, n);
        }

        private int count(int lo, int hi) {
            if (lo > hi) {
                return 1;
            }
            if (memo[lo][hi] != 0) {
                return memo[lo][hi];
            }
            int res = 0;
            for (int i = lo; i <= hi; i++) {
                int left = count(lo, i - 1);
                int right = count(i + 1, hi);
                res += left * right;
            }
            memo[lo][hi] = res;
            return res;
        }

        private int count2(int lo, int hi) {
            if (lo >= hi) {
                return 1;
            }
            if (memo[lo][hi] != 0) {
                return memo[lo][hi];
            }
            int res = 0;
            for (int i = lo; i <= hi; i++) {
                int left = count2(lo, i - 1);
                int right = count2(i + 1, hi);
                res += left * right;
            }
            memo[lo][hi] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

