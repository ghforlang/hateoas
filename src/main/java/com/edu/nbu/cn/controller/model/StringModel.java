package com.edu.nbu.cn.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StringModel extends HateoasModel<String> {

    public StringModel(String s){
        super(s);
    }

}
