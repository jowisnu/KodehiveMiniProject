package com.kodehiveminiproject.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kodehiveminiproject.model.CelebrityModel;
import com.kodehiveminiproject.model.CityModel;
import com.kodehiveminiproject.model.MiniProjectModel;
import com.kodehiveminiproject.model.MovieModel;
import com.kodehiveminiproject.repository.IMiniProjectRepository;

@Repository
public class MiniProjectRepository implements IMiniProjectRepository {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int InsertData(CelebrityModel celebrityModel) {
		var query = "insert into t_celebrity(id, name, born, city, movie1, movie2, movie3)" + "values (?,?,?,?,?,?,?)";
		return jdbc.update(query,
				new Object[] {celebrityModel.getId(),celebrityModel.getName(), celebrityModel.getBorn(), celebrityModel.getCity(), celebrityModel.getMovie1(), celebrityModel.getMovie2(), celebrityModel.getMovie3()});
	}

	@Override
	public List<CelebrityModel> readCelebrity() {
		var query = "select cel.id,cel.name,cel.born,cel.city,cel.movie1 from t_celebrity cel;";
		return jdbc.query(query, new BeanPropertyRowMapper<CelebrityModel>(CelebrityModel.class));
	}

	@Override
	public List<MovieModel> readMovie() {
		var query = "select mov.id,mov.title from t_movie mov;";
		return jdbc.query(query, new BeanPropertyRowMapper<MovieModel>(MovieModel.class));
	}

	@Override
	public List<CityModel> readCity() {
		var query = "select cit.id,cit.name from t_city cit ;";
		return jdbc.query(query, new BeanPropertyRowMapper<CityModel>(CityModel.class));
	}
	
	@Override
	public List<MiniProjectModel> readAllDataSortMovie(String keyword) {
		var query = "select cel.id as id, cel.name as name, cel.born as born, cit.name as city, mov.title as movie1  from t_celebrity cel\r\n"
				+ "	inner join t_city cit  \r\n"
				+ "		on cel.city = cit.id\r\n"
				+ "			inner join t_movie mov\r\n"
				+ "				on cel.movie1 = mov.id"
				+ "					where mov.title like '%"+keyword+"%';";
		return jdbc.query(query, new BeanPropertyRowMapper<MiniProjectModel>(MiniProjectModel.class));
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		var query = "delete from t_celebrity where id = ?";
		return jdbc.update(query, id);
	}
	
	@Override
	public int UpdateData(int id, CelebrityModel celebrityModel) {
		var query = "update t_celebrity set name = ?, born = ?, city = ?, movie1 = ? where id = "+id;
		return jdbc.update(query,
				new Object[] {celebrityModel.getName(), celebrityModel.getBorn(), celebrityModel.getCity(), celebrityModel.getMovie1()});
	}

	@Override
	public int InsertDataMovie(MovieModel movieModel) {
		// TODO Auto-generated method stub
		var query = "insert into t_movie(id, title)" + "values (?,?)";
		return jdbc.update(query,
				new Object[] {movieModel.getId(), movieModel.getTitle()});
	}

	@Override
	public int InsertDataCity(CityModel cityModel) {
		// TODO Auto-generated method stub
		var query = "insert into t_city(id, name)" + "values (?,?)";
		return jdbc.update(query,
				new Object[] {cityModel.getId(), cityModel.getName()});
	}
	
	@Override
	public List<MiniProjectModel> readAll() {
		var query = "select cel.id as id, cel.name as name, cel.born as born, cit.name as city, mov.title as movie1  from t_celebrity cel\r\n"
				+ "	inner join t_city cit  \r\n"
				+ "		on cel.city = cit.id\r\n"
				+ "			inner join t_movie mov\r\n"
				+ "				on cel.movie1 = mov.id;";
		return jdbc.query(query, new BeanPropertyRowMapper<MiniProjectModel>(MiniProjectModel.class));
	}
}
