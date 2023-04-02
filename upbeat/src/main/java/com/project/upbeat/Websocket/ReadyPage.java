package com.project.upbeat.Websocket;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;
import com.project.upbeat.Request.*;
import com.project.upbeat.Respons.*;
import lombok.Data;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;


@RestController
@MessageMapping("/ReadyPage")
public class ReadyPage{
    private String name_Player1, name_Player2  = "";
    private final PlayerResponse[] playerBox = new PlayerResponse[2];
    private ConfigurationRequest config;
    private int connectPlayer = 0;
    private int editPlayer = 0;

    @Autowired
    private SimpMessagingTemplate store;

    @MessageMapping("/name")
    @SendTo("/topic/name")
    public namePlayerResponse Name(@RequestBody namePlayerRequest namePlayerReq){
        namePlayerResponse namePlayerRes = new namePlayerResponse();
        namePlayerRes.setName_Player1(namePlayerReq.getName_Player1());
        namePlayerRes.setName_Player2(namePlayerReq.getName_Player2());
        this.name_Player1 = namePlayerReq.getName_Player1();
        this.name_Player2 = namePlayerReq.getName_Player2();
        return namePlayerRes;
    }

    @MessageMapping("/start")
    @SendTo("/topic/start")
    public boolean start() {
        name_Player1 = "";
        name_Player2 = "";
        config = null;
        return true;
    }

    @SubscribeMapping("/entry")
    public namePlayerEntry entry() {
        namePlayerEntry entryRes = new namePlayerEntry();
        entryRes.setName_Player1(name_Player1);
        entryRes.setName_Player2(name_Player2);
        if(config != null){
            entryRes.setConfiguration(config);
        }
        return entryRes;
    }

    @MessageMapping("/update")
    @SendTo("/topic/update")
    public ConfigurationRequest Update(@RequestBody ConfigurationRequest update) {
        this.config = update;
        return update;
    }

    @MessageMapping("/lock")
    public void playerBox(final Principal principal) {
        store.convertAndSendToUser(principal.getName(), "/topic/playerBox", playerBox[editPlayer]);
    }

    private void selectSlot(Principal principal) {
        if (playerBox[0] == null) {
            playerBox[0] = new PlayerResponse();
            playerBox[0].setPlayerSlot(1);
            playerBox[0].setPlayerId(principal.getName());
            editPlayer = 0;
        } else if (playerBox[1] == null) {
            playerBox[1] = new PlayerResponse();
            playerBox[1].setPlayerSlot(2);
            playerBox[1].setPlayerId(principal.getName());
            editPlayer = 1;
        }
    }

    private void removeSlot(Principal principal) {
        if (playerBox[0] != null && playerBox[0].getPlayerId().equals(principal.getName())) {
            playerBox[0] = null;
        } else if (playerBox[1] != null && playerBox[1].getPlayerId().equals(principal.getName())) {
            playerBox[1] = null;
        }
    }

    @EventListener(SessionConnectedEvent.class)
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        connectPlayer++;
        selectSlot(event.getUser());
        System.out.println("Connected players...... " + connectPlayer);
    }

    @EventListener(SessionDisconnectEvent.class)
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        connectPlayer--;
        removeSlot(event.getUser());
        System.out.println("Connected players...... " + connectPlayer);
    }

}


@Data
class namePlayerResponse{
    private String name_Player1;
    private String name_Player2;
}

@Data
class namePlayerRequest{
    private String name_Player1;
    private String name_Player2;
}

@Data
class namePlayerEntry{
    private String name_Player1;
    private String name_Player2;
    private ConfigurationRequest configuration;
}

