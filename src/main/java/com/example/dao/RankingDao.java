package com.example.dao;

import java.util.List;

import com.example.entity.Ranking;

/**
 * productsテーブル用DAO (インターフェース)
 */
public interface RankingDao {
    public List<Ranking> findAll(Ranking ranking);

    public void insert(Ranking ranking);
    
    public void delete(Ranking ranking);
}

