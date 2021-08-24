package com.soecode.lyf.web;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soecode.lyf.entity.Users;
import com.soecode.lyf.service.UsersService;

@Controller
public class LoginController {
	
	@Autowired
	private UsersService userService;
	
	@RequestMapping(value="/login")
	public String index() {
		return "login";
	}
	
	@RequestMapping(value="loginSubmit", method=RequestMethod.POST)
	private String logincheck(@RequestParam("name") String name, @RequestParam("pwd") String pwd, Model model) {
		Users tryUser = new Users(name, pwd);
		System.out.println(tryUser.getName());
		//Users userCheck = userService.getByName(tryUser.getName());
		
		return "loginSuccess";
	}
	
}
