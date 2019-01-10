package com.krushidj.test;

import com.krushidj.singletone.Singletone;

/**
 * This Testing class for all test case.
 *
 * @author Anil D. Ingle
 * @date 10-Jan-2019
 */
public class Test {
    /**
     * here i'm implemeting jvm callback method for diff. test cases and there result print on console.
     *
     * @param args
     */
    public static void main(String... args) {

        /**
         * Simple way to creation obj using factory method.
         * Factory method gives Singletone class.
         *
         * result printed bellow.
         *
         * singletone hashcode:356573597
         * singletone1 hashcode:356573597
         * singletone==singletone1?::true
         *
         */

        //get Singletone class obj

        Singletone singletone = Singletone.getInstance();
        Singletone singletone1 = Singletone.getInstance();

        //display hashcodes
        System.out.println("singletone hashcode:" + singletone.hashCode());
        System.out.println("singletone1 hashcode:" + singletone1.hashCode());
        //compare references
        System.out.println("singletone==singletone1?::" + (singletone == singletone1));
    }
}
