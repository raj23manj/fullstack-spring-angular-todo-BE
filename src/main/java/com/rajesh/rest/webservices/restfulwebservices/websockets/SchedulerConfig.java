package com.rajesh.rest.webservices.restfulwebservices.websockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

//    @Scheduled(fixedDelay = 3000)
//    public void sendAdhocMessages() {
//    	// push message for 3 sec's
//        template.convertAndSend("/topic/messages", new WebSocketResponse("demo" ,"Fixed Delay Scheduler"));
//    }
}
