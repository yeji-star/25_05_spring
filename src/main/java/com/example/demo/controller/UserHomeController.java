package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserHomeController {
	private int i;

	public UserHomeController() {
		i = 0;
	}

	@RequestMapping("/user/home/setI")
	@ResponseBody
	public String showMain(int value) {
		this.i = value;
		
		return "초기화";
	}

	@RequestMapping("/user/home/getI")
	@ResponseBody
	public int showMain4() {

		return i++;

	}

	@RequestMapping("/user/home/main2")
	@ResponseBody
	public String showMain2() {
		return "잘가";
	}

	@RequestMapping("/user/home/main3")
	@ResponseBody
	public int showMain3() {

		return 1 + 2;
	}

}
