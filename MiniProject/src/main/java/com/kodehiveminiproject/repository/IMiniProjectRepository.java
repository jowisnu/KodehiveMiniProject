package com.kodehiveminiproject.repository;

import java.util.List;
import com.kodehiveminiproject.model.CelebrityModel;
import com.kodehiveminiproject.model.CityModel;
import com.kodehiveminiproject.model.MiniProjectModel;
import com.kodehiveminiproject.model.MovieModel;

public interface IMiniProjectRepository {
	public int InsertData(CelebrityModel celebrityModel);
	public List<CelebrityModel> readCelebrity();
	public List<MovieModel> readMovie();
	public List<CityModel> readCity();
	public List<MiniProjectModel> readAllDataSortMovie(String keyword);
	public int delete(int id);
	public int UpdateData(int id, CelebrityModel celebrityModel);
	
	
	public int InsertDataMovie(MovieModel movieModel);
	public int InsertDataCity(CityModel cityModel);
	public List<MiniProjectModel> readAll();
}
