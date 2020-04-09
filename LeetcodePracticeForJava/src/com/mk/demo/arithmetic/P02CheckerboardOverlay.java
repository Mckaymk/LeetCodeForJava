package com.mk.demo.arithmetic;

/**
 * @author MengKai
 * @create 2020-04-06
 */
public class P02CheckerboardOverlay {


    public static void main(String[] args) {
        P02CheckerboardOverlay checkerboardOverlay = new P02CheckerboardOverlay();
        int n = 3;
        n = (int) Math.pow(2, n);
        int[][] arrays = new int[n][n];
        arrays[4][5] = 1;
        showArrays(arrays);
        checkerboardOverlay.paddingChessboard(0, 0, n, arrays);

        showArrays(arrays);

    }


    public void paddingChessboard(int row, int col, int length, int[][] array) {
        if (length == 1) {
            return;
        }
//查看每一步的变化
//        showArrays(array);
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int subLength = length / 2;
        for (int i = 0; i < subLength; i++) {
            for (int j = 0; j < subLength; j++) {
                //将二维数组平均分为四块，查找哪一块为1
                if (array[row + i][col + j] == 1) {
                    n1++;
                }
                if (array[row + subLength + i][col + j] == 1) {
                    n2++;
                }
                if (array[row + i][col + subLength + j] == 1) {
                    n3++;
                }
                if (array[row + subLength + i][col + subLength + j] == 1) {
                    n4++;
                }
            }
        }
        //在没有1的剩余三块的中心点处的其他三块设为1，相当与L
        if (n1 == 1) {
            array[row + subLength][col + subLength] = 1;
            array[row + subLength - 1][col + subLength] = 1;
            array[row + subLength][col + subLength - 1] = 1;
        }

        if (n2 == 1) {
            array[row + subLength][col + subLength] = 1;
            array[row + subLength - 1][col + subLength] = 1;
            array[row + subLength - 1][col + subLength - 1] = 1;
        }

        if (n3 == 1) {
            array[row + subLength][col + subLength] = 1;
            array[row + subLength - 1][col + subLength - 1] = 1;
            array[row + subLength][col + subLength - 1] = 1;
        }
        if (n4 == 1) {
            array[row + subLength - 1][col + subLength - 1] = 1;
            array[row + subLength - 1][col + subLength] = 1;
            array[row + subLength][col + subLength - 1] = 1;
        }
        //依次在划分为四块求解
        paddingChessboard(row, col, subLength, array);
        paddingChessboard(row, col + subLength, subLength, array);
        paddingChessboard(row + subLength, col, subLength, array);
        paddingChessboard(row + subLength, col + subLength, subLength, array);

    }

    public static void showArrays(int arrays[][]) {
        String tmpStr = "";
        for (int[] array : arrays) {
            for (int i : array) {
                tmpStr += i + " ";
            }
            tmpStr += "\n";
        }
        System.out.println(tmpStr);
    }

}
