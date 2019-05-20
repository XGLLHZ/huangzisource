package org.huangzi.huangziframe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: XGLLHZ
 * @date: 2019/3/4 22:42
 * @description:
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("真的难受啊！");
        return "难受啊！hello-------------妈了和皮耶！";
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
