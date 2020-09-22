package com.mk.demo.baoxian;

import java.util.Scanner;

/**
 * @author Mckay
 * @create 2020-09-16
 * @description
 **/
public class KnapSack01 {
    public static int backpackProblem(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }

        int[] dp = new int[C + 1];

        for (int i = 0; i <= C; i++) {
            dp[i] = w[0] <= i ? v[0] : 0;
        }

        for (int i = 1; i < size; i++) {
            for (int j = C; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int n = in.nextInt();
        int[] price = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
            value[i] = in.nextInt();
        }

        System.out.println(backpackProblem(price, value, c));
    }
}