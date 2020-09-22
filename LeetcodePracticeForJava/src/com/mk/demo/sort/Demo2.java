package com.mk.demo.sort;

import javafx.util.Builder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author MengKai
 * @create 2020-07-31
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] nums = {8, 4, 5, 6, 3, 2, 1, 7};
        quick(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }


    public static void quick(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int start = left;
        int end = right;
        int tmp = nums[left];
        while (left < right) {
            while (nums[right] > tmp && left < right) {
                right--;
            }
            if (nums[right] < tmp) {
                nums[left++] = nums[right];
            }
            while (nums[left] < tmp && left < right) {
                left++;
            }
            if (nums[left] > tmp) {
                nums[right--] = nums[left];
            }
        }
        nums[left] = tmp;
        quick(nums, start, left - 1);
        quick(nums, left + 1, end);

    }
}