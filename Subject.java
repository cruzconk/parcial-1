package com.healthcarepro.monitoring;

/**
 * Subject interface of the Observer design pattern.
 *
 * Declares the contract that any "observable" component must fulfil:
 * professionals can subscribe or unsubscribe dynamically at any point in
 * time, and the subject is responsible for notifying every currently
 * subscribed observer whenever a new event occurs.
 */
public interface Subject {

    /**
     * Registers a new observer so that it starts receiving future
     * notifications.
     *
     * @param observer the professional/system that wants to be notified
     */
    void subscribe(MedicalObserver observer);

    /**
     * Removes a previously registered observer. From this point on it will
     * no longer receive notifications, without affecting the rest of the
     * subscribers.
     *
     * @param observer the professional/system that no longer wants to be notified
     */
    void unsubscribe(MedicalObserver observer);

    /**
     * Notifies every currently subscribed observer about a new event.
     *
     * @param event the event to broadcast
     */
    void notifyObservers(MonitoringEvent event);
}
