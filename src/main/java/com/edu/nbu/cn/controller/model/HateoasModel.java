package com.edu.nbu.cn.controller.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@ToString
public class HateoasModel<T> extends RepresentationModel<HateoasModel<T>> {
    /**
     * data
     */
    private T data;

    @JsonCreator
    public HateoasModel(@JsonProperty("data") T data){
        this.data = data;
    }

}
