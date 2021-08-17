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

import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.dto.Result;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.enums.AppointStateEnum;
import com.soecode.lyf.exception.NoNumberException;
import com.soecode.lyf.exception.RepeatAppointException;
import com.soecode.lyf.service.BookService;

@Controller
@RequestMapping("/") // url:/模块모듈/资源자원/{id}/细分세분 /seckill/list
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String list(Model model) {
		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list";// WEB-INF/jsp/"list".jsp
	}


//	// ajax json
//	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
//			"application/json; charset=utf-8" })
//	@ResponseBody
//	private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
//		if (studentId == null || studentId.equals("")) {
//			return new Result<>(false, "Studentid is cannot be empty");
//		}
//		AppointExecution execution = null;
//		try {
//			execution = bookService.appoint(bookId, studentId);
//		} catch (NoNumberException e1) {
//			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
//		} catch (RepeatAppointException e2) {
//			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
//		} catch (Exception e) {
//			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
//		}
//		return new Result<AppointExecution>(true, execution);
//	}

}
