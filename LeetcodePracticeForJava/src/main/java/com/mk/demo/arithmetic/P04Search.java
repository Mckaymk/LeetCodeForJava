package com.mk.demo.arithmetic;

/**
 * @author MengKai
 * @create 2020-04-08
 */
public class P04Search {
    public int threePointsSearch(int key, int low, int high, int[] array) {
        if (low > high) {
            return -1;
        }
        //平均划分为三等份
        int mid1 = low + (high - low) / 3;
        int mid2 = mid1 + (high - low) / 3;
        if (array[mid1] == key) {
            return mid1;
        } else if (array[mid1] > key) {
            //大了，在第一份里继续找
            return threePointsSearch(key, low, mid1 - 1, array);
        } else if (array[mid2] == key) {
            return mid2;
        } else if (array[mid2] > key) {
            //又大了，在第二份里找
            return threePointsSearch(key, mid1 + 1, mid2 - 1, array);
        } else {
            //否则，在第三份里找
            return threePointsSearch(key, mid2 + 1, high, array);
        }
    }

    public static void main(String[] args) {
        P04Search search = new P04Search();
        int[] nums = {1, 3, 4, 8, 9, 10, 12, 15, 18, 19, 20, 25, 26, 29, 30};
//        int key = 29;
//        int key = 15;
        int key = 3;
        System.out.println(search.threePointsSearch(key, 0, nums.length - 1, nums));

    }
}
