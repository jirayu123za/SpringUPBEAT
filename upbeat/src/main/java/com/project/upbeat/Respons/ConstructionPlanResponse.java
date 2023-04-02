package com.project.upbeat.Respons;
import com.project.upbeat.ThisRegion.Region;
import lombok.Data;
import java.util.*;

@Data
public class ConstructionPlanResponse{
    List<Region> territory;
    long BudgetOfPlayer1;
    long BudgetOfPlayer2;
}
