package com.project.upbeat.Config;
import com.sun.security.auth.UserPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;
import java.util.logging.*;

public class HandShakeHandler extends DefaultHandshakeHandler{
    private final Logger log = Logger.getLogger(HandShakeHandler.class.getName());

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        final String playerID = UUID.randomUUID().toString();
        log.info("User connected: " + playerID);
        return new UserPrincipal(playerID);
    }
}
