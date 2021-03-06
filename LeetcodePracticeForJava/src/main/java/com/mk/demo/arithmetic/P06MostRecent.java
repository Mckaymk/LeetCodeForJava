package com.mk.demo.arithmetic;

/**
 * @author MengKai
 * @create 2020-04-06
 */
public class P06MostRecent {

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
        //如果只有一个点，构不成对
        if (length <= 1) {
            return null;
        }
        //如果只有两个点了，直接返回
        if (length == 2) {
            return new MostRecentPoint(left, right);
        }
        //对半分，分别找左右两个部分的最近点对，然后和分界线的两个点进行比较
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
        P06MostRecent mostRecent = new P06MostRecent();
        //有序数组，如果无序，需要先排序
        int[] array = {1, 3, 6, 8, 9, 13, 18, 20, 26, 30, 39};
        System.out.println(mostRecent.getMostRecent(0, array.length - 1, array));
    }
}
