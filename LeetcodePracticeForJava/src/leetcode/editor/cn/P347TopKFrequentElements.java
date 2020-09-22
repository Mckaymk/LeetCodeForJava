//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 502 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//java:前 K 个高频元素
public class P347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        //TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] topKFrequent(int[] nums, int k) {
            // 统计每个数字出现的次数
            Map<Integer, Integer> counterMap = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
            // 构造Pair数组，Pair.num 表示数值，Pair.freq 表示数字出现的次数
            Pair[] pairs = IntStream.of(nums).distinct().boxed().map(num -> new Pair(num, counterMap.get(num))).toArray(Pair[]::new);
            // 使用快排变形 O(N) 获取Pair数组中频次最大的 k 个元素（第 4 个参数是下标，因此是 k - 1）。
            Pair[] topKPairs = quickSelect(pairs, 0, pairs.length - 1, k - 1);

            // 构造返回结果
            int[] res = new int[k];
            int idx = 0;
            for (Pair pair : topKPairs) {
                res[idx++] = pair.num;
            }
            return res;
        }

        private Pair[] quickSelect(Pair[] pairs, int lo, int hi, int idx) {
            if (lo > hi) {
                return new Pair[0];
            }
            // 快排切分后，j 左边的数字出现的次数都大于等于 pairs[j].freq，j 右边的数字出现的次数都小于等于 pairs[j].freq。
            int j = partition(pairs, lo, hi);
            // 如果 j 正好等于目标idx，说明当前pairs数组中的[0, idx]就是出现次数最大的 K 个元素。
            if (j == idx) {
                return Arrays.copyOf(pairs, idx + 1);
            }
            // 否则根据 j 与 idx 的大小关系判断找左段还是右段
            return j < idx ? quickSelect(pairs, j + 1, hi, idx) : quickSelect(pairs, lo, j - 1, idx);
        }

        private int partition(Pair[] pairs, int lo, int hi) {
            Pair v = pairs[lo];
            int i = lo, j = hi + 1;
            while (true) {
                while (++i <= hi && pairs[i].freq > v.freq) {
                }
                while (--j >= lo && pairs[j].freq < v.freq) {
                }
                if (i >= j) {
                    break;
                }
                Pair tmp = pairs[i];
                pairs[i] = pairs[j];
                pairs[j] = tmp;
            }
            pairs[lo] = pairs[j];
            pairs[j] = v;
            return j;
        }

        public int[] topKFrequent1(int[] nums, int k) {

            // 统计每个数字出现的次数
            Map<Integer, Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
            // 定义小根堆，根据数字频率自小到大排序
            Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> counter.get(v1) - counter.get(v2));
            // 遍历数组，维护一个大小为 k 的小根堆：
            // 不足 k 个直接将当前数字加入到堆中；否则判断堆中的最小次数是否小于当前数字的出现次数，若是，则删掉堆中出现次数最少的一个数字，将当前数字加入堆中。
            counter.forEach((num, cnt) -> {
                if (pq.size() < k) {
                    pq.offer(num);
                } else if (counter.get(pq.peek()) < cnt) {
                    pq.poll();
                    pq.offer(num);
                }
            });
            // 构造返回结果
            int[] res = new int[k];
            int idx = 0;
            for (int num : pq) {
                res[idx++] = num;
            }
            return res;
        }
    }

    class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


