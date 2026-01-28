package com.industrial.healthmanager.repository;

import com.industrial.healthmanager.model.SensorEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorEventRepository extends JpaRepository<SensorEvent, Long> {
}