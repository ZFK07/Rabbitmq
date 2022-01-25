package com.zahid.rabbitmq.rabbitmq.configuration;

import lombok.Getter;


public enum Constraint {
    TOPICEXCHANGENAME("SPRING-BOOT-EXCHANGE"),
    QUEUENAME("SPRING-BOOT");


    final String value;

    Constraint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
