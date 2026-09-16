package com.healthcarepro.monitoring;

/**
 * Concrete Observer representing an intensive care doctor (e.g. Elena Ramos).
 *
 * Doctors need immediate alerts about critical vital signs (oxygen
 * saturation / blood pressure drops) so they can intervene surgically or
 * adjust medication. Other kinds of events are not relevant to this role
 * and are simply ignored.
 */
public class Doctor implements MedicalObserver {

    private final String name;

    public Doctor(String name) {
        this.name = name;
    }

    @Override
    public void update(MonitoringEvent event) {
        if (event.getType() == EventType.VITAL_SIGN_CRITICAL) {
            System.out.println("  -> [DOCTOR " + name + "] CRITICAL ALERT received. "
                    + "Preparing to intervene / adjust medication for patient "
                    + event.getPatientName() + ". Detail: " + event.getMessage());
        }
        // Events of other types are not relevant to this role and are ignored.
    }

    @Override
    public String getObserverName() {
        return "Dr. " + name + " (Intensive Care)";
    }
}
