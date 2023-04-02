package com.project.upbeat.Game;

import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.GameProcess.GameUnit;

import java.util.*;

public class BuildGame{
    private static Game buildGame;
    private static final Map<String, Game> bindings = new HashMap<>();

    public static Game getBuildGame(String nameOfPlayer1, String nameOfPlayer2, String config){
        String buildSearch = nameOfPlayer1 + nameOfPlayer2;
        if(bindings.isEmpty() || !bindings.containsKey(buildSearch)){
            buildGame = GameUnit.createCustom(config, nameOfPlayer1, nameOfPlayer2);
            //buildGame = GameUnit.createGame(nameOfPlayer1, nameOfPlayer2);
            bindings.put(buildSearch, buildGame);
            return buildGame;
        }else{
            return bindings.get(buildSearch);
        }
    }
}
