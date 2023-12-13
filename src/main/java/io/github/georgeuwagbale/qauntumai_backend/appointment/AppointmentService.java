package io.github.georgeuwagbale.qauntumai_backend.appointment;

import io.github.georgeuwagbale.qauntumai_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserService userService;

    public Appointment createAppointment (AppointmentDTO appointmentDTO) {
        return appointmentRepository.save(
                Appointment.builder()
                        .user(userService.getUser(appointmentDTO.getUserId()))
                        .time(LocalTime.now())
                        .date(LocalDate.now())
                        .reason(appointmentDTO.getReason())
                        .build()
        );
    }

    public Appointment getAppointmentById(String id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));
    }

    public List<Appointment> getAppointmentsByUserId (String userId) {
        return appointmentRepository.getAppointmentsByUser(userService.getUser(userId));
    }

    public Appointment updateAppointment(String id, Appointment appointment) {
        Appointment appointmentToUpdate = getAppointmentById(id);
        appointmentToUpdate.setReason(appointment.getReason());
        return appointmentRepository.save(appointmentToUpdate);
    }
    public void deleteAppointmentById(String id) {
        appointmentRepository.deleteById(id);
    }

    public void deleteAppointmentByUserId(String userId) {
        appointmentRepository.deleteAll(getAppointmentsByUserId(userId));
    }
}
