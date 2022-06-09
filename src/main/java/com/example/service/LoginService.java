package com.example.service;

import com.example.entity.Login;

/**
 * productsテーブル用サービスインターフェース
 */
public interface LoginService {

	public Login findIdAndPass(String login_id, String password,String name);

}

