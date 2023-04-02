package com.project.upbeat.Respons;
import com.project.upbeat.ThisPlayer.Player;
import com.project.upbeat.ThisRegion.Region;
import lombok.Data;
import java.util.*;

@Data
public class GameResponse{
    List<Region> territory;
    Player player1;
    Player player2;
}
