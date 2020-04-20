package com.edu.nbu.cn.common;

import com.edu.nbu.cn.controller.FooController;
import com.edu.nbu.cn.domain.Bar;
import com.edu.nbu.cn.domain.BarResource;
import com.edu.nbu.cn.domain.Foo;
import com.edu.nbu.cn.domain.FooResource;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilderFactory;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.edu.nbu.cn.entity.FriendlyId.toFriendlyId;


public class FooResourceAssembler extends RepresentationModelAssemblerSupport<Foo, FooResource> {

    public FooResourceAssembler() {
        super(FooController.class, FooResource.class);
    }

    @Override
    public FooResource toModel(Foo entity) {
        BarResourceAssembler barResourceAssembler = new BarResourceAssembler();
        List<Bar> bars = Arrays.asList(new Bar(UUID.randomUUID(), "bar one", entity),
                new Bar(UUID.randomUUID(), "bar two", entity));
        CollectionModel<BarResource> barResources = barResourceAssembler.toCollectionModel(bars);
        WebMvcLinkBuilderFactory factory = new WebMvcLinkBuilderFactory();
        FooResource resource = new FooResource(entity.getId(), entity.getName(), barResources);

        resource.add(factory.linkTo(FooController.class).slash(toFriendlyId(entity.getId())).withSelfRel());
        return resource;
    }
}