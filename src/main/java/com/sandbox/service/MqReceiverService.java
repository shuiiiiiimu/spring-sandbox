package com.sandbox.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;


/**
 * Created by mike on 2017/2/25.
 */
@Component
public class MqReceiverService implements MessageListener{
    private static final Logger logger = LoggerFactory.getLogger(MqReceiverService.class);

    @Override
    public void onMessage(Message message) {
        // Spring 提供的 SimpleMessageConverter 来将 Message 类转换成对应的业务对象
        logger.info(String.format(">> Received  '%s'", message));
        logger.info(String.format(">> Received body '%s'", message.getBody().toString()));
    }

}

