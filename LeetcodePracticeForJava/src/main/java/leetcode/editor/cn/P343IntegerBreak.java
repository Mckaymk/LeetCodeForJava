//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 363 👎 0


package leetcode.editor.cn;

//java:整数拆分
public class P343IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new P343IntegerBreak().new Solution();
        //TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                int curMax = 0;
                for (int j = 1; j < i; j++) {
                    curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
                }
                dp[i] = curMax;
            }
            return dp[n];

//            if (n <= 3) {
//                return n - 1;
//            }
//            int a = n / 3, b = n % 3;
//            if (b == 0) {
//                return (int) Math.pow(3, a);
//            }
//            if (b == 1) {
//                return (int) Math.pow(3, a - 1) * 4;
//            }
//            return (int) Math.pow(3, a) * 2;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}