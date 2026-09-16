package com.healthcarepro.monitoring;

/**
 * Concrete Observer representing the chief bacteriologist (e.g. Marta Gomez).
 *
 * This role must identify which patients require urgent laboratory exams
 * in order to coordinate sample collection with the nursing assistants.
 */
public class Bacteriologist implements MedicalObserver {

    private final String name;

    public Bacteriologist(String name) {
        this.name = name;
    }

    @Override
    public void update(MonitoringEvent event) {
        if (event.getType() == EventType.LAB_REQUEST_URGENT) {
            System.out.println("  -> [BACTERIOLOGIST " + name + "] URGENT LAB REQUEST received. "
                    + "Coordinating sample collection for patient " + event.getPatientName()
                    + ". Detail: " + event.getMessage());
        }
        // Events of other types are not relevant to this role and are ignored.
    }

    @Override
    public String getObserverName() {
        return name + " (Chief Bacteriologist)";
    }
}
