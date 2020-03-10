//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//java:电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();

        //TO TEST
        //1、递归回溯
        System.out.println(solution.letterCombinations("5678"));


    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        HashMap<String, String> mapPhone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        List<String> ouput = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            //递归
//            if (digits.length() != 0){
//                strCombination("", digits);
//            }
//            return ouput;

            //队列，迭代
            LinkedList<String> linkedList = new LinkedList<>();
            if (digits.length() > 0) {
                linkedList.add("");
                String[] digitMapLetter = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
                while (linkedList.peek().length() != digits.length()) {
                    String popStr = linkedList.remove();
                    String letter = digitMapLetter[digits.charAt(popStr.length()) - '0'];
                    for (char ch : letter.toCharArray()) {
                        linkedList.addLast(popStr + ch);
                    }

                }
            }
            return linkedList;

        }

        public void strCombination(String combination, String nextStr) {
            if (nextStr.length() == 0) {
                ouput.add(combination);
            } else {
                String strDigit = nextStr.substring(0, 1);
                String letters = mapPhone.get(strDigit);
                for (int i = 0; i < letters.length(); i++) {
                    String letter = letters.substring(i, i + 1);
                    strCombination(combination + letter, nextStr.substring(1));
                }

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}