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

    @GetMapping("/hello")
    public HttpEntity<StringModel> hello(@RequestParam(value = "name",defaultValue = "world") String name){
        String data = String.format("hello %s !",name);
        StringModel sm = new StringModel(data);
        sm.add(linkTo(methodOn(HateoasController.class).hello(name)).withSelfRel());
        return new ResponseEntity<>(sm, HttpStatus.OK);
    }


    @GetMapping("/h")
    public HttpEntity<StringModel> h(){
        StringModel sm = new StringModel("hello sb!");
        sm.add(linkTo(methodOn(HateoasController.class).h()).withSelfRel());
        return new ResponseEntity<>(sm, HttpStatus.OK);
    }
}
