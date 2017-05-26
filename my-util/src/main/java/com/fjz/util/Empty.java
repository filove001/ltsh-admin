package com.fjz.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by fengjianzhong on 2014/6/8.
 */
@SuppressWarnings("rawtypes")
public class Empty {
	public static boolean is(Object o) {
        if (o == null) {
            return true;
        }else if(o instanceof String) {
            return is((String) o);
        }else if(o.getClass().isArray()) {
            return Array.getLength(o) == 0;
        }else if(o instanceof Collection) {
            return is((Collection) o);
        }else if(o instanceof Map) {
            return is((Map) o);
        }else if(o instanceof Iterator) {
            return is((Iterator) o);
        }
        return false;
    }
    public static boolean is(String s) {
        return s == null || s.isEmpty();
    }
    public static boolean is(Collection c) {
        return c == null || c.isEmpty();
    }
    public static boolean is(Map o) {
        return o == null || o.isEmpty();
    }
    public static boolean is(Iterator<?> o) {
        return o == null || !o.hasNext();
    }
    public static<T> boolean is(T[] o) {
        return o == null || o.length == 0;
    }
    public static boolean is(boolean[] o) {
        return o == null || o.length == 0;
    }
    public static boolean is(byte[] o) {
        return o == null || o.length == 0;
    }
    public static boolean is(short[] o) {
        return o == null || o.length == 0;
    }
    public static boolean is(char[] o) {
        return o == null || o.length == 0;
    }
    public static boolean is(long[] o) {
        return o == null || o.length == 0;
    }
    public static boolean is(int[] o) {
        return o == null || o.length == 0;
    }
    public static boolean is(float[] o) {
        return o == null || o.length == 0;
    }
    public static boolean is(double[] o) {
        return o == null || o.length == 0;
    }
    
    public static boolean not(Object o) {
    	 return !is(o);
    }
    public static boolean not(String s) {
        return !is(s);
    }
    public static boolean not(Collection c) {
    	return !is(c);
    }
    public static boolean not(Map o) {
    	return !is(o);
    }
    public static boolean not(Iterator<?> o) {
    	return !is(o);
    }
    public static<T> boolean not(T[] o) {
    	return !is(o);
    }
    public static boolean not(boolean[] o) {
    	return !is(o);
    }
    public static boolean not(byte[] o) {
    	return !is(o);
    }
    public static boolean not(short[] o) {
    	return !is(o);
    }
    public static boolean not(char[] o) {
    	return !is(o);
    }
    public static boolean not(long[] o) {
    	return !is(o);
    }
    public static boolean not(int[] o) {
    	return !is(o);
    }
    public static boolean not(float[] o) {
    	return !is(o);
    }
    public static boolean not(double[] o) {
    	return !is(o);
    }
    
    public static void main(String[] args) {
//        List list=Lists.newArrayList(1,2,3,4,5,6,7);
//        System.out.println("======================================fori");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("======================================foreach");
//        for (Object o : list) {
//            System.out.println(o);
//        }
//        Object o2 = Lists.newArrayList(123, "");
//        Object o = null;
//        String s = null;
//        String s1 = "";
//        System.out.println("1    "+Empty.is(o));
//        System.out.println("2    "+Empty.is(s));
//        System.out.println("3    "+Empty.is(s1));
//        System.out.println("4    "+Empty.is(new Empty()));
//        System.out.println("5    "+Empty.is(new int[]{}));
//        System.out.println("6    "+Empty.is(new long[]{}));
//        System.out.println("7    "+Empty.is(Maps.newHashMap()));
//        System.out.println("8    "+Empty.is(new int[]{1}));
//        System.out.println("9    "+Empty.is(new String[]{"123"}));
//        System.out.println("10   "+Empty.is(Lists.newArrayList("", "")));
//        System.out.println("11   "+Empty.is(o2));
//        Object o12 = new double[]{12};
//        System.out.println("12   "+Empty.is(o12));
//        Object o13 = new double[]{};
//        System.out.println("13   "+Empty.is(o13));
    }
}
