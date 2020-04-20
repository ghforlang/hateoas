package com.edu.nbu.cn.controller;

import com.edu.nbu.cn.controller.model.StringModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/hateoas")
public class HateoasController {

    /**
     * 参考结果:
     * {
     *     "data":"hello world !",
     *     "_links":{
     *         "self":{
     *             "href":"http://localhost:8080/hateoas/hello?name=myself"
     *         },
     *         "helloSB":{
     *             "href":"http://localhost:8080/hateoas/h"
     *         }
     *     }
     * }
     * @param name
     * @return
     */
    @GetMapping("/hello")
    public HttpEntity<StringModel> hello(@RequestParam(value = "name",defaultValue = "world") String name){
        String data = String.format("hello %s !",name);
        StringModel sm = new StringModel(data);
        sm.add(linkTo(methodOn(HateoasController.class).hello("myself")).withSelfRel());
        sm.add(linkTo(methodOn(HateoasController.class).h()).withRel("helloSB"));
        return new ResponseEntity<>(sm, HttpStatus.OK);
    }


    /**
     * 参考结果:
     * {
     *     "data":"hello sb!",
     *     "_links":{
     *         "self":{
     *             "href":"http://localhost:8080/hateoas/h"
     *         }
     *     }
     * }
     * @return
     */
    @GetMapping("/h")
    public HttpEntity<StringModel> h(){
        StringModel sm = new StringModel("hello sb!");
        sm.add(linkTo(methodOn(HateoasController.class).h()).withSelfRel());
        return new ResponseEntity<>(sm, HttpStatus.OK);
    }
}
