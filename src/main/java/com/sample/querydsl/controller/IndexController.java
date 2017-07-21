package com.sample.querydsl.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sample.querydsl.model.User;
import com.sample.querydsl.service.UserService;

@Controller
public class IndexController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	@ResponseBody
	public Object Test(HttpServletRequest request, Model model){
		return userService.getUsers();
	}
}	
