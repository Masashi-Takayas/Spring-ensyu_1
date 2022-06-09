package com.example.entity;

import com.example.util.ParamUtil;

/**
 * productsテーブルのEntity
 */
public class Login {
    private String login_id;
    private String password;
    private String name;
    private Integer role;

    public Login() {

    }

    public Login(String login_id,String password, String name, Integer role) {
        this.login_id = login_id;
        this.password = password;
        this.name = name;
        this.role = role;
    }

	// 全フィールドが未入力かの判断
    public boolean isEmptyCondition() {
        return login_id == null && ParamUtil.isNullOrEmpty(login_id) && password == null;
    }

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}

