package com.industrial.healthmanager.service;

import com.industrial.healthmanager.model.SensorEvent;
import com.industrial.healthmanager.model.Severity;
import com.industrial.healthmanager.repository.SensorEventRepository;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SensorSimulatorService {

    private final SensorEventRepository repository;
    private final ScheduledExecutorService executor;
    private final Random random;

    public SensorSimulatorService(SensorEventRepository repository) {
        this.repository = repository;
        this.executor = Executors.newScheduledThreadPool(2);
        this.random = new Random();
    }

    @PostConstruct
    public void startSimulation() {
        executor.scheduleAtFixedRate(this::simulateTemperature, 0, 5, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(this::simulateVibration, 0, 5, TimeUnit.SECONDS);
        System.out.println("✅ Simulação de sensores iniciada!");
    }

    private void simulateTemperature() {
        double temp = 60 + (random.nextDouble() * 40);
        Severity severity = calculateTemperatureSeverity(temp);
        
        if (severity == Severity.ERROR) {
            SensorEvent event = new SensorEvent("Prensa 01", "Temperatura", temp, severity);
            repository.save(event);
            System.out.println("🚨 CRÍTICO - Temperatura: " + String.format("%.2f", temp) + "°C");
        }
    }

    private void simulateVibration() {
        double vibration = random.nextDouble() * 15;
        Severity severity = calculateVibrationSeverity(vibration);
        
        if (severity == Severity.ERROR) {
            SensorEvent event = new SensorEvent("Prensa 01", "Vibração", vibration, severity);
            repository.save(event);
            System.out.println("🚨 CRÍTICO - Vibração: " + String.format("%.2f", vibration) + "mm/s");
        }
    }

    private Severity calculateTemperatureSeverity(double temp) {
        if (temp > 85) return Severity.ERROR;
        if (temp > 75) return Severity.WARNING;
        return Severity.INFO;
    }

    private Severity calculateVibrationSeverity(double vibration) {
        if (vibration > 10) return Severity.ERROR;
        if (vibration > 5) return Severity.WARNING;
        return Severity.INFO;
    }
}