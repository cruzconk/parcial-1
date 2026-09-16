package com.healthcarepro.monitoring;

/**
 * Observer interface of the Observer design pattern.
 *
 * Every professional (doctor, nursing chief, bacteriologist, or any future
 * role) that needs to react to monitoring events must implement this
 * interface and register itself with the {@link Subject} (the monitoring
 * central) through {@code subscribe()}.
 *
 * Decoupling: the monitoring central does not know the concrete classes of
 * the professionals it notifies; it only knows this contract. New kinds of
 * observers can be added without modifying the central at all (Open/Closed
 * Principle).
 */
public interface MedicalObserver {

    /**
     * Called automatically by the Subject whenever a new event is emitted.
     * Each concrete observer decides internally whether the event is
     * relevant to its role and how to react to it.
     *
     * @param event the event that was just registered by the central
     */
    void update(MonitoringEvent event);

    /**
     * @return a human-readable identifier used for logging/traceability.
     */
    String getObserverName();
}
