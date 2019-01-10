package com.krushidj.test;

import com.krushidj.singletone.Singletone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * This Testing class for all test case.
 *
 * @author Anil D. Ingle
 * @date 10-Jan-2019
 */
public class ClonningTest {
    public static void main(String... args) {

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


        //get Singleton class obj
        Singletone singletone = Singletone.getInstance();
        try {
            //perform Serialization
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Singletone.ser"));
            oos.writeObject(singletone);
            oos.flush();
            oos.close();
            System.out.println("Serailization is completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Perform DeSerialization
        try {
            ObjectInputStream  ois = new ObjectInputStream(new FileInputStream("Singletone.ser"));
            Singletone  singletone1 = (Singletone) ois.readObject();
            ois.close();
            System.out.println("Deserilization is completed");
            System.out.println("singletone hashCode:" + singletone.hashCode());
            System.out.println("singletone1 hashCode:" + singletone1.hashCode());
        }//try
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

