package com.healthcarepro.monitoring;

/**
 * Concrete Observer representing the nursing chief (e.g. Andres Suarez).
 *
 * The nursing chief needs to know about changes in a patient's care
 * priority (code blue, code red) in order to coordinate shifts and beds
 * on the floor.
 */
public class NursingChief implements MedicalObserver {

    private final String name;

    public NursingChief(String name) {
        this.name = name;
    }

    @Override
    public void update(MonitoringEvent event) {
        if (event.getType() == EventType.PRIORITY_CHANGE) {
            System.out.println("  -> [NURSING CHIEF " + name + "] PRIORITY CHANGE received. "
                    + "Coordinating shifts/beds for patient " + event.getPatientName()
                    + ". Detail: " + event.getMessage());
        }
        // Events of other types are not relevant to this role and are ignored.
    }

    @Override
    public String getObserverName() {
        return name + " (Nursing Chief)";
    }
}
