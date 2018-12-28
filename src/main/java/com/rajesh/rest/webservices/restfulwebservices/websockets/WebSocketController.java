package com.rajesh.rest.webservices.restfulwebservices.websockets;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.rest.webservices.restfulwebservices.s3.S3Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Controller
@RestController
@CrossOrigin(origins="http://localhost:4200") 
public class WebSocketController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketController.class);

	
	@Autowired
	S3Services s3Services;
	
	@Autowired
    SimpMessagingTemplate template;
	
//	@MessageMapping("/download-notification-url")
//	@SendTo("/topic/messages") // pushing the messages to broker, under messages
//	public WebSocketResponse getUser() {
//	    return new WebSocketResponse("download-url", (s3Services.getDownloadUrl()).toString());
//	}
	
	@RequestMapping("/download-notification-url")
//	@SendTo("/topic/messages") // pushing the messages to broker, under messages
	@Async
	public void getUser() {
		try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            
        }
		
        template.convertAndSend("/topic/messages", new WebSocketResponse("download-url", (s3Services.getDownloadUrl()).toString()));

		   
	}
}
