package com.kodehiveminiproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodehiveminiproject.model.CelMovModel;
import com.kodehiveminiproject.model.CelebrityModel;
import com.kodehiveminiproject.model.CityModel;
import com.kodehiveminiproject.model.MiniProjectModel;
import com.kodehiveminiproject.model.MovieModel;
import com.kodehiveminiproject.repository.IMiniProjectRepository;
import com.kodehiveminiproject.repository.impl.MiniProjectRepository;
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
	public int InsertCelebMovie(CelMovModel celmovModel) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.InsertCelebMovie(celmovModel);
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
	public List<MiniProjectModel> readAllData() {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.readAllData();
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
	public int UpdateCeleb(int id, CelebrityModel celebrityModel) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.UpdateCeleb(id, celebrityModel);
		return result;
	}
	@Override
	public int UpdateMovie(int id, MovieModel movieModel) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.UpdateMovie(id, movieModel);
		return result;
	}

	@Override
	public int UpdateCity(int id, CityModel cityModel) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.UpdateCity(id, cityModel);
		return result;
	}

	@Override
	public int UpdateCelebMovie(int id, CelMovModel celmovModel) {
		// TODO Auto-generated method stub
		var result = MiniProjectRepository.UpdateCelebMovie(id, celmovModel);
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
	public int DeleteCeleb(int id) {
		// TODO Auto-generated method stub
		return MiniProjectRepository.DeleteCeleb(id);
	}

	@Override
	public int DeleteMovie(int id) {
		// TODO Auto-generated method stub
		return MiniProjectRepository.DeleteMovie(id);
	}

	@Override
	public int DeleteCity(int id) {
		// TODO Auto-generated method stub
		return MiniProjectRepository.DeleteCity(id);
	}

	@Override
	public int DeleteCelebMovie(int id) {
		// TODO Auto-generated method stub
		return MiniProjectRepository.DeleteCelebMovie(id);
	}

	
	@Override
	public List<MiniProjectModel> readData(int limit, int first) {
		// TODO Auto-generated method stub
		return MiniProjectRepository.readData(limit, first);
	}
	
	@Override
	public List<CelebrityModel> readAll(){
		var result = MiniProjectRepository.readAll();
		
		for(var row : result) {
			var movie = MiniProjectRepository.readAllByCeleb(row.getId());
			row.setMovie(movie);
		}
		return result;
	}
}
