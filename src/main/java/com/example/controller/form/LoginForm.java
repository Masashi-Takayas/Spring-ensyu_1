package com.example.controller.form;

import javax.validation.constraints.NotBlank;

/**
 * トップ画面用フォーム
 */
public class LoginForm {
    private Integer role;
    private String name;

    @NotBlank
    private String login_id;

    @NotBlank
    private String password;



	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
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
    
}

