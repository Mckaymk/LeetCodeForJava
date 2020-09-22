//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

//java:最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        //TO TEST
//        System.out.println(solution.longestPalindrome1("babad"));
//        System.out.println(solution.longestPalindrome2("babad"));
        System.out.println(solution.longestPalindrome3("babad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            return null;
        }

        public String longestPalindrome3(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            boolean[][] dp = new boolean[len][len];
            char[] charArray = s.toCharArray();
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            int maxLen = 1;
            int begin = 0;
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }

                }
            }

            return s.substring(begin, begin + maxLen);

        }

        public String longestPalindrome2(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int maxLen = 1;
            int begin = 0;
            char[] charArray = s.toCharArray();
            for (int i = 0; i < len - 1; i++) {
                int oddLen = expandAroundCenter(charArray, i, i);
                int evenLen = expandAroundCenter(charArray, i, i + 1);

                int curMaxLen = Math.max(oddLen, evenLen);
                if (curMaxLen > maxLen) {
                    maxLen = curMaxLen;
                    begin = i - (maxLen - 1) / 2;
                }
            }
            return s.substring(begin, begin + maxLen);

        }

        public int expandAroundCenter(char[] charArray, int left, int right) {
            int len = charArray.length;
            int i = left;
            int j = right;
            while (i >= 0 && j < len) {
                if (charArray[i] == charArray[j]) {
                    i--;
                    j++;
                } else {
                    break;
                }
            }

            return j - i - 1;
        }


        public String longestPalindrome1(String s) {
            //暴力解法
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            char[] charArray = s.toCharArray();

            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }

        private boolean validPalindromic(char[] charArray, int left, int right) {
            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}