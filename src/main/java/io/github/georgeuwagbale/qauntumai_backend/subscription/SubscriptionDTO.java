package io.github.georgeuwagbale.qauntumai_backend.subscription;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriptionDTO {
    private String userId;
    private SubscriptionType type;
}
