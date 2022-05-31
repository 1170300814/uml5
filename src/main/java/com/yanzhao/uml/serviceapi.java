package com.yanzhao.uml;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * 这是管理员拥有的权限api
 */
public interface serviceapi {

    void insert(String username,int password);
    void deleteuser(String username);
    void insertbook(String bookname,  String booktype, String author, String publics,  int booknum);
    void deletebook(String bookname);


}
