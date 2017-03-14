package controllers;

import models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public User printWelcome(User u) {
		return u;
	}
}