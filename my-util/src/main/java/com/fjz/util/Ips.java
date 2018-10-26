package com.fjz.util;

import com.fjz.util.log.Logs;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 
 * @author fjz
 *
 */
public class Ips {

	/**
	 * 获取本机ip地址，并自动区分Windows还是linux操作系统
	 * @return String
	 */
	public static String getLocalIP(){
		String sIP = "";
		InetAddress ip = null;
		try {
			//如果是Windows操作系统
			if(Systems.isWin){
				ip = InetAddress.getLocalHost();
			}
			//如果是Linux操作系统
			else{
				boolean bFindIP = false;
				Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
						.getNetworkInterfaces();
				while (netInterfaces.hasMoreElements()) {
					if(bFindIP){
						break;
					}
					NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
					//----------特定情况，可以考虑用ni.getName判断
					//遍历所有ip
					Enumeration<InetAddress> ips = ni.getInetAddresses();
					while (ips.hasMoreElements()) {
						ip = (InetAddress) ips.nextElement();
						if( ip.isSiteLocalAddress()
								&& !ip.isLoopbackAddress()   //127.开头的都是lookback地址
								&& ip.getHostAddress().indexOf(":")==-1){
							bFindIP = true;
							break;
						}
					}

				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		if(null != ip){
			sIP = ip.getHostAddress();
		}
		return sIP;
	}
	/**
	 * MethodsTitle: 获取本机的IP
	 * @author: xg.chen
	 * @date:2016年11月14日 下午5:03:41
	 * @version 1.0
	 */
	public static void getLoalhostIP(){
		try {
			Enumeration<?> enumeration= NetworkInterface.getNetworkInterfaces();
			InetAddress ip=null;
			while(enumeration.hasMoreElements()){
				NetworkInterface netInterface = (NetworkInterface) enumeration.nextElement();
				Enumeration<?> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					System.out.println("服务地址:" + ip.getHostName());
					if (ip != null && ip instanceof Inet4Address){
						String ip1=ip.getHostAddress();
						System.out.println("本机所有的IP地址:"+ip1);
					}
				}
			}
		} catch (SocketException e) {
			Logs.error(e);
		}
	}
	public static String getIp(HttpServletRequest request){
		return getRemoteAddr(request);
	}
	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request){
		String remoteAddr = request.getHeader("X-Real-IP");
        if (Empty.not(remoteAddr)) {
        	remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (Empty.not(remoteAddr)) {
        	remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (Empty.not(remoteAddr)) {
        	remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}
}
