package com.mk.demo.designPatterns.test;

/**
 * @author Mckay
 * @create 2020-10-02
 * @description
 **/
public class Dog implements Animal {
    public String name = "aaa";
    public int age = 12;

    @Override
    public void run() {
        System.out.println("跑得快");
    }

    @Override
    public void eat() {
        System.out.println("吃得多");
    }

    @Override
    public void baking() {
        System.out.println("叫的欢");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
