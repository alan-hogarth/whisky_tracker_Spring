package com.example.codeclan.whiskyTracker.repositories;

import com.example.codeclan.whiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

}
