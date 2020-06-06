package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.stereotype.Service
@Slf4j
public class Service {

    @Value("${queue.name}")
    private String queueName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void postMessage(Message message) {
        log.info("sending message : " + message);
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
