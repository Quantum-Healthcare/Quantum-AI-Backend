package io.github.georgeuwagbale.qauntumai_backend.user.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super("User with id: " + id + " not found");
    }
}
