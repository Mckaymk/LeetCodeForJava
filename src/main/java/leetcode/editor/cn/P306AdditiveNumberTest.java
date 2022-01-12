//累加数 是一个字符串，组成它的数字可以形成累加序列。 
//
// 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。 
//
// 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。 
//
// 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 
//
// 示例 1： 
//
// 
//输入："112358"
//输出：true 
//解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2： 
//
// 
//输入："199100199"
//输出：true 
//解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 35 
// num 仅由数字（0 - 9）组成 
// 
//
// 
//
// 进阶：你计划如何处理由过大的整数输入导致的溢出? 
// Related Topics 字符串 回溯 👍 222 👎 0

package leetcode.editor.cn;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.awt.*;

class P306AdditiveNumberTest {
    @Test
    public void solutionTest() {
        Solution solution = new P306AdditiveNumberTest().new Solution();
        //TO TEST
        assertTrue(solution.isAdditiveNumber("112358"));
//        assertTrue(solution.isAdditiveNumber("199100199"));
//        assertTrue(solution.isAdditiveNumber("101"));
//        assertTrue(solution.isAdditiveNumber("000"));
//        assertFalse(solution.isAdditiveNumber("1023"));
//        assertFalse(solution.isAdditiveNumber("0235813"));
//        assertFalse(solution.isAdditiveNumber("121224036"));
//        assertTrue(solution.isAdditiveNumber("198019823962"));
//        assertTrue(solution.isAdditiveNumber("11111111111011111111111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int first = 1; first < n - 1; first++) {
                if (num.charAt(0) == '0' && first != 1) {
                    break;
                }
                for (int second = first; second < n; second++) {

                    if (num.charAt(first) == '0' && first != second) {
                        break;
                    }

                    if (backtrackingV2(num, first, second)) {
                        return true;
                    }

                }

            }

            return false;
//            return backtrackingCal(num, 0, 1, 2);
        }

        public boolean backtrackingV2(String num, int secondStart, int secondEnd) {
            System.out.println(num + "=>" + secondStart + " " + secondEnd);
            int n = num.length();
            int firstStart = 0, firstEnd = secondStart - 1;
            while (secondEnd <= n - 1) {
                String thirdRes = twoStrAdd(num.substring(firstStart, firstEnd + 1), num.substring(secondStart, secondEnd + 1));
                int thirdStart = secondEnd + 1;
                int thirdEnd = secondEnd + thirdRes.length();
                System.out.println(thirdStart + "  " + thirdEnd + " " +thirdRes.length());
                String realThird = num.substring(thirdStart, thirdEnd + 1);

                if (thirdEnd >= n || !thirdRes.equals(realThird)) {
                    break;
                }
                if (thirdEnd == n - 1) {
                    return true;
                }
                firstStart = secondStart;
                firstEnd = secondEnd - 1;
                secondStart = secondEnd;
                secondEnd = thirdEnd;
            }
            return false;
        }

        private boolean backtrackingCal(String num, int start, int end, int res) {
            for (; end < num.length() - 1; end++) {
                String first = num.substring(start, end);
                if (end == res) {
                    res += 1;
                }
                for (int tmpRes = res; tmpRes < num.length(); tmpRes++) {
                    if (num.charAt(end) == '0' && end != tmpRes - 1) {
                        break;
                    }
                    String second = num.substring(end, tmpRes);
                    for (int j = tmpRes + 1; j <= num.length(); j++) {
                        if (num.charAt(tmpRes) == '0' && j != tmpRes + 1) {
                            break;
                        }
                        String result = num.substring(tmpRes, j);
                        if (twoStrAdd(first, second).equals(result)) {
                            if (j == num.length()) {
                                return true;
                            } else {
                                if (backtracking(num, end, tmpRes, j)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                if (num.charAt(start) == '0') {
                    break;
                }
            }
            return false;

        }

        public String twoStrAdd(String first, String second) {
            first = new StringBuffer(first).reverse().toString();
            second = new StringBuffer(second).reverse().toString();
            StringBuffer third = new StringBuffer();
            int firstLen = first.length();
            int secondLen = second.length();
            int index = Math.max(firstLen, secondLen);
            int cur = 0, carry = 0;
            for (int i = 0; i < index || carry != 0; i++) {
                cur = carry;
                if (i < firstLen) {
                    cur += (first.charAt(i) - '0');
                }
                if (i < secondLen) {
                    cur += (second.charAt(i) - '0');
                }
                carry = cur / 10;
                cur %= 10;
                third.append((char) (cur + '0'));
            }
            return third.reverse().toString();
        }

        public boolean backtracking(String num, int start, int end, int res) {
//            101
            for (int i = res + 1; i <= num.length(); i++) {
                String first = num.substring(start, end);
                String second = num.substring(end, res);
                String result = num.substring(res, i);
                if (twoStrAdd(first, second).equals(result)) {
                    if (i == num.length()) {
                        return true;
                    } else {
                        return backtracking(num, end, res, i);
                    }
                } else if (num.charAt(res) == '0') {
                    break;
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

