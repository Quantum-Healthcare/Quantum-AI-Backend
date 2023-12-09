package io.github.georgeuwagbale.qauntumai_backend.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
}
