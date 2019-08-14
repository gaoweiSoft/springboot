package com.ob.amqp.mqconfig.directexchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: oubin
 * @Date: 2019/8/13 14:54
 * @Description:
 */
@Slf4j
@Component
@RabbitListener(queues = "q_direct_A")
public class DirectConsumer1 {

    @RabbitHandler
    public void process(String msg) {
        log.info("direct_consumerA : {}", msg);
    }
}
