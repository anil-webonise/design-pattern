package com.krushidj.util;

import java.io.Serializable;
/**
 * This class implement Cloneable and  Serializable Interface for gives feeling Clonning and Serialization.
 *
 * @author Anil D. Ingle
 * @date 07-Jan-2019
 */
public class ServiceConsumerImpl implements Cloneable , Serializable {

    private static final long serialVersionUID=2L;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
