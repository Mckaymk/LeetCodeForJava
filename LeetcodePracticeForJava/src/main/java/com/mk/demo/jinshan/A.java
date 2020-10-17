package com.mk.demo.jinshan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mckay
 * @create 2020-09-16
 * @description
 **/
public  class A implements Dog {

    public final int a = 10;
    public final void foo(){
        System.out.println("aaa");
    }

    @Override
    public int getmax() {
        return 0;
    }

    public static void call(List<? extends RuntimeException> list){

    }

    public static void main(String[] args) {
        A a = new A();
        List<RuntimeException> list = new ArrayList<>();
        List<Exception> list1 = new ArrayList<>();


    }
}
