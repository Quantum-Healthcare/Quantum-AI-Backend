package io.github.georgeuwagbale.qauntumai_backend.appointment;

public class AppointmentNotFoundException extends RuntimeException{
    public AppointmentNotFoundException(String id) {
        super("Appointment with id: " + id + " not found");
    }
}
