package com.edu.nbu.cn.common;

import com.edu.nbu.cn.controller.BarController;
import com.edu.nbu.cn.domain.Bar;
import com.edu.nbu.cn.domain.BarResource;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class BarResourceAssembler2 extends RepresentationModelAssemblerSupport<Bar, BarResource> {

    LinkRelationProvider relProvider;

    public BarResourceAssembler2() {
        super(BarController.class, BarResource.class);
    }

    public BarResourceAssembler2(LinkRelationProvider relProvider) {
        super(BarController.class, BarResource.class);
        this.relProvider = relProvider;
    }

    @Override
    public BarResource toModel(Bar entity) {
        return null;
    }
}
