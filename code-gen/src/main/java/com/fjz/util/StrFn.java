package com.fjz.util;

import org.beetl.core.Context;
import org.beetl.core.Function;

import com.jfinal.kit.StrKit;

public class StrFn implements Function{

	@Override
	public Object call(Object[] paras, Context ctx) {
		String method = (String)paras[0];
		String value=(String)paras[1];
		if("firstCharToUpper".equals(method)){
			value=StrKit.firstCharToUpperCase(value);
		}
		return value;
	}

}
