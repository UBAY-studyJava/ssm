package com.soecode.lyf.web;

import java.awt.Window;
import java.net.http.HttpClient.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.dto.Result;
import com.soecode.lyf.entity.Appointment;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.enums.AppointStateEnum;
import com.soecode.lyf.exception.NoNumberException;
import com.soecode.lyf.exception.RepeatAppointException;
import com.soecode.lyf.service.BookService;

@Controller
@RequestMapping("/book") // url:/模块모듈/资源자원/{id}/细分세분 /seckill/list
public class BookController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list";// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId, Model model) {
		if (bookId == null) {
			return "redirect:/book/list";
		}
		Book book = bookService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		return "detail";
	}
	
	@RequestMapping(value = "/{bookId}/modify", method = RequestMethod.GET)
	private String beforeModify(@PathVariable("bookId") Long bookId, Model model) {
		if (bookId == null) {
			return "redirect:/book/list";
		}
		Book book = bookService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		return "modify";
	}
		
	@RequestMapping(value = "/{bookId}/modified", method = RequestMethod.POST)
	private String modify(@PathVariable("bookId") Long bookId, @RequestParam("name") String name,
				@RequestParam("number") int number) throws Exception {
		String url = "redirect:/book/" + bookId;
		if (bookId == null || name == null || name == "" || name == " " || number <= 0) {
			return url + "/modify";
		}
		int modify = bookService.modify(bookId, name, number);
		if (modify != 1) {
			return url + "/detail";
		}
	return url + "/detail";
	}

	// 게시물 삭제
	@RequestMapping(value = "/{bookId}/delete", method = RequestMethod.POST)
	private String getDelete(@PathVariable("bookId") Long bookId) throws Exception {
		bookService.delete(bookId);
			
		return "redirect:/book/list";
	}

	
	

	// testing
	// ajax json
	@RequestMapping(value = "/appoint", method = RequestMethod.POST)
	@ResponseBody
	private void appoint(@RequestParam("bookId") Long bookId, @RequestParam("studentId") Long studentId, HttpServletResponse response) throws Exception {
		Result<AppointExecution> appointment;
		String url = "/ssm/book/list";
		if (studentId == null || studentId.equals("")) {
			appointment = new Result<>(false, "Studentid is cannot be empty");
			JOptionPane.showMessageDialog(null, "Studentid is cannot be empty");
			response.sendRedirect(url);
		}
		AppointExecution execution = null;
		try {
			execution = bookService.appoint(bookId, studentId);
		} catch (NoNumberException e1) {
			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
		} catch (RepeatAppointException e2) {
			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
		} catch (Exception e) {
			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
		}
		appointment = new Result<AppointExecution>(true, execution);
		JOptionPane.showMessageDialog(null, appointment.getData().getStateInfo());
		response.sendRedirect(url);
	}

	@RequestMapping(value="/appoint/list", method = RequestMethod.GET)
	private String listAppointment(Model model) {
		List<Appointment> list = bookService.getAppointment();
		model.addAttribute("list", list);
		return "appointList";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	private String beforeInsert() {
		return "insert";
	}

	@RequestMapping(value = "/inserted", method = RequestMethod.POST)
	private String insert(@RequestParam("name") String name, @RequestParam("number") int number) throws Exception {
	if (name == null || name == "" || name == " " || number <= 0) {
		return "redirect:/book/insert";
	}
	int insert = bookService.insert(name, number);
	if (insert != 1) {
		return "redirect:/book/insert";
	}
	return "redirect:/book/list";
	}

	
}
