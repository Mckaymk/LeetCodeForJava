package com.mk.demo.arithmetic;

/**
 * @author MengKai
 * @create 2020-04-03
 */
public class FindIndexEqualNum {


    public static void main(String[] args) {
        FindIndexEqualNum findIndexEqualNum = new FindIndexEqualNum();
        int[] arrays1 = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 19, 20, 45, 96};
        int[] arrays2 = {-1, 0, 1, 3, 6, 7, 8, 9, 10, 11, 12, 18, 19, 18, 45, 96};
        System.out.println(findIndexEqualNum.binarySearch(0, arrays1.length - 1, arrays1));
//        System.out.println(findIndexEqualNum.binarySearch(0, arrays1.length - 1, arrays2));
    }

    public int binarySearch(int low, int high, int[] array) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return binarySearch(low, mid - 1, array);
        } else {
            return binarySearch(mid + 1, high, array);
        }
    }


}
