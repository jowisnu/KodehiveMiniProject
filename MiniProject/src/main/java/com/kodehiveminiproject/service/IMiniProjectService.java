package com.kodehiveminiproject.service;

import java.util.List;
import com.kodehiveminiproject.model.CelebrityModel;
import com.kodehiveminiproject.model.CityModel;
import com.kodehiveminiproject.model.MiniProjectModel;
import com.kodehiveminiproject.model.MovieModel;

public interface IMiniProjectService {
	int InsertData(CelebrityModel celebrityModel);
	public List<CelebrityModel> readCelebrity();
	public List<MovieModel> readMovie();
	public List<CityModel> readCity();
	public List<MiniProjectModel> readAllDataSortMovie(String keyword);
	int delete(int id);
	int UpdateData(int id, CelebrityModel celebrityModel);
	
	
	int InsertDataMovie(MovieModel movieModel);
	int InsertDataCity(CityModel cityModel);
	public List<MiniProjectModel> readAll();
}
