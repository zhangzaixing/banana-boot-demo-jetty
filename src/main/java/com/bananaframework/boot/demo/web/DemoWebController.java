package com.bananaframework.boot.demo.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.biz.banana.bean.User;
import org.biz.banana.provider.util.Constant;
import org.biz.banana.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.appleframework.jms.kafka.producer.KafkaMessageProducer2;
import com.appleframework.model.DefaultDto;
import com.appleframework.web.springmvc.controller.BaseController;

/**
 * 
 *DemoController class
 *
 *@author zzx
 *@date 2017年12月26日 上午10:09:56
 */
@Controller
@RequestMapping("/demo")
public class DemoWebController extends BaseController {
	
	@Resource
	private KafkaMessageProducer2 kafkaMessageProducer2;
	
	private String viewModel = "demo/";
	
	@Resource
	private UserService userService;

	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,
			HttpServletResponse response) {		
		List<User> list = userService.findList();
		model.addAttribute("list", list);
		return viewModel + "list";
	}
	
	@RequestMapping(value = "/kafka")
	@ResponseBody
	public void kafka(Model model, HttpServletRequest request,
			HttpServletResponse response) {		
		for (int i = 1; i <= 10000; i++) {
			kafkaMessageProducer2.sendObject(Constant.TOPIC_DEMO2, new User(i, "zzx-demo-" + i, i));
		}
	}
	
	@RequestMapping(value = "/kafkaDto")
	@ResponseBody
	public void kafkaDto(Model model, HttpServletRequest request,
			HttpServletResponse response) {		
		for (int i = 1; i <= 10000; i++) {
			DefaultDto dto = DefaultDto.create();
			dto.put("userId", i);
			dto.put("name", "zzx-demo-" + i);
			dto.put("age", i);
			kafkaMessageProducer2.sendObject(Constant.TOPIC_DEMO3, dto);
		}
	}
}
