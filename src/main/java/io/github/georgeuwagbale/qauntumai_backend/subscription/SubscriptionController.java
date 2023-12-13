package io.github.georgeuwagbale.qauntumai_backend.subscription;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/create")
    public Subscription createSubscription (@RequestBody SubscriptionDTO subscriptionDTO) {
        return subscriptionService.createSubscription(subscriptionDTO);
    }

    @GetMapping("/{id}")
    public Subscription getSubscriptionById (@PathVariable String id) {
        return subscriptionService.getSubscriptionById(id);
    }
}
