package com.fjz.gen.insert.rolemenu.model;



/**
 * 
 * @author fengjianzhong
 *
 */
public class SysTenantAutoIds {
	public static String  getId(SysTenant sysTenant){
		//租户类型简拼+应用类型 +用户id+用户自己的租户个数
		return sysTenant.getTypeShort()+"_"+sysTenant.getAppType()+"_"+sysTenant.getSysUserId()+"_"+1;
	}
}