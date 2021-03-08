package com.iotmars;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iotmars.menu.Cookbook;
import com.iotmars.menu.CookbookIntro;
import com.iotmars.menu.CookbookParam;
import com.iotmars.menu.LivingCookbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: xsh
 * @date: 2021/1/30 10:50
 */
@DisplayName("测试String")
public class StringTest {


    @Test
    void  test01() {
        String a = "a";
        String b = "a";
        System.out.println(a==b);

        Integer c = 128;
        Integer d = 128;
        System.out.println( c == d);

    }

    @Test
    void test02() {
        /*Object o = "\"CookbookName\": \"香甜馒头\",\n" +
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
                "    ],\n" +
                "    \"MultiMode\":2,\n" +
                "    \"StOvOperation\":0";
        Object o1 = JSON.toJSON(o);
        System.out.println(o1);
*/

        String str = "{\"CookbookParam\":[{\"FanTime\":3,\"RemindText\":\"\",\"Temp\":180,\"Timer\":30,\"Valid\":1,\"SteamTime\":0,\"Mode\":39,\"WaterTime\":3,\"Paused\":0}," +
                "{\"FanTime\":0,\"RemindText\":\"\",\"Temp\":180,\"Timer\":5,\"Valid\":1,\"SteamTime\":0,\"Mode\":34,\"WaterTime\":0,\"Paused\":0}]," +
                "\"CookbookName\":\"烤羊排\"," +
                "\"CookbookIntro\":{\"Steps\":\"2/3：羊排取出，晾干水份，去除杂料 ，放入垫好锡纸的烤盘\n3/3烤箱预热后放入羊排，完成后撒上辣椒粉即可食用\"," +
                "\"Intro\":\"用料：羊排（条状）800g，红酒10g，蜂蜜5g，生抽5g，蚝油2g，胡椒粉5g，孜然粉5g，盐3g，葱姜蒜适量，洋葱半个，\"," +
                "\"Materials\":\"尖椒1个，芹菜1根，辣椒粉少许\n1/3：将羊排用红酒、胡椒粉、葱姜蒜、孜然粉、芹菜、尖椒、洋 葱、生抽、蚝油、蜂蜜腌制半小时以上\n\"}," +
                "\"MultiMode\":2,\"StOvOperation\":0}";



        Map map = JSON.parseObject(str, Map.class);

        System.out.println(map);


    }

    @Test
    void test03() {
        String a = "a" + "__menu__" + 1;
        Integer b = null;

        if (a.split("__").length >= 3) {
            b = Integer.parseInt(a.split("__")[2]);
        }
        System.out.println(b);
    }

    @DisplayName("测试字符串切分")
    @Test
    void test04() {
        String a = "Q6;E5";

        List<String> collect = Stream.of(a.split(";")).collect(Collectors.toList());

        System.out.println(collect);
    }

