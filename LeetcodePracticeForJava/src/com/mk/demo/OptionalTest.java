package com.mk.demo;

import java.util.Optional;

/**
 * @author Mckay
 * @create 2019-12-10
 * @description
 **/
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println("dd");
        System.out.println(optional.isPresent());

    }

    public static boolean compare(int a, int b) {
        return a > b;
    }

    public static boolean compare(float a, float b) {
        return a > b;
    }
}
