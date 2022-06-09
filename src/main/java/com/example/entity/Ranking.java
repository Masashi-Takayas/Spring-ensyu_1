package com.example.entity;

import com.example.util.ParamUtil;

/**
 * productsテーブルのEntity
 */
public class Ranking {
	private Integer id;
	private String name;
	private Integer score;

	public Ranking() {

	}

	public Ranking(Integer id, String name, Integer score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Ranking [id=" + id + ", name=" + name + ", score=" + score + "]";
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	// 全フィールドが未入力かの判断
	public boolean isEmptyCondition() {
		return id == null && ParamUtil.isNullOrEmpty(name) && score == null;
	}
}

