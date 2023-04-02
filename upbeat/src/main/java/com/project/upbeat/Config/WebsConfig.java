package com.project.upbeat.Config;
import org.springframework.context.annotation.*;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebsConfig implements WebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry reg) {
        reg.addEndpoint("/ws").setAllowedOriginPatterns("*")
                .setHandshakeHandler(new HandShakeHandler())
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry reg) {
        reg.setApplicationDestinationPrefixes("/app");
        reg.enableSimpleBroker("/topic");
        reg.setUserDestinationPrefix("/user");
    }

}
