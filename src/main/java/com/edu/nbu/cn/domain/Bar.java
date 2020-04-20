package com.edu.nbu.cn.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Bar {
    /**
     * uuid
     */
    private UUID id;
    /**
     * 姓名
     */
    private String name;
    /**
     * foo
     */
    private Foo foo;
}
