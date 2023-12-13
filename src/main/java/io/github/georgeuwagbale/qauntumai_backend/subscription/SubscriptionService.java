package io.github.georgeuwagbale.qauntumai_backend.subscription;

import io.github.georgeuwagbale.qauntumai_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;

    public Subscription createSubscription (SubscriptionDTO subscriptionDTO) {
        return subscriptionRepository.save(
                Subscription.builder()
                        .type(subscriptionDTO.getType())
                        .userId(userService.getUser(subscriptionDTO.getUserId()))
                        .build()
        );
    }

    public Subscription getSubscriptionById (String id) {
        return subscriptionRepository.findById(id).orElseThrow(() -> new SubscriptionNotFoundException(id));
    }

    public void deleteSubscription (String id) {
        subscriptionRepository.deleteById(id);
    }
}
