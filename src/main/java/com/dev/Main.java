package com.dev;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.setCounter(0);
        MyThread myThread = new MyThread(counter);
        MyRunnable myRunnable = new MyRunnable(counter);
        myThread.start();
        new Thread(myRunnable).start();
    }
}