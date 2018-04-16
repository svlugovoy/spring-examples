package com.svlugovoy.events;

import org.springframework.context.ApplicationListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent event) {
        MessageEvent msgEvt = (MessageEvent) event;
        String message = msgEvt.getMessage();
        if (message.startsWith("A")){
            System.out.println("***===*** Received: " + message + " " + LocalDate.now());
        } else {
            System.out.println("Received: " + message + " " + LocalDateTime.now());
        }
    }
}
