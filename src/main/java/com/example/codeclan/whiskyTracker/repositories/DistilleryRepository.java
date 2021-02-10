package com.example.codeclan.whiskyTracker.repositories;

import com.example.codeclan.whiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
}
