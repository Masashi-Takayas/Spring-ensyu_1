package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.RankingDao;
import com.example.entity.Ranking;


@Repository
public class PgRankingDao implements RankingDao {

	private static final String SELECT_ALL = "SELECT name,score FROM ranking ORDER BY score DESC";
	private static final String INSERT = "INSERT INTO ranking(name, score) VALUES(:name, :score)";
	private static final String DELETE = "DELETE FROM ranking WHERE name = :name";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Ranking> findAll(Ranking ranking) {
		String sql = SELECT_ALL;
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Ranking>(Ranking.class));
	}

	/**
	 * 登録
	 */
	@Override
	public void insert(Ranking ranking) {
		String sql = INSERT;

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", ranking.getName());
		param.addValue("score", ranking.getScore());

		jdbcTemplate.update(sql, param);
	}

	@Override
	public void delete(Ranking ranking) {
		String sql = DELETE;

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", ranking.getName());

		jdbcTemplate.update(sql, param);
	}
}

