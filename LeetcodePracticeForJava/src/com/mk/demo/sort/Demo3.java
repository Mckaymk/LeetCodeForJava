package com.mk.demo.sort;

import java.util.Scanner;

/**
 * @author MengKai
 * @create 2020-07-31
 */
public class Demo3 {
    public static void main(String[] args) {
        //逆向
        int flag = 0;
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        int zx = Math.abs(x1 + x2 - x3 - x4);
        int x = Math.abs(x1 - x2) + Math.abs(x3 - x4);
        int zy = Math.abs(y1 + y2 - y3 - y4);
        int y = Math.abs(y1 - y2) + Math.abs(y3 - y4);
        if (zx <= x && zy <= y) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
