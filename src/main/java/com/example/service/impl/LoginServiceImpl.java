package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginDao;
import com.example.entity.Login;
import com.example.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    /**
     * 条件を指定した検索
     */
    @Override
    public Login findIdAndPass(String login_id,String password,String name) {
        return loginDao.findIdAndPass(login_id,password,name);
    }
}

