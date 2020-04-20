package com.edu.nbu.cn.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Foo {
    /**
     * uuid
     */
    private UUID id;
    /**
     * 姓名
     */
    private String name;
}
