package com.fjz.util;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2017/6/4.
 */
public class LambdaTest {
    public final static int size = 10000000;
    public final static List<Integer> integers = new ArrayList<Integer>(size);

    @BeforeClass
    public static void init() {
        for (int i = 0; i < size; i++) {
            integers.add(Randoms.getInt(0, size));
        }
    }

    @Test
    public void test() {
        long begin=System.currentTimeMillis();
        for (int i = 0; i <100 ; i++) {
            iteratorMaxInteger();
            System.out.println("iteratorMaxInteger:"+(System.currentTimeMillis()-begin));
            begin=System.currentTimeMillis();
            forEachLoopMaxInteger();
            System.out.println("forEachLoopMaxInteger:"+(System.currentTimeMillis()-begin));
            begin=System.currentTimeMillis();
            forMaxInteger();
            System.out.println("forMaxInteger:"+(System.currentTimeMillis()-begin));
            begin=System.currentTimeMillis();
            parallelStreamMaxInteger();
            System.out.println("parallelStreamMaxInteger:"+(System.currentTimeMillis()-begin));
            begin=System.currentTimeMillis();
            lambdaMaxInteger();
            System.out.println("lambdaMaxInteger:"+(System.currentTimeMillis()-begin));
            begin=System.currentTimeMillis();
        }
    }

    @Test
    public void test11() {
        iteratorMaxInteger();
    }

    public int iteratorMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (Iterator<Integer> it = integers.iterator(); it.hasNext(); ) {
            max = Integer.max(max, it.next());
        }
        return max;
    }

    public int forEachLoopMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (Integer n : integers) {
            max = Integer.max(max, n);
        }
        return max;
    }

    public int forMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Integer.max(max, integers.get(i));
        }
        return max;
    }

    public int parallelStreamMaxInteger() {
        Optional<Integer> max = integers.parallelStream().reduce(Integer::max);
        return max.get();
    }

    public int lambdaMaxInteger() {
        return integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }
}
