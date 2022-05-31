package com.yanzhao.uml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class showinfo implements showinfoapi{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public String showborrowedbook(String username) {
        String result="";
        String sql2="select bookborrowed from users where username="+username;
        String borrowsbooks=jdbcTemplate.queryForObject(sql2,String.class);
        result+=username+"已经借了";
        result+=borrowsbooks+"等书";
        return result;
    }
}
