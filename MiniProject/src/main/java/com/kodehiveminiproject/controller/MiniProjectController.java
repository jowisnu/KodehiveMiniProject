package com.kodehiveminiproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehiveminiproject.service.IMiniProjectService;

@Controller
public class MiniProjectController {
	
	@Autowired
	IMiniProjectService MiniProjectService;
	
	@RequestMapping("/beranda")
	public String beranda() {
		return "/home";
	}
}
