package com.krushidj.singletone;

import com.krushidj.util.ServiceConsumerImpl;

/**
 * @author Anil D. Ingle
 * @date 07-Jan-2019
 */

public class Singletone extends ServiceConsumerImpl {
    private static volatile Singletone instance;
    private static boolean isInstantiated = false;

    /**
     * private constructor for class Singletone
     */
    private Singletone() {
        if (isInstantiated)
            throw new IllegalArgumentException("Can not created second obj");
        else
            isInstantiated = true;
    }

    /**
     * This factory method getting Singletone class Object.
     * This methos is static and synscronise to avoid multithreaded object and second level Object creation checking.
     *
     * @return Singletone
     */
    public final static Singletone getInstance() {
        if (instance == null) { //1st null Check
            synchronized (Singletone.class) {
                if (instance == null) {
                    instance = new Singletone();
                }//if
            }//synchronized
        }//if
        return instance;
    }// getInstance

    /**
     * This is Override method from Object class
     * if in case our Singletone class is inherited some other class and
     * other class is implemeted Clone() methos to prevent second obj
     * @Exception CloneNotSupportedException()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
    * This method is prevent when our class make Deserialization after convert into serialization
     * give the same means already created obj
     * @return  Singletone
     */
    public Object readResolve() {
        return instance;
    }
}
