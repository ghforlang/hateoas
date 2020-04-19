package com.edu.nbu.cn.controller.param;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoAutoStart
public class BaseParam {
    /**
     * source
     */
    private String source;
}
