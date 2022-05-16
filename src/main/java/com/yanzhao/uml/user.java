package com.yanzhao.uml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 这个类应该保存用户的操作
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class user {
    @Autowired
    showinfo showinfo;

    public void borrowbook(String bookid){


    }

    public void showborrowedbook(String username){
        System.out.println(showinfo.showborrowedbook(username));
    }
}
