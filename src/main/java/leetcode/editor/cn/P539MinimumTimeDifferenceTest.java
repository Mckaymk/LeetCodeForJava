//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 👍 128 👎 0

package leetcode.editor.cn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class P539MinimumTimeDifferenceTest {
    @Test
    public void solutionTest() {
        Solution solution = new P539MinimumTimeDifferenceTest().new Solution();
        //TO TEST
        ArrayList<String> list = new ArrayList<>();
        list.add("02:00");
        list.add("23:59");
        list.add("01:00");
        assertEquals(0, solution.findMinDifference(list));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
//            鸽巢原理 根据题意，一共有 24 \times 60=144024×60=1440 种不同的时间。
            int n = timePoints.size();
            if (n > 1440) {
                return 0;
            }
            Collections.sort(timePoints);
            int min = Integer.MAX_VALUE;
            int pre = getMinutes(timePoints.get(0));
            for (int i = 1; i < timePoints.size(); i++) {
                int curr = getMinutes(timePoints.get(i));
                min = Math.min(min, curr - pre);
                pre = curr;

            }
            min = Math.min(min, getMinutes(timePoints.get(0)) + 1440 - pre);
            return min;
        }

        public int getMinutes(String t) {
            return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

