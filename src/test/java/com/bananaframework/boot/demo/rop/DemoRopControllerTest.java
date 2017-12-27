package com.bananaframework.boot.demo.rop;



import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.appleframework.rop.utils.RopUtils;

public class DemoRopControllerTest {
	public static final String SEVER_URL = "http://192.168.1.54:8080/router";
	public static final String APP_KEY = "100001";
	public static final String APP_SECRET = "a4160d00-b083-40f9-a749-07aef8781d52";
	
	@Test
	public void testRop(){
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>(); 
		
		//系统级参数
		form.add("method", "zzx.banana.user.list");
		form.add("appkey", APP_KEY);
		form.add("v", "1.0");
		form.add("format", "json");
		form.add("locale", "zh_CN");
		
		String sign = RopUtils.sign(form.toSingleValueMap(), APP_SECRET);
		form.add("sign", sign);
		String response  = restTemplate.postForObject(SEVER_URL, form, String.class);
		System.out.println("response:\n" + response);
	}
}
