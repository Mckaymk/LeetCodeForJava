package com.mk.demo.arithmetic;

/**
 * @author MengKai
 * @create 2020-03-11
 */
public class NutMatch {
    public static void main(String[] args) {
        NutMatch demo = new NutMatch();
        int[] nut = {6, 9, 3, 7, 1, 8, 2, 5, 4};
//        int[] nut = {5, 9, 3, 7, 1, 8, 2, 6, 4};
//        int[] bolt = {7, 4, 5, 9, 2, 6, 8, 1, 3};
        int[] bolt = {7, 8, 5, 9, 2, 6, 4, 1, 3};
        demo.quickSearch(nut, bolt, 0, nut.length - 1);
        demo.showArray(nut);
        demo.showArray(bolt);
    }

    public void quickSearch(int[] nut, int[] bolt, int left, int right) {
        if (left < right) {
            int tmp = nut[left];
            int i = left;
            int j = right;
            int tmpNum = 0;
            while (i < j) {
                while (i < j && bolt[i] < tmp) {
                    i++;
                }
                while (i < j && bolt[j] > tmp) {
                    j--;
                }
                if (i < j) {
                    tmpNum = bolt[i];
                    bolt[i] = bolt[j];
                    bolt[j] = tmpNum;
                }
            }

            tmpNum = bolt[left];
            bolt[left] = bolt[i];
            bolt[i] = tmpNum;

            tmp = bolt[left];
            i = left;
            j = right;
            while (i < j) {
                while (i < j && nut[i] < tmp) {
                    i++;
                }
                while (i < j && nut[j] > tmp) {
                    j--;
                }
                if (i < j) {
                    tmpNum = nut[i];
                    nut[i] = nut[j];
                    nut[j] = tmpNum;
                }
            }

            tmpNum = nut[left];
            nut[left] = nut[i];
            nut[i] = tmpNum;

            showArray(nut);
            showArray(bolt);
            System.out.println("-------");
            quickSearch(nut, bolt, left + 1, i);
            quickSearch(nut, bolt, i + 1, right);
        }

    }

    public void showArray(int[] array) {
        String nums = "";
        for (int b : array) {
            nums += b + " ";
        }
        System.out.println(nums);
    }


}
