package com.example.codeclan.whiskyTracker.controllers;

import com.example.codeclan.whiskyTracker.models.Whisky;
import com.example.codeclan.whiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping("/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        List<Whisky> allWhiskies = whiskyRepository.findAll();
        return new ResponseEntity<>(allWhiskies, HttpStatus.OK);
    }
}
