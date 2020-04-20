package com.edu.nbu.cn.common;

import com.edu.nbu.cn.controller.BarController;
import com.edu.nbu.cn.controller.FooController;
import com.edu.nbu.cn.domain.Bar;
import com.edu.nbu.cn.domain.BarResource;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilderFactory;

import static com.edu.nbu.cn.entity.FriendlyId.toFriendlyId;

public class BarResourceAssembler extends RepresentationModelAssemblerSupport<Bar,BarResource> {
    public BarResourceAssembler() {
        super(BarController.class, BarResource.class);
    }

    @Override
    public BarResource toModel(Bar entity) {
        BarResource resource = new BarResource(entity.getName());
        WebMvcLinkBuilderFactory factory = new WebMvcLinkBuilderFactory();
        resource.add(factory.linkTo(FooController.class).withRel("foos"));
        resource.add(factory.linkTo(BarController.class, toFriendlyId(entity.getFoo().getId())).slash(toFriendlyId(entity.getId())).withSelfRel());
        return resource;
    }
}
