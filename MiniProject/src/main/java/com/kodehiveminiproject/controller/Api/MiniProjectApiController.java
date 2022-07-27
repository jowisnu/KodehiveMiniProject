package com.kodehiveminiproject.controller.Api;

import java.util.List;

import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodehiveminiproject.model.CelebrityModel;
import com.kodehiveminiproject.model.CityModel;
import com.kodehiveminiproject.model.MiniProjectModel;
import com.kodehiveminiproject.model.MovieModel;
import com.kodehiveminiproject.repository.impl.MiniProjectRepository;
import com.kodehiveminiproject.service.IMiniProjectService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MiniProjectApiController {
	
	@Autowired
	IMiniProjectService MiniProjectService;
	
	@PostMapping("/insert/celebrity")
	public String InsertData(@RequestBody CelebrityModel celebrityModel) {
		MiniProjectService.InsertData(celebrityModel);
		return "insert success";
	}
	
	@DeleteMapping("/delete/celebrity")
	public String delete (@RequestParam int id) {
		return "successfully delete, "+MiniProjectService.delete(id);
	}
	
	@GetMapping("/read/all")
	public List<MiniProjectModel> readAll() {		
		return MiniProjectService.readAll();
	}
	
	@GetMapping("/read/celebrity")
	public List<CelebrityModel> readCelebrity() {		
		return MiniProjectService.readCelebrity();
	}
	
	@GetMapping("/read/movie")
	public List<MovieModel> readMovie() {		
		return MiniProjectService.readMovie();
	}
	
	@GetMapping("/read/city")
	public List<CityModel> readCity() {		
		return MiniProjectService.readCity();
	}
	
	@GetMapping("/read/AllSortMovie")
	public List<MiniProjectModel> readAllDataSortMovie(@RequestParam String keyword) {		
		return MiniProjectService.readAllDataSortMovie(keyword);
	}	
	
	@PutMapping("/update/celebrity")
	public ResponseEntity<String> UpdateData(@RequestParam int id, @RequestBody CelebrityModel celebrityModel) {
		MiniProjectService.UpdateData(id, celebrityModel);  // finds the user with the provided id and update it
		return new ResponseEntity<>("User updated.", HttpStatus.OK);
	}
	
	
	
	@PostMapping("/insert/movie")
	public String InsertDataMovie(@RequestBody MovieModel movieModel) {
		MiniProjectService.InsertDataMovie(movieModel);
		return "insert movie success";
	}
	@PostMapping("/insert/city")
	public String InsertDataCity(@RequestBody CityModel cityModel) {
		MiniProjectService.InsertDataCity(cityModel);
		return "insert city success";
	}
}	
