package com.healthcarepro.monitoring;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject of the Observer pattern.
 *
 * This class represents the hospital's central monitoring unit. It keeps
 * track of the list of currently subscribed professionals and is
 * responsible for broadcasting every incoming event (coming from the
 * biomedical devices) to all of them.
 *
 * Using a synchronized/thread-safe list (CopyOnWriteArrayList-like safety
 * is not strictly required for this academic exercise) keeps the design
 * simple while still supporting dynamic subscribe/unsubscribe at runtime.
 */
public class PatientMonitoringCentral implements Subject {

    private final List<MedicalObserver> observers = new ArrayList<>();

    @Override
    public void subscribe(MedicalObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("[CENTRAL] " + observer.getObserverName() + " has SUBSCRIBED to the monitoring central.");
        }
    }

    @Override
    public void unsubscribe(MedicalObserver observer) {
        if (observers.remove(observer)) {
            System.out.println("[CENTRAL] " + observer.getObserverName() + " has UNSUBSCRIBED from the monitoring central.");
        }
    }

    @Override
    public void notifyObservers(MonitoringEvent event) {
        System.out.println("\n[CENTRAL] New event registered -> " + event);
        for (MedicalObserver observer : new ArrayList<>(observers)) {
            observer.update(event);
        }
    }

    /**
     * Simulates a biomedical device (or hospital system) reporting a new
     * event to the central unit. This is the single entry point that
     * triggers the whole Observer notification chain.
     *
     * @param event the event captured by the devices/systems
     */
    public void emitEvent(MonitoringEvent event) {
        notifyObservers(event);
    }

    /**
     * @return the current number of subscribed observers (useful for tests/demo).
     */
    public int getSubscriberCount() {
        return observers.size();
    }
}
