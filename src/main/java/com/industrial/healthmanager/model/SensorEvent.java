package com.industrial.healthmanager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_events")
public class SensorEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_name", nullable = false)
    private String assetName;

    @Column(name = "sensor_type", nullable = false)
    private String sensorType;

    @Column(name = "reading_value", nullable = false)
    private Double readingValue;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    public SensorEvent() {
    }

    public SensorEvent(String assetName, String sensorType, Double readingValue, Severity severity) {
        this.assetName = assetName;
        this.sensorType = sensorType;
        this.readingValue = readingValue;
        this.severity = severity;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Double getReadingValue() {
        return readingValue;
    }

    public void setReadingValue(Double readingValue) {
        this.readingValue = readingValue;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }
}