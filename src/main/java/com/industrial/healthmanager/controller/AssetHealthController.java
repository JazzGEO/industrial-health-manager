package com.industrial.healthmanager.controller;

import com.industrial.healthmanager.model.SensorEvent;
import com.industrial.healthmanager.repository.SensorEventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AssetHealthController {

    private final SensorEventRepository repository;

    public AssetHealthController(SensorEventRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/assets/health")
    public List<SensorEvent> getAssetHealth() {
        return repository.findAll();
    }
}