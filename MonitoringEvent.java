package com.healthcarepro.monitoring;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single event registered by the central monitoring system.
 *
 * This is the payload that travels from the {@link Subject} (the
 * monitoring central) to every subscribed {@link MedicalObserver}.
 * It is an immutable data holder (a simple "event" / DTO class).
 */
public class MonitoringEvent {

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    private final String patientId;
    private final String patientName;
    private final EventType type;
    private final String message;
    private final LocalDateTime timestamp;

    public MonitoringEvent(String patientId, String patientName, EventType type, String message) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.type = type;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public EventType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] (%s) Patient %s (%s): %s",
                timestamp.format(TIME_FORMAT), type, patientName, patientId, message);
    }
}
