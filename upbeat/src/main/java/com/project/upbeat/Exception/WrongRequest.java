package com.project.upbeat.Exception;

public class WrongRequest extends RuntimeException{
    public WrongRequest(String msg){
        super(msg);
    }
}
