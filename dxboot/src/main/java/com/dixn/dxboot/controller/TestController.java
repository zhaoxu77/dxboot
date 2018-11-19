package com.dixn.dxboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-11-19 18:14
 **/
@RestController
@RequestMapping("/test")
@Slf4j
@Api(tags="用户API")
public class TestController {

    @GetMapping(value = "/index/{id}/{name}")
    @ApiOperation(value="用户查询(ID)")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="查询ID",required=true),
            @ApiImplicitParam(name="name",value="查询name",required=true)})
    public String index(@PathVariable("id") String id, @PathVariable("name") String name) {
        return name;
    }
}
