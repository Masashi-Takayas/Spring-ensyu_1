package com.example.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * トップ画面用フォーム
 */
public class RankingForm {
    
	private Integer id;

    @NotBlank
    private String name;

    @NotNull
    private Integer score;

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

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }
}

