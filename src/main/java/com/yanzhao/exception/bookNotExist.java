package com.yanzhao.exception;

import org.springframework.stereotype.Service;

@Service
public class bookNotExist extends Exception{
    public bookNotExist(){
        super();
    }
    public bookNotExist(String msg){
        super(msg);
    }
}
