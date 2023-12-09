package io.github.georgeuwagbale.qauntumai_backend.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthenticationResponse login(
            @RequestBody AuthenticationRequest request
    ){
        return authenticationService.login(request);
    }

    @PostMapping("/register")
    public RegistrationResponse register(
            @RequestBody RegistrationRequest request
    ){
        return authenticationService.register(request);
    }
}
