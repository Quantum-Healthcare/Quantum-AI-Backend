package io.github.georgeuwagbale.qauntumai_backend.subscription;

public class SubscriptionNotFoundException extends RuntimeException {
    public SubscriptionNotFoundException(String id) {
        super("Subscription with " + id + " not found.");
    }
}
