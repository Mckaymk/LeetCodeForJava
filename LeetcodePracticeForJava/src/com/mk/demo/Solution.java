package com.mk.demo;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Mckay
 * @create 2020-09-10
 * @description
 **/
class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));

    }

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
}

class Pair {
    int num;
    int freq;

    public Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
=======
import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author MengKai
 * @create 2020-09-06
 */

public class Solution {
    /**
     *
     * @param
     * @return string字符串一维数组
     */


    static class StringArray implements Comparable {
        List<Integer> list = new ArrayList<>();

        StringArray(String str) {
            String[] split = str.split("\\.");
            for (String s : split) {
                list.add(Integer.parseInt(s));
            }

        }

        @Override
        public int compareTo(Object o) {
            StringArray tmp = (StringArray) o;
            int n = Math.min(tmp.list.size(), this.list.size());
            for (int i = 0; i < n; i++) {
                if (this.list.get(i) > tmp.list.get(i)) {
                    return -1;
                } else if (this.list.get(i) < tmp.list.get(i)) {
                    return 1;
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\"");
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
                if (i < list.size() - 1) {
                    stringBuilder.append(".");
                }
            }
            stringBuilder.append("\"");
            return stringBuilder.toString();
        }
    }

    public String[] sortMethod (String[] stringArray) {
        // write code here
        List<StringArray> stringArrays = new ArrayList<>();
        for (String str : stringArray) {
            stringArrays.add(new StringArray(str));
        }

        stringArrays.sort(StringArray::compareTo);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < stringArrays.size(); i++) {
            stringBuilder.append(stringArrays.get(i).toString() );
            if (i < stringArrays.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return null;
>>>>>>> 4c9852c5397fc85c49b51bb582d525fe1ade9c45
    }
}
