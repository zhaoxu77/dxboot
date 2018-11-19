package com.dixn.dxboot.controller;

import com.dixn.dxboot.quartz.Timer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

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

    /**
     * 注入任务调度器
     */
    @Autowired
    private Scheduler scheduler;

    @GetMapping(value = "/index/{id}/{name}")
    @ApiOperation(value="用户查询(ID)")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="查询ID",required=true),
            @ApiImplicitParam(name="name",value="查询name",required=true)})
    public String index(@PathVariable("id") String id, @PathVariable("name") String name) {
        return name;
    }


    @GetMapping(value = "/timer")
    @ApiOperation(value="timer")
    public String timer(){
        //设置开始时间为1分钟后
        long startAtTime = System.currentTimeMillis() + 1000 * 60;
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = Timer.class.getName();
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(Timer.class).withIdentity(name, group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).startAt(new Date(startAtTime)).build();
        //将触发器与任务绑定到调度器内
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