    @DisplayName("测试字符串切分")
    @Test
    void test05() {

        String a = "{\n" +
                "    \"status\": 200,\n" +
                "    \"msg\": \"data is exist\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"CookbookName\": \"泰式火山排骨\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 1,\n" +
                "                    \"RemindText\": \"线椒放到肋排上启动\",\n" +
                "                    \"Mode\": 2,\n" +
                "                    \"Temp\": 120,\n" +
                "                    \"Timer\": 30,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 83\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"三味鸡排\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 5,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 102\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"巴斯克芝士蛋糕\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 38,\n" +
                "                    \"Temp\": 220,\n" +
                "                    \"Timer\": 25,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 5,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 103\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"蒜蓉粉丝娃娃菜\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 2,\n" +
                "                    \"Temp\": 120,\n" +
                "                    \"Timer\": 8,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 117\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"香菇酿肉\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 118\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"肉末冬瓜\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 12,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 426\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"桂花蜂蜜烤南瓜\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 38,\n" +
                "                    \"Temp\": 200,\n" +
                "                    \"Timer\": 20,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 427\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"烤羊排\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 39,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 30,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 3\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 34,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 5,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 560\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"蜜烤鸡翅\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 160,\n" +
                "                    \"Timer\": 20,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 566\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"五谷丰登\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 25,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 636\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"什锦烧烤\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 38,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 9,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 170,\n" +
                "                    \"Timer\": 3,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 637\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"鸡蛋羹\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 638\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"豆豉蒸排骨\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 2,\n" +
                "                    \"Temp\": 120,\n" +
                "                    \"Timer\": 20,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 643\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"烤牛排\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 34,\n" +
                "                    \"Temp\": 230,\n" +
                "                    \"Timer\": 6,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 644\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"芝士焗牛肉\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 38,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 34,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 5,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 649\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"清蒸鲈鱼\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 2,\n" +
                "                    \"Temp\": 120,\n" +
                "                    \"Timer\": 10,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 651\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"蒜蓉粉丝扇贝\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 3,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 652\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"蒜蓉粉丝虾\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 2,\n" +
                "                    \"Temp\": 120,\n" +
                "                    \"Timer\": 8,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 653\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"香甜馒头\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 20,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 71,\n" +
                "                    \"Temp\": 0,\n" +
                "                    \"Timer\": 5,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 654\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"香菇肉包\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 25,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 71,\n" +
                "                    \"Temp\": 0,\n" +
                "                    \"Timer\": 5,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 655\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"柳叶蒸饺\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 20,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 656\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"速冻面食\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 30,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 657\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"清蒸大闸蟹\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 2,\n" +
                "                    \"Temp\": 120,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 658\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"剁椒鱼头\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 2,\n" +
                "                    \"Temp\": 120,\n" +
                "                    \"Timer\": 25,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 662\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"糯米红枣\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 668\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"胡萝卜果干吐司\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 45,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 675\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"月饼\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 1,\n" +
                "                    \"RemindText\": \"上表面刷上蛋液\",\n" +
                "                    \"Mode\": 37,\n" +
                "                    \"Temp\": 200,\n" +
                "                    \"Timer\": 4,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 37,\n" +
                "                    \"Temp\": 200,\n" +
                "                    \"Timer\": 9,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 676\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"烤鱼\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 200,\n" +
                "                    \"Timer\": 20,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 34,\n" +
                "                    \"Temp\": 220,\n" +
                "                    \"Timer\": 10,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 677\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"戚风蛋糕\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 33,\n" +
                "                    \"Temp\": 160,\n" +
                "                    \"Timer\": 35,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 691\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"葡式蛋挞\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 33,\n" +
                "                    \"Temp\": 200,\n" +
                "                    \"Timer\": 25,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 701\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"蔓越莓曲奇饼干\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 170,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 704\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"巧克力马芬\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 175,\n" +
                "                    \"Timer\": 25,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 983\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"腊肉蒸芋艿\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 18,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 997\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"烤豆腐\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 200,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 998\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"叉烧烤仔排\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 33,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 20,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 999\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"叉烧肉\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 1,\n" +
                "                    \"RemindText\": \"刷一层蜂蜜\",\n" +
                "                    \"Mode\": 38,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 20,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 38,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 5,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1000\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"烤花蛤\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 10,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1001\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"芝士焗生蚝\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 34,\n" +
                "                    \"Temp\": 160,\n" +
                "                    \"Timer\": 12,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1002\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"烤秋刀鱼\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 180,\n" +
                "                    \"Timer\": 12,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1003\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"肉末山药\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 2,\n" +
                "                    \"Temp\": 120,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1006\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"糯米点心\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 12,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1034\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"红薯布丁\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 39,\n" +
                "                    \"Temp\": 105,\n" +
                "                    \"Timer\": 40,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 1\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1036\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"烤鸡\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 39,\n" +
                "                    \"Temp\": 200,\n" +
                "                    \"Timer\": 30,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 3\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 200,\n" +
                "                    \"Timer\": 10,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1050\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"测试123\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 35,\n" +
                "                    \"Timer\": 1,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 1,\n" +
                "                    \"RemindText\": \"4222222222\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 35,\n" +
                "                    \"Timer\": 1,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1236\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"test\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 1,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 36,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 5,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1238\n" +
                "        },\n" +
                "        {\n" +
                "            \"CookbookName\": \"55\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 1,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 35,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 5,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 1244\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        JSONObject jsonObject = JSONObject.parseObject(a);
        String data = jsonObject.getString("data");
        List<Cookbook> cookbooks = JSONArray.parseArray(data, Cookbook.class);
        System.out.println(cookbooks);
    }

