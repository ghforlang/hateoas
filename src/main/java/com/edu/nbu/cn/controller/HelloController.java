package com.edu.nbu.cn.controller;

import com.edu.nbu.cn.controller.model.TestModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/h")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello")
    public String helloWorld(@RequestParam(value ="name",defaultValue = "world") String name){
        return String.format("Hello %s!",name);
    }

    @GetMapping("/fetchModel")
    @ResponseBody
    public TestModel changeModel(@RequestParam(value ="source",defaultValue = "2") String source){
        if("1".equals(source)){
            TestModel model = new TestModel();
            model.setName("张三");
            model.setId("123");
            return model;
        }
        return null;
    }
}
