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
}
