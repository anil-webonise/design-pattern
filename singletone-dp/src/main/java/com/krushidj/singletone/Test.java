package com.krushidj.singletone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * This Testing class for all test case.
 *
 * @author Anil D. Ingle
 * @date 07-Jan-2019
 */
public class Test {
    /**
     * here i'm implemeting jvm callback method for diff. test cases and there result print on console.
     * @param args
     */
    public static void main(String... args) {
        // declare two instance of Singletone
        Singletone singletone = null;
        Singletone singletone1 = null;

        /**
         * Simple way to creation obj using factory method.
         * Factory method gives Singletone class.
         *
         * result printed bellow.
         *
         * singletone hashCode:::1627674070
         * singletone1 hashCode:::1360875712
         *
         */

        //get Singletone class obj
//
//        singletone = Singletone.getInstance();
//        singletone1 = Singletone.getInstance();
//
//        //display hashcodes
//        System.out.println("singletone hashcode:" + singletone.hashCode());
//        System.out.println("singletone1 hashcode:" + singletone1.hashCode());
//        //compare references
//        System.out.println("singletone==singletone1?::" + (singletone == singletone1));

        /**
         * Test case 1 perform clonning and checking thier result
         *  perfect tested i got bellow  Exception means code work fine.
         *
         *  java.lang.CloneNotSupportedException
         * 	at com.krushidj.singletone.Singletone.clone(Singletone.java:47)
         * 	at com.krushidj.singletone.Test.main(Test.java:38)
         */

         // **********************start test case1 ****************************

//       try {
//            singletone = Singletone.getInstance();
//            //perform cloning
//            singletone1 = (Singletone) singletone.clone();
//            System.out.println("singletone obj hashCode::" + singletone.hashCode());
//            System.out.println("singletone1 obj hashCode::" + singletone1.hashCode());
//        }//try
//        catch (CloneNotSupportedException cnse) {
//            cnse.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

         // **********************end test case1 ****************************

        /**
         * Test case 2 perform perform Serialization and DeSerialization
         * and checking their hashcode if singletone hashCode==singletone1 hashCode
         * we are getting same ojb refrence it means not creating another objeect
         * means Perfectle work our code
         * result printed bellow.
         *
         * Serailization is completed
         * Deserilization is completed
         * singletone hashCode:1581781576
         * singletone1 hashCode:1581781576
         *
         */

        // **********************start test case2 ****************************

//        ObjectOutputStream oos = null;
//        ObjectInputStream ois = null;
//        //get Singleton class obj
//        singletone = Singletone.getInstance();
//        try {
//            //perform Serialization
//            oos = new ObjectOutputStream(new FileOutputStream("Singletone.ser"));
//            oos.writeObject(singletone);
//            oos.flush();
//            oos.close();
//            System.out.println("Serailization is completed");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //Perform DeSerialization
//        try {
//            ois = new ObjectInputStream(new FileInputStream("Singletone.ser"));
//            singletone1 = (Singletone) ois.readObject();
//            ois.close();
//            System.out.println("Deserilization is completed");
//            System.out.println("singletone hashCode:" + singletone.hashCode());
//            System.out.println("singletone1 hashCode:" + singletone1.hashCode());
//        }//try
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        // **********************end test case2 ****************************

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
//
//        MultiThreadingTest multiThreadingTest = new MultiThreadingTest();
//        //creating Thread class obj
//        Thread req1 = new Thread(multiThreadingTest);
//        Thread req2 = new Thread(multiThreadingTest);
//        //start threads
//        req1.start();
//        req2.start();
        // **********************end test case3 ****************************

        /**
         * Test case 4 Using Reflection api
         * We access private contructor and creating obj
         * Here two output i'm Showing for you
         * 1. If line number 166, 167 and 168 comment it gives expected output means we throwing exception
         * that is.
         * java.lang.reflect.InvocationTargetException
         * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
         * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
         * 	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
         * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
         * 	at com.krushidj.singletone.Test.main(Test.java:171)
         * Caused by: java.lang.IllegalArgumentException: Can not created second obj <--- show this.
         * 	at com.krushidj.singletone.Singletone.<init>(Singletone.java:17)
         * 	... 5 more
         *
         * 	And another is hacking it means we can change private class level  varible value and thats our
         * 	Single tone behaviour Break and it's sad for me Reflection api kills oop class private varible rules and
         * 	thats why here break condition and our Sigletone class gives two different instance only when
         * 	line number 166,167 and 168 uncomment and shows below output...
         *
         * result printed bellow.
         *
         * singletone hashCode:::1627674070
         * singletone1 hashCode:::1360875712
         *
         */
        // **********************start test case4 ****************************
        Class clazz = null;
        Constructor[] cons = null;
        // get Singleton class object
        singletone = Singletone.getInstance();
        try {
            // create obj for Singletone by Accessing private Constructor of
            clazz = Class.forName("com.krushidj.singletone.Singletone");
            // get All consturctors of the class
            cons = clazz.getDeclaredConstructors();
            // provide access to private constructor
            cons[0].setAccessible(true);
            Field f = (Singletone.class).getDeclaredField("isInstantiated");
            f.setAccessible(true);
            f.set(true, false);
            // creating obj using the Accessed constructor
            singletone1 = (Singletone) cons[0].newInstance(null);
            System.out.println("singletone hashCode:::" + singletone.hashCode());
            System.out.println("singletone1 hashCode:::" + singletone1.hashCode());
        } // try
        catch (Exception e) {
            e.printStackTrace();
        }

    }//main
}
