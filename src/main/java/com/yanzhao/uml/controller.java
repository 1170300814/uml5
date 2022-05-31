package com.yanzhao.uml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ServiceConfigurationError;

@ResponseBody
@Slf4j
@RestController
public class controller {

    @Autowired
    service service;

    @RequestMapping("/adduser/{username}/{password}")
    public String adduser(@PathVariable String username,@PathVariable Integer password)
    {
        service.insert(username,password);
        log.info("用户添加");
        return "用户添加成功";
    }

    @RequestMapping("/deleteuser/{username}")
    public String deleteuser(@PathVariable String username)
    {
        service.deleteuser(username);
        log.info("删除成功");
        return "用户删除成功";
    }
    @RequestMapping("/addbook/{bookname}/{booktype}/{author}/{publics}/{booknum}")
    public String addbook(@PathVariable String bookname,@PathVariable String booktype,@PathVariable String author,@PathVariable String publics,@PathVariable int booknum){

    service.insertbook(bookname,booktype,author,publics,booknum);
    log.info("书本添加成功");
    return "书本添加成功";

    }

    @RequestMapping("/deletebook/{bookname}")
    public String deletebook(@PathVariable String bookname){
        service.deletebook(bookname);
        log.info("删除成功");
        return "书本删除成功";
    }
}
