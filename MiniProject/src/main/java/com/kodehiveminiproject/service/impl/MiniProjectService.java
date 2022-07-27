package com.kodehiveminiproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodehiveminiproject.model.CelebrityModel;
import com.kodehiveminiproject.model.CityModel;
import com.kodehiveminiproject.model.MiniProjectModel;
import com.kodehiveminiproject.model.MovieModel;
import com.kodehiveminiproject.repository.IMiniProjectRepository;
import com.kodehiveminiproject.service.IMiniProjectService;

@Service
public class MiniProjectService implements IMiniProjectService{
	
	@Autowired
	IMiniProjectRepository MiniProjectRepository;
	
	@Override
	public int InsertData(CelebrityModel celebrityModel) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.InsertData(celebrityModel);
		return result;
	}
	
	@Override
	public List<CelebrityModel> readCelebrity() {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.readCelebrity();
		System.out.println("select success");
		return result;
	}
	
	@Override
	public List<MovieModel> readMovie() {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.readMovie();
		System.out.println("select success");
		return result;
	}
	
	@Override
	public List<CityModel> readCity() {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.readCity();
		System.out.println("select success");
		return result;
	}

	@Override
	public List<MiniProjectModel> readAllDataSortMovie(String keyword) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.readAllDataSortMovie(keyword);
		System.out.println("select success");
		return result;
	}
	
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return MiniProjectRepository.delete(id);
	}

	@Override
	public int UpdateData(int id, CelebrityModel celebrityModel) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.UpdateData(id, celebrityModel);
		return result;
	}
	
	
	
	@Override
	public int InsertDataMovie(MovieModel movieModel) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.InsertDataMovie(movieModel);
		return result;
	}

	@Override
	public int InsertDataCity(CityModel cityModel) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.InsertDataCity(cityModel);
		return result;
	}

	@Override
	public List<MiniProjectModel> readAll() {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.readAll();
		System.out.println("select success");
		return result;
	}
}
