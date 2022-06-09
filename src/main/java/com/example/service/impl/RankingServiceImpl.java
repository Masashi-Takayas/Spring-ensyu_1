package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.RankingDao;
import com.example.entity.Ranking;
import com.example.service.RankingService;

@Service
public class RankingServiceImpl implements RankingService {
    @Autowired
    private RankingDao rankingDao;

    /**
     * 全件検索
     */
    @Override
    public List<Ranking> findAll(Ranking ranking) {
        return rankingDao.findAll(ranking);
    }

    /**
     * 登録
     */
    @Override
    public void insert(Ranking ranking) {
        rankingDao.insert(ranking);
    }
    
    @Override
    public void delete(Ranking ranking) {
        rankingDao.delete(ranking);
    }
    
}
