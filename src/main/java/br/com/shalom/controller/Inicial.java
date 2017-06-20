package br.com.shalom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Inicial {

	
	@GetMapping("/")
	public String root() {
		return "DashBoard";
	}
	
}
