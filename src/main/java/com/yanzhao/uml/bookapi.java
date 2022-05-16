package com.yanzhao.uml;

public interface bookapi {
    void addbook(String bookid);
    void deletebook(String bookid);
    void bookbeborrowed(String bookid);
    void bookbeback(String bookid);

}
