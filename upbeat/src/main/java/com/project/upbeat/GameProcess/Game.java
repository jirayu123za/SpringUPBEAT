package com.project.upbeat.GameProcess;

import com.project.upbeat.Nodes.*;
import com.project.upbeat.ThisPlayer.*;
import com.project.upbeat.ThisRegion.*;
import java.util.*;

public interface Game {
    List<Region> getTerritory();

    void getConstructionPlan(String constructionPlan);

    Player getPlayer1();
    Player getPlayer2();
    Player getCurrentPlayer();
    Player getWin();

    Region regionOn(Position position);
    Region cityCrewRegion();

    boolean attack(DirectionNode direction, long totalValue);
    boolean collect(long totalValue);
    boolean invest(long totalValue);
    boolean relocate();
    boolean move(DirectionNode direction);

    Map<String, Long> identifiers();
    Map<String, Long> specialIdentifiers();

    long opponent();
    long nearby(DirectionNode direction);
    long budget();
    long getTurn();
}
