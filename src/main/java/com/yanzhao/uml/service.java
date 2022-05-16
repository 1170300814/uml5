package com.yanzhao.uml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class service implements serviceapi{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insert(String username, int password) {
        jdbcTemplate.update("insert into users(username,password) values (?,?)",username,password);
    }

    @Override
    public void deleteuser(String username) {

    }

}
