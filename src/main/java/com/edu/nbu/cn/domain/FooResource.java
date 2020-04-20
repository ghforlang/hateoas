package com.edu.nbu.cn.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Value;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.UUID;

@Relation(value = "foos")
@Value
public class FooResource extends RepresentationModel<FooResource> {
    /**
     * uuid
     */
    private final UUID id;
    /**
     * 名称
     */
    private final String name;
    /**
     * embeddeds
     */
    @JsonUnwrapped
    private final CollectionModel<BarResource> embeddeds;
}
