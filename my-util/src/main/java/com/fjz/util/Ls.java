package com.fjz.util;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * List封装
 * Created by Administrator on 2018/6/24.
 */
@SuppressWarnings("serial")
public class Ls<T> extends ArrayList<T>{
    public static <T>Ls<T> create(){
        return new Ls<>();
    }
    public static <T>Ls<T> create(T... t){
        return by(t);
    }
    @SafeVarargs
    public static <T>Ls<T> by(T... t){
        if(t==null){
            return null;
        }
        Ls<T> list=new Ls<>();
        Collections.addAll(list, t);
        return list;
    }
    public Ls<T> put(T object) {
        this.add(object);
        return this;
    }
    public Ls<T> put(List list) {
        this.addAll(list);
        return this;
    }
    public Ls<T> delete(int index) {
        this.remove(index);
        return this;
    }
    public Ls<T> delete(Object o) {
        this.remove(o);
        return this;
    }
    public Ls<T> deleteAll(Collection<?> c) {
        this.removeAll(c);
        return this;
    }
    public String toJson() {
        return JSON.toJSONString(this);
    }
    public static void main(String[] args) {
        for (Object serializable : Ls.by("123", 123,new Object())) {
            System.out.println(serializable.getClass());
        }
        System.out.println(Ls.by("123", 123).put(Ls.by("222")));
    }
}
