package com.dynonuggets.refonteimplicaction.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class WebSocketController {
    @MessageMapping
    @SendTo("/start/initial")
    public String chat(String msg) {
        System.out.println(msg);
        return msg;
    }
}
