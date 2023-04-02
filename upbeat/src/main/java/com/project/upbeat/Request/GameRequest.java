package com.project.upbeat.Request;
import lombok.Data;

@Data
public class GameRequest{
    private ConfigurationRequest config;
    private String nameOfPlayer1;
    private String nameOfPlayer2;
}