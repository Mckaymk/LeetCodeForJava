package com.mk.demo;

import javax.sound.midi.SoundbankResource;
import java.util.Collection;

/**
 * @author MengKai
 * @create 2020-03-11
 */
class A {
}

class B extends A {
}

class C extends B {
}

class D extends A {
}

public class Demo {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a instanceof A);
        System.out.println(a instanceof B);
        System.out.println(a instanceof C);
        System.out.println(a instanceof D);
    }
}
