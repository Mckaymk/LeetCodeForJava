package com.mk.demo.designPatterns.singletonPattern;

/**
 * @author Mckay
 * @create 2020-10-02
 * @description
 **/
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance1() {
        return SingletonInstance.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance1();
    }
}
