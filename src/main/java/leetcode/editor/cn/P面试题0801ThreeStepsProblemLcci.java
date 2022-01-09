//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 动态规划 
// 👍 19 👎 0


package leetcode.editor.cn;

//java:三步问题
public class P面试题0801ThreeStepsProblemLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题0801ThreeStepsProblemLcci().new Solution();
        //TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToStep(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (n == 3) {
                return 4;
            }
            int one = 1;
            int two = 2;
            int three = 4;
            int res = 0;
            for (int i = 4; i <= n; i++) {
                res = one + two;
                if (res > 1000000007) {
                    res -= 1000000007;
                }
                res += three;
                if (res > 1000000007) {
                    res -= 1000000007;
                }
                one = two;
                two = three;
                three = res;
            }
            return res;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}