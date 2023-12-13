package io.github.georgeuwagbale.qauntumai_backend.appointment;

import io.github.georgeuwagbale.qauntumai_backend.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> getAppointmentsByUser(User user);
}
