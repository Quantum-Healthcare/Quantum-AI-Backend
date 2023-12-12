package io.github.georgeuwagbale.qauntumai_backend.auth.dtos;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @NonNull
    private String fullName;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String password;

}
