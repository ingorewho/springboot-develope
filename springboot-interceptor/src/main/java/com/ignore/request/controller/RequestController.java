package com.ignore.request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 14:48 2018/12/24
 */
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @GetMapping("/test")
    public String reuqest(){
        return "hello world!";
    }
}
