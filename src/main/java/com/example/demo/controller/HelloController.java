package com.example.demo.controller;

import com.example.demo.annotation.AuthCheck;
import com.example.demo.domain.Auth;
import com.example.demo.domain.ResponseBaseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creat by ZhangXueRong on 2019/6/10
 */
@RestController
public class HelloController {


    @AuthCheck(Auth.NEED_LOGIN)
    @GetMapping("/hello")
    public ResponseBaseDTO hello(){
        ResponseBaseDTO dto = new ResponseBaseDTO();
        dto.setSuccess(true);
        dto.setStatus("100001");
        dto.setDesc("hello");
        return dto;
    }

}
