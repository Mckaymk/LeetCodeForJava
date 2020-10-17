package com.mk.demo.arithmetic;

/**
 * @author MengKai
 * @create 2020-04-03
 */
public class P03FindIndexEqualNum {


    public static void main(String[] args) {
        P03FindIndexEqualNum findIndexEqualNum = new P03FindIndexEqualNum();
        int[] arrays1 = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 19, 20, 45, 96};
        int[] arrays2 = {-1, 0, 1, 3, 6, 7, 8, 9, 10, 11, 12, 18, 19, 18, 45, 96};
        //利用二分查找思路
        System.out.println(findIndexEqualNum.binarySearch(0, arrays1.length - 1, arrays1));
//        System.out.println(findIndexEqualNum.binarySearch(0, arrays1.length - 1, arrays2));
    }

    public int binarySearch(int low, int high, int[] array) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        //相等直接返回
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            //如果值比索引大，只能在左边
            return binarySearch(low, mid - 1, array);
        } else {
            //如果索引比值大，只能在右边
            return binarySearch(mid + 1, high, array);
        }
    }


}
