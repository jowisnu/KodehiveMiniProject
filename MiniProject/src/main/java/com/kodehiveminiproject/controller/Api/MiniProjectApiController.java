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

import com.kodehiveminiproject.model.CelMovModel;
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
	
	@PostMapping("/insert/celebrity_movie")
	public String InsertCelebMovie(@RequestBody CelMovModel celmovModel) {
		MiniProjectService.InsertCelebMovie(celmovModel);
		return "insert success";
	}
	
	
	
	@GetMapping("/read/all")
	public List<MiniProjectModel> readAllData() {		
		return MiniProjectService.readAllData();
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
	
	@GetMapping("/read/ByLimit")
	public List<MiniProjectModel> readData(@RequestParam int limit, @RequestParam int first) {		
		return MiniProjectService.readData(limit, first);
	}
	
	@PutMapping("/update/celebrity")
	public ResponseEntity<String> UpdateCeleb(@RequestParam int id, @RequestBody CelebrityModel celebrityModel) {
		MiniProjectService.UpdateCeleb(id, celebrityModel);  // finds the user with the provided id and update it
		return new ResponseEntity<>("User updated.", HttpStatus.OK);
	}
	@PutMapping("/update/movie")
	public ResponseEntity<String> UpdateMovie(@RequestParam int id, @RequestBody MovieModel movieModel) {
		MiniProjectService.UpdateMovie(id, movieModel);  // finds the user with the provided id and update it
		return new ResponseEntity<>("User updated.", HttpStatus.OK);
	}
	@PutMapping("/update/city")
	public ResponseEntity<String> UpdateCity(@RequestParam int id, @RequestBody CityModel cityModel) {
		MiniProjectService.UpdateCity(id, cityModel);  // finds the user with the provided id and update it
		return new ResponseEntity<>("User updated.", HttpStatus.OK);
	}
	@PutMapping("/update/celebrity_movie")
	public ResponseEntity<String> UpdateCelebMovie(@RequestParam int id, @RequestBody CelMovModel celmovModel) {
		MiniProjectService.UpdateCelebMovie(id, celmovModel);  // finds the user with the provided id and update it
		return new ResponseEntity<>("User updated.", HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete/celebrity")
	public String DeleteCeleb(@RequestParam int id) {
		return "successfully delete, "+MiniProjectService.DeleteCeleb(id);
	}
	@DeleteMapping("/delete/movie")
	public String DeleteMovie(@RequestParam int id) {
		return "successfully delete, "+MiniProjectService.DeleteMovie(id);
	}	
	@DeleteMapping("/delete/city")
	public String DeleteCity(@RequestParam int id) {
		return "successfully delete, "+MiniProjectService.DeleteCity(id);
	}
	@DeleteMapping("/delete/celebrity_movie")
	public String DeleteCelebMovie(@RequestParam int id) {
		return "successfully delete, "+MiniProjectService.DeleteCelebMovie(id);
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
