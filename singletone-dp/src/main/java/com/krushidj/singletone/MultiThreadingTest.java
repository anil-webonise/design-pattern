package com.krushidj.singletone;

/**
 * This class implement Runnable Interface for gives feeling Multithreadeing.
 *
 * @author Anil D. Ingle
 * @date 07-Jan-2019
 */
public class MultiThreadingTest implements Runnable {
    // setting logic for Runnable interface method.
    public void run() {
        Singletone singletone = null;
        singletone = Singletone.getInstance();
        System.out.println("Current thread name::" + Thread.currentThread().getName());
        System.out.println("Singletone class object hashCode::" + singletone.hashCode());
    }//run()
}
