package com.fjz.util;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author fengjianzhong for jfinal
 *
 */
@SuppressWarnings("serial")
public class Kv extends HashMap {


    public Kv() {
    }

    public static Kv by(Object key, Object value) {
        return (new Kv()).set(key, value);
    }

    public static Kv create(Object key, Object value) {
        return (new Kv()).set(key, value);
    }

    public static Kv create() {
        return new Kv();
    }


    public Kv set(Object key, Object value) {
        super.put(key, value);
        return this;
    }

    public Kv set(Map map) {
        super.putAll(map);
        return this;
    }

    public Kv set(Kv ret) {
        super.putAll(ret);
        return this;
    }

    public Kv delete(Object key) {
        super.remove(key);
        return this;
    }

    public <T> T getAs(Object key) {
        return (T)this.get(key);
    }

    public String getStr(Object key) {
        Object s = this.get(key);
        return s != null ? s.toString() : null;
    }

    public Integer getInt(Object key) {
        Number n = (Number)this.get(key);
        return n != null ? n.intValue() : null;
    }

    public Long getLong(Object key) {
        Number n = (Number)this.get(key);
        return n != null ? n.longValue() : null;
    }

    public Number getNumber(Object key) {
        return (Number)this.get(key);
    }

    public Boolean getBoolean(Object key) {
        return (Boolean)this.get(key);
    }

    public boolean notNull(Object key) {
        return this.get(key) != null;
    }

    public boolean isNull(Object key) {
        return this.get(key) == null;
    }


    public String toJson() {
        return JSON.toJSONString(this);
    }
    @Override
    public boolean equals(Object ret) {
        return ret instanceof Kv && super.equals(ret);
    }
}
