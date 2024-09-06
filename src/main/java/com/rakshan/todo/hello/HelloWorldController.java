package com.rakshan.todo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "wassup";
	}
	
	@RequestMapping("/hello-jsp")
	public String sayhellojsp() {
		return "sayHello";
	}
	
}
