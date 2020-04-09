package com.mk.demo.arithmetic;

import java.util.Arrays;
import java.util.List;

/**
 * @author MengKai
 * @create 2020-04-06
 */
public class MostRecent {

    class MostRecentPoint {
        private int left;
        private int right;

        @Override
        public String toString() {
            return "MostRecentPoint{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }

        public MostRecentPoint(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getDistance(int[] array) {
            return (array[right] - array[left]);
        }


        public MostRecentPoint getMostDistance(int[] array, MostRecentPoint mostRecentPoint) {
            int res = mostRecentPoint.getDistance(array);
            if (getDistance(array) < res) {
                return this;
            } else {
                return mostRecentPoint;
            }
        }


    }

    public MostRecentPoint getMostRecent(int left, int right, int[] arrays) {
        int length = right - left + 1;
        if (length <= 1) {
            return null;
        }
        if (length == 2) {
            return new MostRecentPoint(left, right);
        }
        int mid = left + length / 2;
        MostRecentPoint leftRes = getMostRecent(left, mid, arrays);
        MostRecentPoint rightRes = getMostRecent(mid + 1, right, arrays);
        MostRecentPoint midRes = new MostRecentPoint(mid, mid + 1);
        if (leftRes != null && rightRes != null) {
            return midRes.getMostDistance(arrays, leftRes).getMostDistance(arrays, rightRes);
        } else if (leftRes != null) {
            return midRes.getMostDistance(arrays, leftRes);
        } else if (rightRes != null) {
            return midRes.getMostDistance(arrays, rightRes);
        } else {
            return midRes;
        }
    }

    public static void main(String[] args) {
        MostRecent mostRecent = new MostRecent();
        //有序数组，如果没有序，先排序
        int[] array = {1, 3, 6, 8, 9, 13, 18, 20, 26, 30, 39};
        System.out.println(mostRecent.getMostRecent(0, array.length - 1, array));
    }
}
