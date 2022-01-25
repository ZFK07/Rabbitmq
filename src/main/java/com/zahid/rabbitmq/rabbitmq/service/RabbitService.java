package com.zahid.rabbitmq.rabbitmq.service;

import com.zahid.rabbitmq.rabbitmq.configuration.Constraint;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class RabbitService {
    RabbitTemplate rabbitTemplate;
    Receiver receiver;

    public void sendMessage(final String message) throws InterruptedException {
        rabbitTemplate.convertAndSend(Constraint.TOPICEXCHANGENAME.getValue(), "foo.bar.baz", message);
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
