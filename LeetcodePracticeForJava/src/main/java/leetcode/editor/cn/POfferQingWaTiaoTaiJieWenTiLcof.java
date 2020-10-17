//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 74 👎 0


package leetcode.editor.cn;

//java:青蛙跳台阶问题
public class POfferQingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new POfferQingWaTiaoTaiJieWenTiLcof().new Solution();
        //TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {

            if (n <= 1) {
                return 1;
            }
            int one = 1;
            int two = 1;
            int res = 0;
            while (n >= 2) {
                res = one + two;
                if (res > 1000000007) {
                    res -= 1000000007;
                }
                one = two;
                two = res;
                n--;
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}