//Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。 
//
// 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。 
//
// 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：10
//解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
// 
//
// 示例 2： 
//
// 输入：n = 10
//输出：37
//解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，
//Hercy 存入 2 块钱。28 + 28 + 7 = 56 + 7 = 63
// 
//
// 示例 3： 
//
// 输入：n = 20
//输出：96
//解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 
//+ 4 + 5 + 6 + 7 + 8) = 96 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 数学 👍 61 👎 0

package leetcode.editor.cn;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


class P1716CalculateMoneyInLeetcodeBankTest {
    @Test
    public void solutionTest() {
        Solution solution = new P1716CalculateMoneyInLeetcodeBankTest().new Solution();
        //TO TEST
        assertEquals(37, solution.totalMoney(10));
        assertEquals(96, solution.totalMoney(20));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalMoney(int n) {
            int totalWeek = n / 7;
            int surplusDay = n % 7;
            int firstWeekMoney = (1 + 7) * 7 / 2;
            int lastWeekMoney = (totalWeek - 1) * 7 + firstWeekMoney;
            int weekDayMoney = (firstWeekMoney + lastWeekMoney) * totalWeek / 2;
            int surplusDayMoney = (totalWeek + 1 + totalWeek + 1 + surplusDay - 1) * surplusDay / 2;
            return weekDayMoney + surplusDayMoney;
        }

        public int totalMoneyV2(int n) {
            int mon = 1;
            int sum = 0;
            while (n > 0) {
                for (int i = 0; i < 7; i++) {
                    sum += mon + i;
                    n -= 1;
                    if (n <= 0) {
                        break;
                    }
                }
                mon++;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

