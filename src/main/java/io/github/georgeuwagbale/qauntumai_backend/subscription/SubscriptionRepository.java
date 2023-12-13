package io.github.georgeuwagbale.qauntumai_backend.subscription;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
}
