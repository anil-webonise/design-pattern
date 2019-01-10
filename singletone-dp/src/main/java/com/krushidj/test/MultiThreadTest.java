package com.krushidj.test;

import com.krushidj.util.ThreadEnv;

/**
 * This Testing class for all test case.
 *
 * @author Anil D. Ingle
 * @date 10-Jan-2019
 */
public class MultiThreadTest {
    public static void main(String... args) {

        /**
         * Test case 3 perform multiyhreadded environment .
         *
         * result printed bellow.
         *
         * Current thread name::Thread-0
         * Singletone class object hashCode::611292978
         * Current thread name::Thread-1
         * Singletone class object hashCode::611292978
         *
         */

        // **********************start test case3 ****************************

        ThreadEnv multiThreadingTest = new ThreadEnv();
        //creating Thread class obj
        Thread req1 = new Thread(multiThreadingTest);
        Thread req2 = new Thread(multiThreadingTest);
        //start threads
        req1.start();
        req2.start();
    }
}
