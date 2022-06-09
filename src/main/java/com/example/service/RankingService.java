package com.example.service;

import java.util.List;

import com.example.entity.Ranking;

/**
 * productsテーブル用サービスインターフェース
 */
public interface RankingService {
    public List<Ranking> findAll(Ranking ranking);

    public void insert(Ranking ranking);
    
    public void delete(Ranking ranking);
    
}

