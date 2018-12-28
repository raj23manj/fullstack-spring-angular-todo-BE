package com.rajesh.rest.webservices.restfulwebservices.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	// path where websockets will be created
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
    	// any name is ok
        stompEndpointRegistry.addEndpoint("/testws")
        					 .setAllowedOrigins("*")	
                			 .withSockJS();
    }

    // override default message broker
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // broker via which we will push messages
        registry.setApplicationDestinationPrefixes("/app");
    }
}
