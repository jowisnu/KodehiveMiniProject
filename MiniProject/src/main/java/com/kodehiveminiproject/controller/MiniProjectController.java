package com.kodehiveminiproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehiveminiproject.model.CelebrityModel;
import com.kodehiveminiproject.model.MiniProjectModel;
import com.kodehiveminiproject.service.IMiniProjectService;

@Controller
@RequestMapping("/miniproject")
public class MiniProjectController {
	
	@Autowired
	IMiniProjectService MiniProjectService;
	
	@RequestMapping("/beranda")
	public String beranda() {
		return "/home";
	}
	
	@RequestMapping("/login")
	public String QuizJQuery1No5() {
		return "/login";
	}
	
	@RequestMapping("/celebrity/dont")
	public String CelebrityList(Model model) {
		
		List<CelebrityModel> CelebrityModelList = new ArrayList<CelebrityModel>();
		CelebrityModelList = MiniProjectService.readCelebrity();
		
		model.addAttribute("celebrity", CelebrityModelList);
		return "/celebrity_dont";
	}
	
	@RequestMapping("/celebrity/list")
	public String AllList(Model model) {
		
		List<CelebrityModel> CelebrityModelList = new ArrayList<CelebrityModel>();
		CelebrityModelList = MiniProjectService.readAll();
				
		model.addAttribute("celebrity", CelebrityModelList);
		return "/celebrity";
	}
	
	@RequestMapping("/celebrity/try")
	public String trial(Model model) {
		List<CelebrityModel> CelebrityModelList = new ArrayList<CelebrityModel>();
		CelebrityModelList = MiniProjectService.readAll();
				
		model.addAttribute("celebrity", CelebrityModelList);
		return "/celebrity2";
	}
}
