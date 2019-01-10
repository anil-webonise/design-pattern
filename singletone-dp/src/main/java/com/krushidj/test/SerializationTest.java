package com.krushidj.test;

import com.krushidj.singletone.Singletone;
/**
 * This Testing class for all test case.
 *
 * @author Anil D. Ingle
 * @date 10-Jan-2019
 */
public class SerializationTest {
    public static void main(String... args) {
        /**
         * Test case 1 perform clonning and checking thier result
         *  perfect tested i got bellow  Exception means code work fine.
         *
         *  java.lang.CloneNotSupportedException
         * 	at com.krushidj.singletone.Singletone.clone(Singletone.java:49)
         * 	at com.krushidj.test.SerializationTest.main(SerializationTest.java:26)
         */

        // **********************start test case1 ****************************

        try {
            Singletone singletone = Singletone.getInstance();
            //perform cloning
            Singletone singletone1 = (Singletone) singletone.clone();
            System.out.println("singletone obj hashCode::" + singletone.hashCode());
            System.out.println("singletone1 obj hashCode::" + singletone1.hashCode());
        }//try
        catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
