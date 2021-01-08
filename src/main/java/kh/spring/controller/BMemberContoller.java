package kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/bmember")
public class BMemberContoller {
	@ExceptionHandler
	public String exceptionalHandler(Throwable e) {
		e.printStackTrace();
		return "error";
	}
}
