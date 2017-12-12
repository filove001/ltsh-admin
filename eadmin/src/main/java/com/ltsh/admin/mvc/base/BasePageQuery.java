package com.ltsh.admin.mvc.base;

import com.ltsh.admin.util.Beans;
import org.beetl.sql.core.engine.PageQuery;

/**
 * Created by fengjianzhong on 2017/12/4.
 */
public class BasePageQuery<T> extends PageQuery<T> {
    private String msg="";//
    private String code="-1";//成功的状态码，默认：0 数据总数的字段

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public static <T>BasePageQuery<T> setSuccess(PageQuery<T> query){
        BasePageQuery query1=new BasePageQuery();
        Beans.copyProperties(query,query1);
        query1.setCode("0");
        return query1;
    }
}
