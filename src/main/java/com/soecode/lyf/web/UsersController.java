package com.soecode.lyf.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.soecode.lyf.entity.Book;
import com.soecode.lyf.entity.Users;
import com.soecode.lyf.service.UsersService;


@Controller
@RequestMapping(value="/users")
public class UsersController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UsersService userService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Users> list = userService.getListUsers();
		model.addAttribute("list", list);
//		System.out.println(model);
		// users.jsp + model = ModelAndView
		return "users";
	}
}
