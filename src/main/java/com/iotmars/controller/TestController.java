package com.iotmars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

      String a = "\"CookbookName\": \"香甜馒头\",\n" +
              "    \"CookbookIntro\": {\n" +
              "      \"Intro\": \"用料：面粉500g，酵母5g，清水275g\\n1/4：酵母融入1/3清水中，搅拌后静至10分钟\",\n" +
              "      \"Materials\": \"2/4：酵母水倒入面粉中，加入清水，用筷子搅拌成絮状\\n3/4：用手揉面至表面光滑，放入箱内38度发酵15分钟，到2倍大，取出揉面排\",\n" +
              "      \"Steps\": \"气，直到切开无大气孔\\n4/4：面团搓成长条状，切成等量馒头状，放入蒸箱醒发一会后启动蒸箱，完成后取出即可食用\"\n" +
              "    },\n" +
              "    \"CookbookParam\": [\n" +
              "      {\n" +
              "        \"Valid\": 1,\n" +
              "        \"Paused\": 0,\n" +
              "        \"RemindText\": \"\",\n" +
              "        \"Mode\": 1,\n" +
              "        \"Temp\": 100,\n" +
              "        \"Timer\": 20,\n" +
              "        \"SteamTime\": 0,\n" +
              "        \"FanTime\": 0,\n" +
              "        \"WaterTime\": 0\n" +
              "      },\n" +
              "      {\n" +
              "        \"Valid\": 1,\n" +
              "        \"Paused\": 0,\n" +
              "        \"RemindText\": \"\",\n" +
              "        \"Mode\": 71,\n" +
              "        \"Temp\": 0,\n" +
              "        \"Timer\": 5,\n" +
              "        \"SteamTime\": 0,\n" +
              "        \"FanTime\": 0,\n" +
              "        \"WaterTime\": 0\n" +
              "      }\n" +
              "    ]\n" +
              "}";





        return "111";
    }



    private static int a = 0;

    @PostMapping
    public Integer test01() {
       a++;
       if (a > 2) {
           a = 0;
       }
        return a;
    }








}
