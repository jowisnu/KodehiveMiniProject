package com.kodehiveminiproject.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kodehiveminiproject.model.CelMovModel;
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
		var query = "insert into t_celebrity(name, born, city)" + "values (?,?,?);";
		return jdbc.update(query,
				new Object[] {celebrityModel.getName(), celebrityModel.getBorn(), celebrityModel.getCity()});
	}
	
	@Override
	public int InsertCelebMovie(CelMovModel celmovModel) {
		var query = "insert into t_cel_mov(idCel, idMov)" + "values (?,?);";
		return jdbc.update(query,
				new Object[] {celmovModel.getIdCel(), celmovModel.getIdMov()});
	}

	@Override
	public List<CelebrityModel> readCelebrity() {
		var query = "select cel.id,cel.name,cel.born,cel.city from t_celebrity cel;";
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
	public List<MiniProjectModel> readAllData() {
		var query = "select cm.id as id, cel.name as name, cel.born as born, cit.name as city, mov.title as movie from t_cel_mov cm\r\n"
				+ "	join t_celebrity cel on cm.idCel = cel.id\r\n"
				+ "	join t_movie mov on cm.idMov = mov.id\r\n"
				+ "    join t_city cit on cel.city = cit.id;";
		return jdbc.query(query, new BeanPropertyRowMapper<MiniProjectModel>(MiniProjectModel.class));
	}
	
	@Override
	public List<MiniProjectModel> readAllDataSortMovie(String keyword) {
		var query = "select cm.id as id, cel.name as name, cel.born as born, cit.name as city, mov.title as movie from t_cel_mov cm\r\n"
				+ "	join t_celebrity cel on cm.idCel = cel.id\r\n"
				+ "		join t_movie mov on cm.idMov = mov.id\r\n"
				+ "    		join t_city cit on cel.city = cit.id"
				+ "				where mov.title like '%"+keyword+"%';";
		return jdbc.query(query, new BeanPropertyRowMapper<MiniProjectModel>(MiniProjectModel.class));
	}
	
	
	
	@Override
	public int UpdateCeleb(int id, CelebrityModel celebrityModel) {
		var query = "update t_celebrity set name = ?, born = ?, city = ? where id = "+id;
		return jdbc.update(query,
				new Object[] {celebrityModel.getName(), celebrityModel.getBorn(), celebrityModel.getCity()});
	}
	@Override
	public int UpdateMovie(int id, MovieModel movieModel) {
		var query = "update t_movie set title = ? where id = "+id;
		return jdbc.update(query,
				new Object[] {movieModel.getTitle()});
	}
	@Override
	public int UpdateCity(int id, CityModel cityModel) {
		var query = "update t_city set name = ? where id = "+id;
		return jdbc.update(query,
				new Object[] {cityModel.getName()});
	}
	@Override
	public int UpdateCelebMovie(int id, CelMovModel celmovModel) {
		var query = "update t_cel_mov set idCel = ?, idMov = ? where id = "+id;
		return jdbc.update(query,
				new Object[] {celmovModel.getIdCel(),celmovModel.getIdMov()});
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
	public int DeleteCeleb(int id) {
		// TODO Auto-generated method stub
		var query = "delete from t_celebrity where id = ?";
		return jdbc.update(query, id);
	}
	@Override
	public int DeleteMovie(int id) {
		// TODO Auto-generated method stub
		var query = "delete from t_movie where id = ?";
		return jdbc.update(query, id);
	}
	@Override
	public int DeleteCity(int id) {
		// TODO Auto-generated method stub
		var query = "delete from t_city where id = ?";
		return jdbc.update(query, id);
	}
	@Override
	public int DeleteCelebMovie(int id) {
		// TODO Auto-generated method stub
		var query = "delete from t_cel_mov where id = ?";
		return jdbc.update(query, id);
	}

	@Override
	public List<MiniProjectModel> readData(int limit, int first) {
		// TODO Auto-generated method stub
		var query = "select cm.id as id, cel.name as name, cel.born as born, cit.name as city, mov.title as movie from t_cel_mov cm\r\n"
				+ "	join t_celebrity cel on cm.idCel = cel.id\r\n"
				+ "	join t_movie mov on cm.idMov = mov.id\r\n"
				+ "	join t_city cit on cel.city = cit.id "
				+ " limit "+first+","+limit;
		first=first+limit;
		return jdbc.query(query, new BeanPropertyRowMapper<MiniProjectModel>(MiniProjectModel.class));
	}
	
	public List<MovieModel> readAllByCeleb(int id){
		var query = "select b.* from t_cel_mov a\r\n"
				+ "join t_movie b on a.idMov = b.id\r\n"
				+ "where a.idCel = ?";
		return jdbc.query(query, new BeanPropertyRowMapper<MovieModel>(MovieModel.class),new Object[] {id});
	}

	@Override
	public List<CelebrityModel> readAll() {
		// TODO Auto-generated method stub
		var query = "select * from (	select t_celebrity.id as id, t_celebrity.name as name, t_celebrity.born as born, t_city.name as city from t_celebrity "
				+ "					join t_city on t_celebrity.city = t_city.id "
				+ "						group by t_celebrity.name ) as tb";
		return jdbc.query(query, new BeanPropertyRowMapper<CelebrityModel>(CelebrityModel.class));
	}
}
