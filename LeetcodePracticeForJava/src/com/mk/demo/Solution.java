package com.mk.demo;

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
    }
}
