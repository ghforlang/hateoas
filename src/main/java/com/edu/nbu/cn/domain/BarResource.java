package com.edu.nbu.cn.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@Setter
@ToString
@Relation(value = "bar",collectionRelation = "bars")
@AllArgsConstructor
public class BarResource extends RepresentationModel<BarResource> {
    /**
     * 名称
     */
    private String name;
}
