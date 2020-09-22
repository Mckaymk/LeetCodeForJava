package com.mk.demo.sort;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;

/**
 * @author MengKai
 * @create 2020-07-18
 */
public class Demo {
    public static int len = 0;

    public static void main(String[] args) {
//        int[] nums = {5, 1, 4, 9, 6, 2, 3, 8, 7};
        int[] nums = {5, 1, 4, 9, 6, 2, 3, 8, 7};
//        bubble(nums);
//        selection(nums);
//        insertion(nums);
//        shell(nums);
//        mergeSort(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
//        quick(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] array) {
        len = array.length;
        System.out.println(Arrays.toString(array));
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
//            System.out.println(Arrays.toString(array));
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
    }

    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        //for循环这样写会更好一点：i的左子树和右子树分别2i+1和2(i+1)
        for (int i = (len / 2 - 1); i >= 0; i--) {
            adjustHeap(array, i);
            System.out.println(Arrays.toString(array));
        }
    }

    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点 ，则将最大指针指向左子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 2 < len && array[i * 2 + 2] > array[maxIndex]) {
            maxIndex = i * 2 + 2;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, right, mid + 1);
        System.out.println(Arrays.toString(array));
    }

    private static void merge(int[] array, int left, int right, int mid) {
        int[] tmp = new int[right - left + 1];
        int i = 0;
        int n = mid;
        while (left < mid && mid <= right) {
            if (array[left] < array[mid]) {
                tmp[i++] = array[left++];
            } else {
                tmp[i++] = array[mid++];
            }
        }
        while (left < n) {
            tmp[i++] = array[left++];
        }
        while (mid <= right) {
            tmp[i++] = array[mid++];
        }
        System.arraycopy(tmp, 0, array, right - tmp.length + 1, tmp.length);
    }

    public static void shell(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        System.out.println(Arrays.toString(array));
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
        System.out.println(Arrays.toString(nums));
    }

    public static void bubble(int[] nums) {
        int m = nums.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
            System.out.println(Arrays.toString(nums));

        }
    }

    public static void selection(int[] nums) {
        int m = nums.length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i; j < m; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void insertion(int[] nums) {
        int m = nums.length;
        for (int i = 1; i < m; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }


}
