package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.LoginDao;
import com.example.entity.Login;


@Repository
public class PgLoginDao implements LoginDao {

	private static final String SELECT_ID_AND_PASS = 
			"SELECT * FROM users WHERE login_id = :id and password = :pass";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * 条件を指定した検索
	 */
	@Override
	public Login findIdAndPass(String login_id,String password,String name) {

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("id", login_id);
		param.addValue("pass", password);


		String sql = SELECT_ID_AND_PASS;
		List<Login>resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Login>(Login.class));

		return resultList.isEmpty() ? null:resultList.get(0);
	}
}

