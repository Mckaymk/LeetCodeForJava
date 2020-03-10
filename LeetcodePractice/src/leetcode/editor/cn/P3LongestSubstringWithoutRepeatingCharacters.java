//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//java:无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt"));
        //TO TEST
        //1、暴力，找出所有子串
        //2、滑动窗口，设置一个窗口，在已知窗口中如果没有相同的就移动右边界，否则移动左边界，使用set
        //3、使用map去存储，同时每当有重复的，就跳到该重复字符串后一个，减少比较次数
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>(10);
            int res = 0, i = 0, j = 0;
            int n = s.length();
            char ch;
            while (i < n && j < n) {
                ch = s.charAt(j++);
                if (map.containsKey(ch) && map.get(ch) >= i) {
                    i = map.get(ch) + 1;
                }
                res = Math.max(res, j - i);
                map.put(ch, j - 1);
            }
            return res;

//            Set<Character> set = new HashSet<>();
//            int ans = 0, i = 0, j = 0;
//            int n = s.length();
//            while (i < n && j < n) {
//                if (!set.contains(s.charAt(j))){
//                    set.add(s.charAt(j++));
//                    ans = Math.max(ans,j-i);
//                }else {
//                    set.remove(s.charAt(i++));
//                }
//            }
//
//            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}