    @DisplayName("测试拼接")
    @Test
    void testo6() {
        /*String a = " {\n" +
                "            \"CookbookName\": \"泰式火山排骨\",\n" +
                "            \"CookbookIntro\": {\n" +
                "                \"Intro\": \"\",\n" +
                "                \"Materials\": \"\",\n" +
                "                \"Steps\": \"\"\n" +
                "            },\n" +
                "            \"CookbookParam\": [\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 1,\n" +
                "                    \"RemindText\": \"线椒放到肋排上启动\",\n" +
                "                    \"Mode\": 2,\n" +
                "                    \"Temp\": 120,\n" +
                "                    \"Timer\": 30,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Valid\": 1,\n" +
                "                    \"Paused\": 0,\n" +
                "                    \"RemindText\": \"\",\n" +
                "                    \"Mode\": 1,\n" +
                "                    \"Temp\": 100,\n" +
                "                    \"Timer\": 15,\n" +
                "                    \"SteamTime\": 0,\n" +
                "                    \"FanTime\": 0,\n" +
                "                    \"WaterTime\": 0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CookbookId\": 83\n" +
                "        }";*/


        String url = "http://mcook.dev.marssenger.net/menu-anon/findDuerosMenuSceneList";
        HashMap<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("deviceType", "Q6");
        String cookbookJson = HttpUtil.get(url, paramMap);
        JSONObject jsonObject = JSONObject.parseObject(cookbookJson);
        String data = jsonObject.getString("data");
        List<Cookbook> cookbooks = JSONArray.parseArray(data, Cookbook.class);




        System.out.println(cookbooks);
    }

