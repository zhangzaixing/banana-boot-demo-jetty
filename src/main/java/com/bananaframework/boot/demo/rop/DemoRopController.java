package com.bananaframework.boot.demo.rop;

import java.util.List;

import javax.annotation.Resource;

import org.biz.banana.bean.User;
import org.biz.banana.service.UserService;

import com.appleframework.jms.kafka.producer.KafkaMessageProducer2;
import com.appleframework.rop.AbstractRopRequest;
import com.appleframework.rop.annotation.NeedInSessionType;
import com.appleframework.rop.annotation.ServiceMethod;
import com.appleframework.rop.annotation.ServiceMethodBean;
import com.appleframework.web.springmvc.controller.BaseController;
import com.bananaframework.boot.demo.response.UserListResponse;

/**
 * 
 *DemoController class
 *
 *@author zzx
 *@date 2017年12月26日 上午10:09:56
 */
@ServiceMethodBean(version="1.0")
public class DemoRopController extends BaseController {
	
	@Resource
	private KafkaMessageProducer2 kafkaMessageProducer2;
	
	@Resource
	private UserService userService;

	@ServiceMethod(method="zzx.banana.user.list",needInSession = NeedInSessionType.NO, title="获得用户列表")
	public Object list(AbstractRopRequest request) {		
		UserListResponse<List<User>> response = new UserListResponse<List<User>>();
		List<User> list = userService.findList();
		response.setData(list);
		return response;
	}
}
