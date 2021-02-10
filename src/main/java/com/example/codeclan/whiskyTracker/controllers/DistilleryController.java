package com.example.codeclan.whiskyTracker.controllers;

import com.example.codeclan.whiskyTracker.models.Distillery;
import com.example.codeclan.whiskyTracker.models.Whisky;
import com.example.codeclan.whiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping("/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(
            @RequestParam(name="region", required = false) String region
    ){
        if (region != null) {
        return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        List<Distillery> allDistilleries = distilleryRepository.findAll();
        return new ResponseEntity<>(allDistilleries, HttpStatus.OK);
    }

    @GetMapping(value="/distilleries/{id}")
    public ResponseEntity<Optional<Distillery>> getDistillery(@PathVariable Long id){
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);

    }

    @PostMapping(value="/distilleries")
    public ResponseEntity<Distillery> createShip(@RequestBody Distillery distillery){
        distilleryRepository.save(distillery);
        return new ResponseEntity<>(distillery, HttpStatus.CREATED);

    }
}
