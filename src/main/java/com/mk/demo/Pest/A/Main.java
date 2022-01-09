package com.mk.demo.Pest.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mckay
 * @create 2020-09-20
 * @description
 **/
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int x = 0, y = 0, total = Integer.MAX_VALUE;
        int[][] people = new int[N][2];
        int[][] station = new int[M][2];
        for (int i = 0; i < N; i++) {
            people[i][0] = in.nextInt();
            people[i][1] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int p = in.nextInt();
            int q = in.nextInt();
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += Math.abs(people[j][0] - p) + Math.abs(people[j][1] - q);
            }
            if (sum < total) {
                total = sum;
                x = p;
                y = q;
            }
        }
        System.out.println(x + " " + y);

    }
}
