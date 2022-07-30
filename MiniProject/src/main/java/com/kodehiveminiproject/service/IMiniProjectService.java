package com.kodehiveminiproject.service;

import java.util.List;

import com.kodehiveminiproject.model.CelMovModel;
import com.kodehiveminiproject.model.CelebrityModel;
import com.kodehiveminiproject.model.CityModel;
import com.kodehiveminiproject.model.MiniProjectModel;
import com.kodehiveminiproject.model.MovieModel;

public interface IMiniProjectService {
	public int InsertData(CelebrityModel celebrityModel);
	public int InsertCelebMovie(CelMovModel celmovModel);
	
	public List<CelebrityModel> readCelebrity();
	public List<MovieModel> readMovie();
	public List<CityModel> readCity();
	
	public List<MiniProjectModel> readAllData();
	public List<MiniProjectModel> readData(int limit, int first);
	public List<MiniProjectModel> readAllDataSortMovie(String keyword);

	
	public int UpdateCeleb(int id, CelebrityModel celebrityModel);
	public int UpdateMovie(int id, MovieModel movieModel);
	public int UpdateCity(int id, CityModel cityModel);
	public int UpdateCelebMovie(int id, CelMovModel celmovModel);
	
	
	public int InsertDataMovie(MovieModel movieModel);
	public int InsertDataCity(CityModel cityModel);
	

	public int DeleteCeleb(int id);
	public int DeleteMovie(int id);
	public int DeleteCity(int id);
	public int DeleteCelebMovie(int id);
	
	public List<CelebrityModel> readAll();
}
