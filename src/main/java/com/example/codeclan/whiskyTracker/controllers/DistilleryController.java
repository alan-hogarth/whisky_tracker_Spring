package com.example.codeclan.whiskyTracker.controllers;

import com.example.codeclan.whiskyTracker.models.Distillery;
import com.example.codeclan.whiskyTracker.models.Whisky;
import com.example.codeclan.whiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping("/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(){
        List<Distillery> allDistilleries = distilleryRepository.findAll();
        return new ResponseEntity<>(allDistilleries, HttpStatus.OK);
    }
}
