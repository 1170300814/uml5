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
        jdbcTemplate.update("delete from users where username=?",username);
    }

    @Override
    public void insertbook(String bookname, String booktype, String author, String publics, int booknum) {
        jdbcTemplate.update("insert into books(bookname,booktype,author,publics,booknum) values (?,?,?,?,?)",bookname,booktype,author,publics,booknum);
    }

    @Override
    public void deletebook(String bookname) {
        jdbcTemplate.update("delete from books where bookname=?",bookname);
    }


}
