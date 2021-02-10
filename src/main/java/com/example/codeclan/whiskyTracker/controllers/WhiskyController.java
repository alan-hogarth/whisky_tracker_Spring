package com.example.codeclan.whiskyTracker.controllers;

import com.example.codeclan.whiskyTracker.models.Whisky;
import com.example.codeclan.whiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping("/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name="year", required = false) Integer year,
            @RequestParam(name="distilleryId", required = false) Long distilleryId,
            @RequestParam(name="age", required = false) Integer age
    ){
        if (year != null) {
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        if (distilleryId != null && age != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryIdAndAge(distilleryId, age), HttpStatus.OK);
        }
        List<Whisky> allWhiskies = whiskyRepository.findAll();
        return new ResponseEntity<>(allWhiskies, HttpStatus.OK);
    }

    @GetMapping(value="/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getWhisky(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);

    }

    @PostMapping(value="/whiskies")
    public ResponseEntity<Whisky> createWhisky(@RequestBody Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);

    }
}
