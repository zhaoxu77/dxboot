package com.dixn.dxboot;

import com.dixn.dxboot.listener.listener.MyApplicationStartingEventListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description：spring boot application
 * @projectName：dxboot
 * @packageName： com.dixn.dxboot
 * @ClassName：DxbootApplication
 * @author：zhaoxu
 * @createTime：2018/11/19 16:20
 * @upate：zhaoxu
 * @updateDate：2018/11/19 16:20
 * @remark：
 * @version v1.0
 */
@SpringBootApplication
@EnableJms
@EnableScheduling
@MapperScan("com.dixn.dxboot.mybatis.mapper")
@EnableAspectJAutoProxy
public class DxbootApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DxbootApplication.class, args);
        SpringApplication app =new SpringApplication(DxbootApplication.class);
        app.addListeners(new MyApplicationStartingEventListener());//加入自定义的监听类
        app.run(args);
    }
}
