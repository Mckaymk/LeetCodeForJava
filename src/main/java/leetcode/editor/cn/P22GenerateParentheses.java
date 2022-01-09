//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        //TO TEST
        //回溯递归
        System.out.println(solution.generateParenthesis(3));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> list = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            getStrParentheses("", 0, 0, n);
            return list;
        }

        public void getStrParentheses(String tmp, int left, int right, int n) {
            if (tmp.length() == n * 2) {
                list.add(tmp);
                return;
            }
            if (left < n) {
                getStrParentheses(tmp + "(", left + 1, right, n);
            }
            if (left > right) {
                getStrParentheses(tmp + ")", left, right + 1, n);
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}