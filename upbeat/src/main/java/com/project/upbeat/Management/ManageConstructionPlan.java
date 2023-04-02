package com.project.upbeat.Management;

import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.GameProcess.GameUnit;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class ManageConstructionPlan{
    @Setter
    private static Game game;

    public static Game SendConstructionPlan(String constructionPlan, int idOfPlayer) throws RuntimeException{
        try{
            if(game.getCurrentPlayer().getID() == idOfPlayer){
                String planGame = constructionPlan;
                game.getConstructionPlan(planGame);

                return game;
            }else{
                throw new RuntimeException("Check you turn!!");
            }
        }catch(RuntimeException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    private static Game mock = GameUnit.createGame("player1", "player2");
    public  static  Game SendConstructionPlanMock(String constructionPlan, int idOfPlayer) throws RuntimeException{
        try{
            if(mock.getCurrentPlayer().getID() == idOfPlayer){
                String planGame = constructionPlan;
                mock.getConstructionPlan(planGame);
                return mock;
            }else{
                throw new RuntimeException("Check you turn!!");
            }
        }catch(RuntimeException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
