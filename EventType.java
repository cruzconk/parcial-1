package com.healthcarepro.monitoring;

/**
 * Enumerates the different categories of critical events that can be
 * emitted by the biomedical devices connected to the monitoring central.
 *
 * Each professional role in the hospital is typically interested in only
 * one (or a subset) of these event types, which is exactly the kind of
 * selective notification that the Observer pattern is designed to solve.
 */
public enum EventType {

    /**
     * Severe drop in oxygen saturation or blood pressure.
     * Relevant to: intensive care doctors.
     */
    VITAL_SIGN_CRITICAL,

    /**
     * Change in a patient's care priority (e.g. code blue, code red).
     * Relevant to: nursing chief (shift/bed coordination).
     */
    PRIORITY_CHANGE,

    /**
     * Request for a laboratory exam that requires immediate attention.
     * Relevant to: chief bacteriologist (lab sample coordination).
     */
    LAB_REQUEST_URGENT
}
