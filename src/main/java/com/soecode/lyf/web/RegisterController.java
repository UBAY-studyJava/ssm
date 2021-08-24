package com.soecode.lyf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soecode.lyf.entity.Users;
import com.soecode.lyf.service.UsersService;


@Controller
public class RegisterController {
	
	@Autowired
	private UsersService userService;

	
	@RequestMapping(value="/register")
	public String index() {
		return "register";
	}
	
	
	@RequestMapping(value="apply", method = RequestMethod.POST)
	public String register(@RequestParam("name") String name, @RequestParam("pwd") String pwd, Model model) {
		
		Users newUser = new Users(name, pwd);
		int result = userService.checkUserLogin(newUser);
		
		switch(result) {
		case 0:
			return "register";
		case 1:
			return "register";
		case 2:
			return "index";
		}
		
		return "index";
	}

}
