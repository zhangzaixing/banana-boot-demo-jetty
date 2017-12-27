package com.bananaframework.boot.demo.api.component;

import java.util.HashMap;
import java.util.Map;

import com.appleframework.rop.security.AppSecretManager;

/**
 * 
 *SimpleAppSecretManager class
 *
 *@author zzx
 *@date 2017年12月26日 下午4:45:41
 */
public class SimpleAppSecretManager implements AppSecretManager {
	
	private static Map<String, String> appKeySecretMap = new HashMap<String, String>();

	static{
		//自动
	    appKeySecretMap.put("100001", "a4160d00-b083-40f9-a749-07aef8781d52");
	}
	
	@Override
	public String getSecret(String appKey) {
		System.out.println("use SimpleAppSecretManager!");
		return appKeySecretMap.get(appKey);
	}

	@Override
	public boolean isValidAppKey(String appKey) {
		return getSecret(appKey) != null;
	}

}
