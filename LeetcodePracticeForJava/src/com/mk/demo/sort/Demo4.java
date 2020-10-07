package com.mk.demo.sort;

import java.util.Arrays;

/**
 * @author Mckay
 * @create 2020-09-30
 * @description
 **/
public class Demo4 {
    public static void main(String[] args) {
        int[] nums1 = {8, 4, 5, 6, 3, 2, 1, 7};
        quick(nums1, 0, nums1.length - 1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {8, 4, 5, 6, 3, 2, 1, 7};
        mergeSort(nums2, 0, nums2.length - 1);
        System.out.println(Arrays.toString(nums2));
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid + 1);
    }

    private static void merge(int[] nums, int left, int right, int mid) {
        int i = 0;
        int n = mid;
        int[] tmp = new int[right - left + 1];
        while (left < n && mid <= right) {
            if (nums[left] <= nums[mid]) {
                tmp[i++] = nums[left++];
            } else {
                tmp[i++] = nums[mid++];
            }
        }
        while (left < n) {
            tmp[i++] = nums[left++];
        }
        while (mid <= right) {
            tmp[i++] = nums[mid++];
        }
        System.arraycopy(tmp, 0, nums, right - tmp.length + 1, tmp.length);
    }

    private static void quick(int[] nums, int left, int right) {
        if (left >= right){
            return;
        }
        int start = left;
        int end = right;
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > tmp) {
                right--;
            }
            if (nums[right] < tmp) {
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] < tmp) {
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
