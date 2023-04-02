package com.project.upbeat.Handle;

import com.project.upbeat.Exception.WrongRequest;
import com.project.upbeat.Exception.WrongSubmitConstructionPlan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(WrongRequest.class)
    public ResponseEntity<Object> handleWrongRequest(WrongRequest exception){
        Map<String, Object> res = Map.of("msg", exception.getMessage());
        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(WrongSubmitConstructionPlan.class)
    public ResponseEntity<Object> handleWrongRequest(WrongSubmitConstructionPlan exception){
        Map<String, Object> res = Map.of("msg", exception.getMessage());
        return ResponseEntity.badRequest().body(res);
    }
}
