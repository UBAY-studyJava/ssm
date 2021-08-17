package com.soecode.lyf.web;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.soecode.lyf.entity.Users;


@Controller
@RequestMapping("/register") // url:/模块모듈/资源자원/{id}/细分세분 /seckill/list
public class RegisterController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView register(Users user) {
		
		return new ModelAndView();
	}

}
