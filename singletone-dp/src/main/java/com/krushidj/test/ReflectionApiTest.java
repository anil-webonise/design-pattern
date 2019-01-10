package com.krushidj.test;

import com.krushidj.singletone.Singletone;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionApiTest {
    public static void main(String... args) {

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
         * 	at com.krushidj.test.ReflectionApiTest.main(ReflectionApiTest.java:52)
         * Caused by: java.lang.IllegalArgumentException: Can not created second obj
         * 	at com.krushidj.singletone.Singletone.<init>(Singletone.java:19)
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

        // get Singleton class object
       Singletone singletone = Singletone.getInstance();
        try {
            // create obj for Singletone by Accessing private Constructor of
            Class  clazz = Class.forName("com.krushidj.singletone.Singletone");
            // get All consturctors of the class
            Constructor[] cons = clazz.getDeclaredConstructors();
            // provide access to private constructor
            cons[0].setAccessible(true);
            Field f = (Singletone.class).getDeclaredField("isInstantiated");
            f.setAccessible(true);
            f.set(true, false);
            // creating obj using the Accessed constructor
            Singletone singletone1 = (Singletone) cons[0].newInstance(null);
            System.out.println("singletone hashCode:::" + singletone.hashCode());
            System.out.println("singletone1 hashCode:::" + singletone1.hashCode());
        } // try
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
