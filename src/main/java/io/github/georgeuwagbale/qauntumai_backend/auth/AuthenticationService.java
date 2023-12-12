package io.github.georgeuwagbale.qauntumai_backend.auth;

import io.github.georgeuwagbale.qauntumai_backend.auth.dtos.AuthenticationRequest;
import io.github.georgeuwagbale.qauntumai_backend.auth.dtos.AuthenticationResponse;
import io.github.georgeuwagbale.qauntumai_backend.auth.dtos.RegistrationRequest;
import io.github.georgeuwagbale.qauntumai_backend.auth.dtos.RegistrationResponse;
import io.github.georgeuwagbale.qauntumai_backend.config.JwtService;
import io.github.georgeuwagbale.qauntumai_backend.user.LoginStatus;
import io.github.georgeuwagbale.qauntumai_backend.user.Role;
import io.github.georgeuwagbale.qauntumai_backend.user.User;
import io.github.georgeuwagbale.qauntumai_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userService.getUserByEmail(request.getEmail());
        user.setLoginStatus(LoginStatus.LOGGED_IN);
        userService.updateUser(user.getId(), user);

        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(user))
                .userId(user.getId())
                .build();
    }

    public RegistrationResponse register(RegistrationRequest request){
        userService.createUser(
                User.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.USER)
                        .loginStatus(LoginStatus.LOGGED_OUT)
                        .accountNonExpired(true)
                        .accountNonLocked(true)
                        .credentialsNonExpired(true)
                        .enabled(true)
                        .build()
        );

        return RegistrationResponse.builder()
                .message("User registered successfully")
                .build();
    }

}
