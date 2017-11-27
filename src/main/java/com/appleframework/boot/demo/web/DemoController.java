package com.appleframework.boot.demo.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.biz.banana.bean.User;
import org.biz.banana.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appleframework.web.springmvc.controller.BaseController;


@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {

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
}
