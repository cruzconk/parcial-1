package com.healthcarepro.monitoring;

/**
 * Demo / entry point.
 *
 * Simulates the real-time critical patient monitoring scenario described
 * by HealthCare Pro:
 *   1. The three professionals subscribe to the monitoring central.
 *   2. Several critical events are emitted by the (simulated) biomedical
 *      devices, and only the relevant professional(s) react to each one.
 *   3. One professional dynamically unsubscribes.
 *   4. A new event of that same type is emitted again, proving that the
 *      unsubscribed observer no longer receives notifications while the
 *      rest of the system keeps working normally.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Create the central monitoring unit (the Subject).
        PatientMonitoringCentral central = new PatientMonitoringCentral();

        // 2. Create the concrete observers (the professionals).
        Doctor elena = new Doctor("Elena Ramos");
        NursingChief andres = new NursingChief("Andres Suarez");
        Bacteriologist marta = new Bacteriologist("Marta Gomez");

        // 3. Dynamic subscription to the central.
        System.out.println("===== SUBSCRIPTION PHASE =====");
        central.subscribe(elena);
        central.subscribe(andres);
        central.subscribe(marta);
        System.out.println("Total active subscribers: " + central.getSubscriberCount());

        // 4. Simulate events coming from the biomedical devices.
        System.out.println("\n===== EVENT SIMULATION PHASE =====");

        central.emitEvent(new MonitoringEvent(
                "P-1001", "Carlos Mendoza", EventType.VITAL_SIGN_CRITICAL,
                "Oxygen saturation dropped to 82%."));

        central.emitEvent(new MonitoringEvent(
                "P-1002", "Laura Jimenez", EventType.PRIORITY_CHANGE,
                "Patient escalated to CODE RED."));

        central.emitEvent(new MonitoringEvent(
                "P-1003", "Ricardo Paez", EventType.LAB_REQUEST_URGENT,
                "Urgent blood culture requested."));

        // 5. Dynamic unsubscription: the nursing chief goes off duty.
        System.out.println("\n===== UNSUBSCRIPTION PHASE =====");
        central.unsubscribe(andres);
        System.out.println("Total active subscribers: " + central.getSubscriberCount());

        // 6. A new priority-change event occurs: Andres will NOT be notified anymore,
        //    but Elena and Marta keep working normally for their own event types.
        System.out.println("\n===== EVENT SIMULATION AFTER UNSUBSCRIPTION =====");

        central.emitEvent(new MonitoringEvent(
                "P-1004", "Sofia Torres", EventType.PRIORITY_CHANGE,
                "Patient escalated to CODE BLUE."));

        central.emitEvent(new MonitoringEvent(
                "P-1005", "Manuel Rios", EventType.VITAL_SIGN_CRITICAL,
                "Blood pressure critically low (70/40)."));

        System.out.println("\n===== END OF SIMULATION =====");
    }
}
