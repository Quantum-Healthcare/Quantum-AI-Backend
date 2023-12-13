package io.github.georgeuwagbale.qauntumai_backend.appointment;

import io.github.georgeuwagbale.qauntumai_backend.user.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document
@Data
@Builder
public class Appointment {

    @Id
    private String id;
    private LocalDate date;
    private LocalTime time;
    private String reason;
    @DBRef
    private User user;
}
