package com.example.codeclan.whiskyTracker.repositories;

import com.example.codeclan.whiskyTracker.models.Distillery;
import com.example.codeclan.whiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByYear(int year);

    List<Whisky> findByDistilleryIdAndAge(Long distilleryId, int age);

    List<Whisky> findByDistilleryRegion(String region);

}
