package com.dixn.dxboot;

import com.dixn.dxboot.kafka.KafkaSender;
import lombok.extern.slf4j.Slf4j;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DxbootApplication.class)
@Slf4j
public class DxbootApplicationTests {

    //@Rule
    //public ContiPerfRule i = new ContiPerfRule();

    //@Autowired
    //RedisTemplate redisTemplate;

    //@Autowired
    //JmsTemplate jmsTemplate;

    @Test
    //@PerfTest(invocations = 100000, threads = 100)
    public void contextLoads() {
        //redisTemplate.opsForValue().set("test", "test2");
        //Object o = redisTemplate.opsForValue().get("admin");
       // log.info("redis=================" + o.toString());

        //jmsTemplate.convertAndSend("testTimeToLive", "2222");


    }

    @Autowired
    private KafkaSender sender;
    @Test
    public void aaa(){
        for (int i = 0; i < 1000; i++) {
            //调用消息发送类中的消息发送方法
            sender.send();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
