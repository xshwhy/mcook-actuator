package com.iotmars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xsh
 * @date: 2021/1/28 11:09
 */
@RestController
@RequestMapping("test")
public class TestController {


    @GetMapping
    public String test() {
        //language=JSON
        String str = "{\"name\": \"zhangsan\",\"age\": 12}";

        return "111";
    }





}
