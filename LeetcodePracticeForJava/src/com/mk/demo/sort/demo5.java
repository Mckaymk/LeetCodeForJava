package com.mk.demo.sort;

/**
 * @author Mckay
 * @create 2020-10-01
 * @description
 **/
public class demo5 {
    public static void main(String[] args) {
        int m = 11;
        int sum = 0;
        for (int i = 1; i <= m; i += 2) {
            sum += i;
        }
        for (int i = 2; i <= m; i += 2) {
            sum -= i;
        }
        System.out.println(sum);
        if (m % 2 == 1) {
            System.out.println(m / 2 * -1 + m);
        } else {
            System.out.println(m / 2 * -1);
        }
    }


}
