package com.fjz.util;

import com.fjz.util.log.Logs;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * 
 * @author fjz
 *
 */
public class IpsTest {
	@Test
	public void getLoalhostIP() {
//		Ips.getLoalhostIP();
		System.out.println(Ips.getLocalIP());
	}
}
