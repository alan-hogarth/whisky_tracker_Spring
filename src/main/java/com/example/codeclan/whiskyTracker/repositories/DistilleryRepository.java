package com.example.codeclan.whiskyTracker.repositories;

import com.example.codeclan.whiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    List<Distillery> findByRegion(String region);
}
