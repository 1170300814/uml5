package com.yanzhao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.yanzhao.uml.user;

@SpringBootTest
class Uml4ApplicationTests {

    @Autowired
    user user;
    @Test
    public void testborrowbook(){
        user.borrowbook("红楼梦","张三");
    }

    @Test
    public void testback(){
        user.borrowbeback("红楼梦","张三");
    }

    @Test
    public void testinfo(){
        user.showborrowedbook("张三");
    }

}
