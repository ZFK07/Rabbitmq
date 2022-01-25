package com.zahid.rabbitmq.rabbitmq.controller;

import com.zahid.rabbitmq.rabbitmq.service.RabbitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/")
@Slf4j
public class MainController {

    RabbitService rabbitService;

    @Autowired
    void setRabbitService(RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> message(@RequestBody final String message) throws InterruptedException {
        log.info(RequestMethod.POST + message);
        rabbitService.sendMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