    @Test
    void test07() {
        String a = "[Cookbook(cookbookId=652, cookbookName=蒜蓉粉丝扇贝, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=3, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=638, cookbookName=鸡蛋羹, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=15, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=102, cookbookName=三味鸡排, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=15, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=180, timer=5, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=654, cookbookName=香甜馒头, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=20, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=71, temp=0, timer=5, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=675, cookbookName=胡萝卜果干吐司, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=180, timer=45, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=676, cookbookName=月饼, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=1, remindText=上表面刷上蛋液, mode=37, temp=200, timer=4, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=37, temp=200, timer=9, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1001, cookbookName=烤花蛤, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=180, timer=10, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=566, cookbookName=蜜烤鸡翅, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=160, timer=20, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=657, cookbookName=速冻面食, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=30, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=662, cookbookName=剁椒鱼头, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=2, temp=120, timer=25, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=704, cookbookName=蔓越莓曲奇饼干, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=170, timer=15, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1050, cookbookName=烤鸡, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=39, temp=200, timer=30, steamTime=0, fanTime=0, waterTime=3), CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=200, timer=10, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=83, cookbookName=泰式火山排骨, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=1, remindText=线椒放到肋排上启动, mode=2, temp=120, timer=30, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=15, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=655, cookbookName=香菇肉包, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=25, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=71, temp=0, timer=5, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1000, cookbookName=叉烧肉, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=1, remindText=刷一层蜂蜜, mode=38, temp=180, timer=20, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=38, temp=180, timer=5, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=643, cookbookName=豆豉蒸排骨, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=2, temp=120, timer=20, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1006, cookbookName=肉末山药, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=2, temp=120, timer=15, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=997, cookbookName=腊肉蒸芋艿, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=18, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=658, cookbookName=清蒸大闸蟹, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=2, temp=120, timer=15, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=998, cookbookName=烤豆腐, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=200, timer=15, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1034, cookbookName=糯米点心, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=12, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=637, cookbookName=什锦烧烤, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=38, temp=180, timer=9, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=170, timer=3, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=653, cookbookName=蒜蓉粉丝虾, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=2, temp=120, timer=8, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=983, cookbookName=巧克力马芬, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=175, timer=25, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=668, cookbookName=糯米红枣, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=15, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=999, cookbookName=叉烧烤仔排, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=33, temp=180, timer=20, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1003, cookbookName=烤秋刀鱼, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=180, timer=12, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1036, cookbookName=红薯布丁, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=39, temp=105, timer=40, steamTime=0, fanTime=0, waterTime=1)]), Cookbook(cookbookId=118, cookbookName=香菇酿肉, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=15, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1238, cookbookName=test, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=1, remindText=, mode=36, temp=100, timer=5, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=677, cookbookName=烤鱼, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=200, timer=20, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=34, temp=220, timer=10, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1002, cookbookName=芝士焗生蚝, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=34, temp=160, timer=12, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=560, cookbookName=烤羊排, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=39, temp=180, timer=30, steamTime=0, fanTime=0, waterTime=3), CookbookParam(valid=1, paused=0, remindText=, mode=34, temp=180, timer=5, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=117, cookbookName=蒜蓉粉丝娃娃菜, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=2, temp=120, timer=8, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=691, cookbookName=戚风蛋糕, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=33, temp=160, timer=35, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=649, cookbookName=芝士焗牛肉, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=38, temp=180, timer=15, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=34, temp=180, timer=5, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=103, cookbookName=巴斯克芝士蛋糕, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=38, temp=220, timer=25, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=0, remindText=, mode=36, temp=180, timer=5, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1236, cookbookName=测试123, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=35, timer=1, steamTime=0, fanTime=0, waterTime=0), CookbookParam(valid=1, paused=1, remindText=4222222222, mode=1, temp=35, timer=1, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=656, cookbookName=柳叶蒸饺, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=20, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=1244, cookbookName=55, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=1, remindText=, mode=35, temp=100, timer=5, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=651, cookbookName=清蒸鲈鱼, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=2, temp=120, timer=10, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=644, cookbookName=烤牛排, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=34, temp=230, timer=6, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=427, cookbookName=桂花蜂蜜烤南瓜, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=38, temp=200, timer=20, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=636, cookbookName=五谷丰登, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=25, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=701, cookbookName=葡式蛋挞, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=33, temp=200, timer=25, steamTime=0, fanTime=0, waterTime=0)]), Cookbook(cookbookId=426, cookbookName=肉末冬瓜, cookbookIntro=CookbookIntro(intro=, materials=, steps=), cookbookParam=[CookbookParam(valid=1, paused=0, remindText=, mode=1, temp=100, timer=12, steamTime=0, fanTime=0, waterTime=0)])]";
    }

    @DisplayName("copy")
    @Test
    void test08() {
        ArrayList<CookbookParam> list = new ArrayList<>();
        CookbookParam cookbookParam1 = new CookbookParam().setFanTime(1).setMode(1).setPaused(1).setRemindText("1").setSteamTime(1).setTemp(1).setTimer(1).setValid(1).setWaterTime(1);
        CookbookParam cookbookParam2 = new CookbookParam().setFanTime(1).setMode(1).setPaused(1).setRemindText("1").setSteamTime(1).setTemp(1).setTimer(1).setValid(1).setWaterTime(1);
        list.add(cookbookParam1);
        list.add(cookbookParam2);
        Cookbook cookbook = new Cookbook().setCookbookId(1).setCookbookIntro(new CookbookIntro()).setCookbookName("111").setCookbookParam(list);
        System.out.println(cookbook);
        LivingCookbook livingCookbook = new LivingCookbook().setMultiMode(2).setStOvOperation(0);
        /*livingCookbook.setCookbookId(cookbook.getCookbookId()).setCookbookName(cookbook.getCookbookName()).setCookbookIntro(cookbook.getCookbookIntro())
                .setCookbookParam(cookbook.getCookbookParam());*/
        BeanUtils.copyProperties(cookbook,livingCookbook);
        System.out.println(livingCookbook);



    }


}
