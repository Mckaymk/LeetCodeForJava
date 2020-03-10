//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

package leetcode.editor.cn;

import java.util.*;

//java:字母异位词分组
public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        //TO TEST
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(str).toString());
        Solution1 solution1 = new P49GroupAnagrams().new Solution1();
        solution1.groupAnagrams(str);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @param strs:字符
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>(10);
            char[] ch;
            String tmpStr;
            for (String str : strs) {
                ch = str.toCharArray();
                Arrays.sort(ch);
                tmpStr = Arrays.toString(ch);
                if (!map.containsKey(tmpStr)){
                    map.put(tmpStr,new ArrayList<>());
                }
                map.get(tmpStr).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) {
                return new ArrayList();
            }
            Map<String, List> ans = new HashMap<String, List>();
            int[] count = new int[26];
            for (String s : strs) {
                Arrays.fill(count, 0);
                for (char c : s.toCharArray()) {
                    count[c - 'a']++;
                }

                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < 26; i++) {
                    sb.append('#');
                    sb.append(count[i]);
                }
                String key = sb.toString();
                System.out.println(key);
                if (!ans.containsKey(key)) {
                    ans.put(key, new ArrayList());
                }
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }

}