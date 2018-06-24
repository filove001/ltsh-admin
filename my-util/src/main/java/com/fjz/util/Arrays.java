package com.fjz.util;

/**
 * Created by fengjianzhong on 2017/12/29.
 */
public class Arrays {
    public static boolean contains(Object[] arr,Object objectToFind){
        if (arr != null) {
            for (Object o : arr) {
                if (o.equals(objectToFind)) {
                    return true;
                }
            }
        }
        return false;
    }
}
