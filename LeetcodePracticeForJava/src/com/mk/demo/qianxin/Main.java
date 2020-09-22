package com.mk.demo.qianxin;

/**
 * @author MengKai
 * @create 2020-09-02
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] houses = {3, 2, 4};
        System.out.println(house(houses));
    }

    public static int house(int[] person) {
        int n = person.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        int total = 0;
        int left = 0;
        for (int i = 1; i < n; i++) {
            if (person[i] >= person[i - 1]) {
                left = i - 1;
                break;
            }
        }
        dp[left] = 1;
        int right = left + 1;
        left--;
        while (left >= 0) {
            if (person[left] > person[left + 1]) {
                dp[left] = dp[left + 1] + 1;
            }
            left--;
        }
        while (right < n) {
            if (person[right] > person[right - 1]) {
                dp[right] = dp[right - 1] + 1;
            } else if (person[right] <= person[right - 1]) {
                dp[right] = 1;
            }
            right++;
        }
        for (int i : dp) {
            total += i;
        }
        return total;
    }

    private static void test01() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0 || n > 36) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(2);
        } else {
            int one = 1;
            int two = 2;
            int res = 0;
            while (n > 2) {
                res = one + two;
                one = two;
                two = res;
                n--;
            }
            System.out.println(res);
        }
    }
}
