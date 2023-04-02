package com.project.upbeat.RestAPI;

import com.project.upbeat.Exception.WrongSubmitConstructionPlan;
import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.Management.ManageConstructionPlan;
import com.project.upbeat.Request.ConstructionPlanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/RESTAPI")
public class ConstructionPlanAPI{
    @Autowired
    private SimpMessagingTemplate store;

    @PostMapping("/constructionPlanAPI")
    public ResponseEntity<Object> constructionPlanAPI(@RequestBody ConstructionPlanRequest constructionPlanRequest){
        try{
            if(constructionPlanRequest.getConstructionPlan() == null || constructionPlanRequest.getConstructionPlan().isEmpty()){
                throw new WrongSubmitConstructionPlan("Need least one construction Plan!!");
            }else if(constructionPlanRequest.getIdOfPlayer() == 0){
                throw new WrongSubmitConstructionPlan("Player id is idle");
            }
            Game update = ManageConstructionPlan.SendConstructionPlan(constructionPlanRequest.getConstructionPlan(), constructionPlanRequest.getIdOfPlayer());
            store.convertAndSend("/topic/update", update);
            return ResponseEntity.ok(update);

        }catch(RuntimeException exception){
            throw new WrongSubmitConstructionPlan(exception.getMessage());
        }
    }

    @PostMapping("/constructionPlanAPIMock")
    public ResponseEntity<Object> SendConstructionPlanMock(@RequestBody ConstructionPlanRequest constructionPlanRequest){
        try{
            if(constructionPlanRequest.getConstructionPlan() == null || constructionPlanRequest.getConstructionPlan().isEmpty()){
                throw new WrongSubmitConstructionPlan("Construction plan is idle");
            }else if(constructionPlanRequest.getIdOfPlayer() == 0){
                throw new WrongSubmitConstructionPlan("id of player is idle");
            }
            Game update = ManageConstructionPlan.SendConstructionPlanMock(constructionPlanRequest.getConstructionPlan(), constructionPlanRequest.getIdOfPlayer());
            return ResponseEntity.ok(update);

        }catch(RuntimeException exception){
            throw new WrongSubmitConstructionPlan(exception.getMessage());
        }
    }
}
