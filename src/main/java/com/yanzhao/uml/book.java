package com.yanzhao.uml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class book implements bookapi{

    private String bookname;
    private String booktype;
    private String author;
    private String publics;
    private int booknum;
    @Override
    public void addbook(String bookid) {

    }

    @Override
    public void deletebook(String bookid) {

    }

    @Override
    public void bookbeborrowed(String bookid) {

    }

    @Override
    public void bookbeback(String bookid) {

    }
}
