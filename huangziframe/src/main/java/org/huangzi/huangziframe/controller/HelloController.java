package org.huangzi.huangziframe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: XGLLHZ
 * @date: 2019/3/4 22:42
 * @description:
 */
@RestController
@RequestMapping
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello-------------妈了和皮耶！";
    }

    @RequestMapping("/admin/hello")
    public String admin(){
        return "!!!!!-----admin-----!!!!!";
    }

    @RequestMapping("/base/hello")
    public String base(){
        return "!!!!!-----base-----!!!!!";
    }

    @RequestMapping("/user/hello")
    public String user(){
        return "!!!!!-----user-----!!!!!";
    }

}
