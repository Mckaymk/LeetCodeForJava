package com.mk.demo.arithmetic;

/**
 * @author MengKai
 * @create 2020-04-08
 */
public class Search {
    public int threePointsSearch(int key, int low, int high, int[] array) {
        if (low > high) {
            return -1;
        }
        int mid1 = low + (high - low) / 3;
        int mid2 = mid1 + (high - low) / 3;
        if (array[mid1] == key) {
            return mid1;
        } else if (array[mid1] > key) {
            return threePointsSearch(key, low, mid1 - 1, array);
        } else if (array[mid2] == key) {
            return mid2;
        } else if (array[mid2] > key) {
            return threePointsSearch(key, mid1 + 1, mid2 - 1, array);
        } else {
            return threePointsSearch(key, mid2 + 1, high, array);
        }
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = {1, 3, 4, 8, 9, 10, 12, 15, 18, 19, 20, 25, 26, 29, 30};
//        int key = 26;
        int key = 4;
        System.out.println(search.threePointsSearch(key, 0, nums.length - 1, nums));

    }
}
