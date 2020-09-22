package com.mk.demo;


class MyThread extends Thread {
    @Override
    public void run() {

        System.out.println("aaaa");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        myThread.run();
    }
}
