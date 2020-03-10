//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//java:合并区间
public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        //TO TEST
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(nums);
        for (int[] num : result) {
            for (int i : num) {
                System.out.println(i);
            }
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Interval {
            int start;
            int end;

            Interval(int[] interval) {
                this.start = interval[0];
                this.end = interval[1];
            }

            int[] toArray() {
                return new int[]{this.start, this.end};
            }
        }

        class IntervalComparator implements Comparator<Interval> {

            @Override
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        }

        public int[][] merge(int[][] intervals) {
            List<Interval> intervalsList = new LinkedList<>();
            for (int[] interval : intervals) {
                intervalsList.add(new Interval(interval));
            }
            intervalsList.sort(new IntervalComparator());

            LinkedList<Interval> merged = new LinkedList<>();
            for (Interval interval : intervalsList) {
                // if the list of merged intervals is empty or if the current
                // interval does not overlap with the previous, simply append it.
                if (merged.isEmpty() || merged.getLast().end < interval.start) {
                    merged.add(interval);
                }
                // otherwise, there is overlap, so we merge the current and previous
                // intervals.
                else {
                    merged.getLast().end = Math.max(merged.getLast().end, interval.end);
                }
            }

            int i = 0;
            int[][] result = new int[merged.size()][2];
            for (Interval mergedInterval : merged) {
                result[i] = mergedInterval.toArray();
                i++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}