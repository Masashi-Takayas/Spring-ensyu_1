package com.example.dao;

import com.example.entity.Login;

/**
 * productsテーブル用DAO (インターフェース)
 */
public interface LoginDao {

	public Login findIdAndPass(String login_id, String password,String name);

}

